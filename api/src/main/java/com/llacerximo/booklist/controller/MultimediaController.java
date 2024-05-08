package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.domain.service.MultimediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("/multimedia")
public class MultimediaController {

    @Autowired
    MultimediaService multimediaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/upload")
    public void upload(@RequestBody MultipartFile file) {
        this.multimediaService.upload(file);
    }

}
