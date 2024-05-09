package com.llacerximo.booklist.domain.service;

import com.llacerximo.booklist.controller.model.multimedia.MultimediaUploadRequest;
import org.springframework.web.multipart.MultipartFile;

public interface MultimediaService {

    String upload(MultipartFile request);

}
