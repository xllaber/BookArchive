package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.GenreWebMapper;
import com.llacerximo.booklist.controller.model.genre.GenreRequest;
import com.llacerximo.booklist.controller.model.genre.GenreResponse;
import com.llacerximo.booklist.domain.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(
            GenreWebMapper.mapper.toGenreResponseList(this.genreService.findAll()),
            HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(
            GenreWebMapper.mapper.toGenreResponse(this.genreService.findById(id)),
            HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody GenreRequest genreRequest) {
        return new ResponseEntity<>(
            GenreWebMapper.mapper.toGenreResponse(
                this.genreService.insert(GenreWebMapper.mapper.toGenreDTO(genreRequest))
            ),
            HttpStatus.CREATED
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody GenreRequest genreRequest) {
        genreRequest.setId(id);
        return new ResponseEntity<>(
            GenreWebMapper.mapper.toGenreResponse(
                this.genreService.update(GenreWebMapper.mapper.toGenreDTO(genreRequest))
            ),
            HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.genreService.delete(id);
    }

}
