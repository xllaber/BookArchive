package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.controller.model.multimedia.MultimediaUploadRequest;
import com.llacerximo.booklist.domain.repository.MultimediaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public class MultimediaRepositoryImpl implements MultimediaRepository {

    private final String PATH = "resources/img";

    @Override
    public String upload(MultipartFile request) {
        Path savePath = Paths.get(PATH + request.getOriginalFilename());
        try {
            Files.copy(request.getInputStream(), savePath);
            return "Success";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error";
        }
    }

}
