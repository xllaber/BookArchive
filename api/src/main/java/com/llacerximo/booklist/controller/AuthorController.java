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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public ResponseEntity<?> findAll(@RequestParam(required = false) String name) {
        List<AuthorResponse> authorResponseList;
        if (StringUtils.isEmpty(name)) {
            authorResponseList = AuthorWebMapper.mapper.toAuthorResponseList(this.authorService.findAll());
        } else {
            authorResponseList = AuthorWebMapper.mapper.toAuthorResponseList(this.authorService.findAllByName(name));
        }

        return new ResponseEntity<>(authorResponseList, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(
            AuthorWebMapper.mapper.toAuthorResponse(
                    this.authorService.findById(id)
            ),
            HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody AuthorCreateRequest authorCreateRequest) {
        return new ResponseEntity<>(
            AuthorWebMapper.mapper.toAuthorResponse(
                this.authorService.insert(
                    AuthorWebMapper.mapper.toAuthorDTOFromCreateRequest(authorCreateRequest)
                )
            ),
            HttpStatus.CREATED
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AuthorUpdateRequest authorRequest) {
        authorRequest.setId(id);
        return new ResponseEntity<>(
            AuthorWebMapper.mapper.toAuthorResponse(
                this.authorService.update(
                    AuthorWebMapper.mapper.toAuthorDTOFromUpdateRequest(authorRequest)
                )
            ),
            HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.authorService.delete(id);
    }

}
