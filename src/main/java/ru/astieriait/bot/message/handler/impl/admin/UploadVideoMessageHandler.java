package ru.astieriait.bot.message.handler.impl.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.astieriait.bot.message.handler.CarBotMessageHandler;
import ru.astieriait.bot.service.CarBotFileService;
import ru.astieriait.bot.service.ManagerService;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class UploadVideoMessageHandler implements CarBotMessageHandler {
    private final ManagerService managerService;
    private final CarBotFileService carBotFileService;

    @Override
    public BotApiMethod<?> handleMessage(Update update) {
        log.info("[UploadVideoMessageHandler] video {} is uploaded by user {}. Transfer is started");
        carBotFileService.transferFileFromTelegramToGoogleDrive(update.getMessage().getVideo().getFileId());
        return new SendMessage(update.getMessage().getChatId().toString(), "Видео в процессе загрузки");
    }

    @Override
    public boolean isApplied(Update update) {
        log.info("Check message for apply to handler [UploadVideoMessageHandler]. isCallback={} text={}", update.hasCallbackQuery(), update.getMessage().getText());
        var result = Boolean.FALSE.equals(update.hasCallbackQuery())
                && Objects.equals(update.getMessage().getText(), "/upload-video")
                && managerService.isManagerExists(update.getMessage().getChat().getUserName());
        log.info("[UploadVideoMessageHandler] isApplied={}", result);
        return result;
    }
}
