package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.AuthorWebMapper;
import com.llacerximo.booklist.controller.model.author.AuthorResponse;
import com.llacerximo.booklist.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response findAll() {
        List<AuthorDTO> authorDTO = this.authorService.findAll();
        List<AuthorResponse> authorResponse = AuthorWebMapper.mapper.toAuthorResponseList(authorDTO);
        return Response.builder().data(authorResponse).build();
    }

}
