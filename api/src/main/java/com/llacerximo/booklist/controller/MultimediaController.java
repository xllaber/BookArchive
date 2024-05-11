package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.controller.model.multimedia.MultimediaUploadRequest;
import com.llacerximo.booklist.domain.service.MultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("/multimedia")
public class MultimediaController {

    @Autowired
    MultimediaService multimediaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public String upload(@RequestBody MultimediaUploadRequest request) {
        return "Prueba";
//        return this.multimediaService.upload(request);
    }

}