package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.controller.mapper.BookWebMapper;
import com.llacerximo.booklist.controller.mapper.SagaWebMapper;
import com.llacerximo.booklist.controller.model.saga.SagaRequest;
import com.llacerximo.booklist.domain.service.BookService;
import com.llacerximo.booklist.domain.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("/sagas")
public class SagaController {

    @Autowired
    SagaService sagaService;
    @Autowired
    BookService bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public ResponseEntity<?> findAll(@RequestParam(required = false) String search) {
        if (search != null && !search.trim().isEmpty()){
            return new ResponseEntity<>(
                SagaWebMapper.mapper.toSagaResponseList(this.sagaService.findByName(search)),
                HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                SagaWebMapper.mapper.toSagaResponseList(this.sagaService.findAll()),
                HttpStatus.OK
            );
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(
            SagaWebMapper.mapper.toSagaResponse(this.sagaService.findById(id)),
            HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/books")
    public ResponseEntity<?> findBooksBySagaId(@PathVariable Long id) {
        return new ResponseEntity<>(
            BookWebMapper.mapper.toBookResponseList(this.bookService.findAllBySagaId(id)),
            HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody SagaRequest sagaRequest) {
        SagaDTO sagaDTO = this.sagaService.insert(SagaWebMapper.mapper.toSagaDTO(sagaRequest));
        return new ResponseEntity<>(
                SagaWebMapper.mapper.toSagaResponse(sagaDTO),
                HttpStatus.CREATED
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SagaRequest sagaRequest) {
        sagaRequest.setId(id);
        return new ResponseEntity<>(
                SagaWebMapper.mapper.toSagaResponse(
                        this.sagaService.update(SagaWebMapper.mapper.toSagaDTO(sagaRequest))
                ),
            HttpStatus.OK
        );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.sagaService.delete(id);
    }

}
