package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.BookWebMapper;
import com.llacerximo.booklist.controller.mapper.SagaWebMapper;
import com.llacerximo.booklist.controller.model.saga.SagaRequest;
import com.llacerximo.booklist.controller.model.saga.SagaResponse;
import com.llacerximo.booklist.domain.mapper.BookDomainMapper;
import com.llacerximo.booklist.domain.service.BookService;
import com.llacerximo.booklist.domain.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sagas")
public class SagaController {

    @Autowired
    SagaService sagaService;
    @Autowired
    BookService bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response findAll(@RequestParam(required = false) String search) {
        if (search != null && !search.trim().isEmpty()){
            return Response.builder().data(SagaWebMapper.mapper.toSagaResponseList(this.sagaService.findByName(search))).build();
        } else {
            return Response.builder().data(SagaWebMapper.mapper.toSagaResponseList(this.sagaService.findAll())).build();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id) {
        return Response.builder()
                .data(SagaWebMapper.mapper.toSagaResponse(this.sagaService.findById(id)))
                .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/books")
    public Response findBooksBySagaId(@PathVariable Long id) {
        return Response.builder()
                .data(BookWebMapper.mapper.toBookResponseList(this.bookService.findAllBySagaId(id)))
                .build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insert(@RequestBody SagaRequest sagaRequest) {
        SagaDTO sagaDTO = this.sagaService.insert(SagaWebMapper.mapper.toSagaDTO(sagaRequest));
        return Response.builder().data(SagaWebMapper.mapper.toSagaResponse(sagaDTO)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody SagaRequest sagaRequest) {
        sagaRequest.setId(id);
        return Response.builder()
                .data(
                    SagaWebMapper.mapper.toSagaResponse(
                        this.sagaService.update(SagaWebMapper.mapper.toSagaDTO(sagaRequest))
                    )
                )
                .build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.sagaService.delete(id);
    }

}
