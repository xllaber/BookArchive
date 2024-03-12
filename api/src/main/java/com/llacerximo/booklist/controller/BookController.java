package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.BookWebMapper;
import com.llacerximo.booklist.controller.model.book.BookCreateRequest;
import com.llacerximo.booklist.controller.model.book.BookResponse;
import com.llacerximo.booklist.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final String urlBase = "Http://localhost:8080";

    @Autowired
    BookService bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response findAllByYear(@RequestParam(required = false) Integer year){
        if (year == null) {
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
        }
        List<BookDTO> bookDTOS = bookService.findAllByFinishDate(year);
        List<BookResponse> bookResponses = BookWebMapper.mapper.toBookResponseList(bookDTOS);
        return Response.builder().data(bookResponses).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id){
        BookDTO bookDTO = this.bookService.findById(id);
        BookResponse book = BookWebMapper.mapper.toBookResponseWithGenres(bookDTO);
        return Response.builder().data(book).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insert(@RequestBody BookCreateRequest bookCreateRequest) {
        BookDTO bookDTO = this.bookService.insert(
            BookWebMapper.mapper.toBookCreateDTO(bookCreateRequest)
        );
        return Response.builder().data(
            BookWebMapper.mapper.toBookResponseFull(bookDTO)
        ).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody BookCreateRequest bookCreateRequest) {
        bookCreateRequest.setId(id);
        BookDTO bookDTO = this.bookService.update(
                BookWebMapper.mapper.toBookCreateDTOWithoutRereads(bookCreateRequest)
        );
        return Response.builder().data(
            BookWebMapper.mapper.toBookResponseFull(bookDTO)
        ).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.bookService.delete(id);
    }

}
