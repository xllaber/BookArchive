package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.BookWebMapper;
import com.llacerximo.booklist.controller.model.book.BookDetailWeb;
import com.llacerximo.booklist.controller.model.book.BookListWeb;
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
    public Response findAllByYear(@RequestParam Integer year){
        if (year == null) {
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
        }
        List<BookDTO> bookDTOS = bookService.findAllByFinishDate(year);
        List<BookListWeb> bookListWebs = BookWebMapper.mapper.toBookListWebList(bookDTOS);
        return Response.builder().data(bookListWebs).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id){
        BookDTO bookDTO = this.bookService.findById(id);
        BookDetailWeb book = BookWebMapper.mapper.toBookDetailWeb(bookDTO);
        return Response.builder().data(book).build();
    }
}
