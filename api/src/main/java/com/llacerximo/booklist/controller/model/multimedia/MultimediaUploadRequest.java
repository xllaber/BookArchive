package com.llacerximo.booklist.controller.model.multimedia;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaUploadRequest {

    private String fileName;
    private MultipartFile file;

}
