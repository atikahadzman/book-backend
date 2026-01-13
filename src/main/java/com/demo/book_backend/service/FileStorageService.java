package com.demo.book_backend.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private static final String BASE_UPLOAD_DIR =
        System.getProperty("user.dir") + File.separator + "uploads";

    public String saveFile(MultipartFile file, String folder) throws IOException {
        // book-backend/uploads/images OR pdfs
        File uploadDir = new File(BASE_UPLOAD_DIR + File.separator + folder);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileName = file.getOriginalFilename();
        File destination = new File(uploadDir, fileName);

        file.transferTo(destination);

        return folder + "/" + fileName;
    }
}