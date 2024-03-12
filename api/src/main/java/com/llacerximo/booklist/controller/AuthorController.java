package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.AuthorWebMapper;
import com.llacerximo.booklist.controller.model.author.AuthorCreateRequest;
import com.llacerximo.booklist.controller.model.author.AuthorResponse;
import com.llacerximo.booklist.controller.model.author.AuthorUpdateRequest;
import com.llacerximo.booklist.domain.service.AuthorService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response findAll(@RequestParam(required = false) String name) {
        List<AuthorResponse> authorResponseList;
        if (StringUtils.isEmpty(name)) {
            authorResponseList = AuthorWebMapper.mapper.toAuthorResponseList(this.authorService.findAll());
        } else {
            authorResponseList = AuthorWebMapper.mapper.toAuthorResponseList(this.authorService.findAllByName(name));
        }

        return Response.builder().data(authorResponseList).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id) {
        return Response.builder()
            .data(
                AuthorWebMapper.mapper.toAuthorResponse(
                    this.authorService.findById(id)
                )
            )
            .build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insert(@RequestBody AuthorCreateRequest authorCreateRequest) {
        return Response.builder()
            .data(
                AuthorWebMapper.mapper.toAuthorResponse(
                    this.authorService.insert(
                        AuthorWebMapper.mapper.toAuthorDTOFromCreateRequest(authorCreateRequest)
                    )
                )
            )
            .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody AuthorUpdateRequest authorRequest) {
        authorRequest.setId(id);
        return Response.builder()
            .data(
                AuthorWebMapper.mapper.toAuthorResponse(
                    this.authorService.update(
                        AuthorWebMapper.mapper.toAuthorDTOFromUpdateRequest(authorRequest)
                    )
                )
            )
            .build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.authorService.delete(id);
    }

}
