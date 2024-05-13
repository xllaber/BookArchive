package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.controller.mapper.BookWebMapper;
import com.llacerximo.booklist.controller.model.book.BookCreateRequest;
import com.llacerximo.booklist.controller.model.book.BookResponse;
import com.llacerximo.booklist.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("/books")
public class BookController {

    private final String urlBase = "Http://localhost:8080";

    @Autowired
    BookService bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public ResponseEntity<?> findAllByYear(@RequestParam(required = false) Integer year){
        if (year == null) {
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
        }
        List<BookDTO> bookDTOS = bookService.findAllByFinishDate(year);
        List<BookResponse> bookResponses = BookWebMapper.mapper.toBookResponseList(bookDTOS);
        return new ResponseEntity<>(bookResponses, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<BookDTO> bookDTOS = bookService.findAll();
        List<BookResponse> bookResponses = BookWebMapper.mapper.toBookResponseList(bookDTOS);
        return new ResponseEntity<>(bookResponses, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        BookDTO bookDTO = this.bookService.findById(id);
        BookResponse book = BookWebMapper.mapper.toBookResponseWithGenres(bookDTO);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/favorite")
    public ResponseEntity<?> findAllFavBooks() {
        return new ResponseEntity<>(
                BookWebMapper.mapper.toBookResponseList(this.bookService.findAllFave()),
                HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/last")
    public ResponseEntity<?> findLastReadBooks() {
        return new ResponseEntity<>(
                BookWebMapper.mapper.toBookResponseList(this.bookService.findLastReadBooks()),
                HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody BookCreateRequest bookCreateRequest) {
        BookDTO bookDTO = this.bookService.insert(
            BookWebMapper.mapper.toBookCreateDTO(bookCreateRequest)
        );
        return new ResponseEntity<>(
                BookWebMapper.mapper.toBookResponseFull(bookDTO),
                HttpStatus.CREATED
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BookCreateRequest bookCreateRequest) {
        bookCreateRequest.setId(id);
        BookDTO bookDTO = this.bookService.update(
                BookWebMapper.mapper.toBookCreateDTOWithoutRereads(bookCreateRequest)
        );
        return new ResponseEntity<>(
                BookWebMapper.mapper.toBookResponseFull(bookDTO),
                HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.bookService.delete(id);
    }

}
