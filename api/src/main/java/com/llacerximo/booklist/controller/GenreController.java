package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.GenreWebMapper;
import com.llacerximo.booklist.controller.model.genre.GenreRequest;
import com.llacerximo.booklist.controller.model.genre.GenreResponse;
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
                .data(GenreWebMapper.mapper.toGenreResponseList(this.genreService.findAll()))
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id) {
        return Response.builder()
                .data(GenreWebMapper.mapper.toGenreResponse(this.genreService.findById(id)))
                .build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insert(@RequestBody GenreRequest genreRequest) {
        return Response.builder()
                .data(
                    GenreWebMapper.mapper.toGenreResponse(
                        this.genreService.insert(GenreWebMapper.mapper.toGenreDTO(genreRequest))
                    )
                )
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody GenreRequest genreRequest) {
        genreRequest.setId(id);
        return Response.builder()
                .data(
                    GenreWebMapper.mapper.toGenreResponse(
                        this.genreService.update(GenreWebMapper.mapper.toGenreDTO(genreRequest))
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
