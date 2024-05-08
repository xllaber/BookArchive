package com.llacerximo.booklist.domain.repository;

import org.springframework.web.multipart.MultipartFile;

public interface MultimediaRepository {

    void upload(MultipartFile file);

}
