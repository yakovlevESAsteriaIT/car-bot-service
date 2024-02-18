package ru.astieriait.bot.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@UtilityClass
@Slf4j
public class LogHelper {
    private static final ObjectMapper LOG_OBJECT_MAPPER = new ObjectMapper();

    public static String toJson(Object input) {
        try {
            return LOG_OBJECT_MAPPER.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            log.error("Cannot convert {} to json string...", StringUtils.truncate(input.toString(), 100));
            return "";
        }
    }
}
