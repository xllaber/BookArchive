package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.GenreWebMapper;
import com.llacerximo.booklist.controller.model.genre.GenreWeb;
import com.llacerximo.booklist.domain.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response findAll() {
        return Response.builder()
                .data(GenreWebMapper.mapper.toGenreWebList(this.genreService.findAll()))
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id) {
        return Response.builder()
                .data(GenreWebMapper.mapper.toGenreWeb(this.genreService.findById(id)))
                .build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insert(@RequestBody GenreWeb genreWeb) {
        return Response.builder()
                .data(
                    GenreWebMapper.mapper.toGenreWeb(
                        this.genreService.insert(GenreWebMapper.mapper.toGenreDTO(genreWeb))
                    )
                )
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody GenreWeb genreWeb) {
        genreWeb.setId(id);
        return Response.builder()
                .data(
                    GenreWebMapper.mapper.toGenreWeb(
                        this.genreService.update(GenreWebMapper.mapper.toGenreDTO(genreWeb))
                    )
                )
                .build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.genreService.delete(id);
    }

}
