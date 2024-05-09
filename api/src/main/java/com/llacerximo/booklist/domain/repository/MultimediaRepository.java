package com.llacerximo.booklist.domain.repository;

import com.llacerximo.booklist.controller.model.multimedia.MultimediaUploadRequest;
import org.springframework.web.multipart.MultipartFile;

public interface MultimediaRepository {

    String upload(MultipartFile request);

}
