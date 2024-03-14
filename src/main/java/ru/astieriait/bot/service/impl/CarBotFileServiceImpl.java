package ru.astieriait.bot.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.astieriait.bot.exception.CarBotServiceException;
import ru.astieriait.bot.exception.ExceptionDetails;
import ru.astieriait.bot.service.CarBotFileService;
import ru.astieriait.bot.service.GoogleDriveService;
import ru.astieriait.bot.telegram.CarTelegramWebhookBot;

import java.io.InputStream;

@Slf4j
@Service
public class CarBotFileServiceImpl implements CarBotFileService {
    @Lazy
    @Autowired
    private CarTelegramWebhookBot bot;
    @Autowired
    private GoogleDriveService googleDriveService;

    @Override
    @Async
    public void transferFileFromTelegramToGoogleDrive(String filename) {
        try (InputStream videoInputStream = getVideoFromTelegramInputStream(filename)) {
            var fileId = googleDriveService.uploadFile(filename, videoInputStream);
        } catch (Exception ex) {
            throw new CarBotServiceException(ExceptionDetails.VIDEO_TELEGRAM_DOWNLOAD_FAILED, filename, ex);
        }
    }

    private InputStream getVideoFromTelegramInputStream(String filePath) throws TelegramApiException {
        return bot.downloadFileAsStream(filePath);
    }
}
