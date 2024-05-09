package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.exception.FileException;
import com.llacerximo.booklist.controller.model.multimedia.MultimediaUploadRequest;
import com.llacerximo.booklist.domain.repository.MultimediaRepository;
import com.llacerximo.booklist.domain.service.MultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
public class MultimediaServiceImpl implements MultimediaService {

    @Autowired
    MultimediaRepository multimediaRepository;

    @Override
    public void upload(MultimediaUploadRequest request) {
        if (!(Objects.equals(request.getFile().getContentType(), "image/JPEG"))) {
            throw new FileException("Formato incorrecto");
        }
        if (request.getFile().isEmpty()) {
            throw new FileException("El archivo esta vacio");
        }
    }

}
