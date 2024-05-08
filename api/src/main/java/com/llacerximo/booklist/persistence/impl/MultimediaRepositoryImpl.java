package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.domain.repository.MultimediaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Repository
public class MultimediaRepositoryImpl implements MultimediaRepository {

    private final String path = "templates/img";

    @Override
    public void upload(MultipartFile file) {

        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
