package com.llacerximo.booklist.domain.service;

import org.springframework.web.multipart.MultipartFile;

public interface MultimediaService {

    void upload(MultipartFile file);

}
