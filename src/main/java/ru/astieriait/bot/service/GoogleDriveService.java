package ru.astieriait.bot.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;

public interface GoogleDriveService {
    String getFiles() throws IOException, GeneralSecurityException;

    String uploadFile(MultipartFile multipartFile);
    String uploadFile(String filename, InputStream inputStream);
}
