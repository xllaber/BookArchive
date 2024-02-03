package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.SagaWebMapper;
import com.llacerximo.booklist.controller.model.saga.SagaDetailWeb;
import com.llacerximo.booklist.controller.model.saga.SagaListWeb;
import com.llacerximo.booklist.domain.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sagas")
public class SagaController {

    @Autowired
    SagaService sagaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response findAll(@RequestParam(required = false) String search) {
        if (search != null && !search.trim().isEmpty()){
            return Response.builder().data(SagaWebMapper.mapper.toSagaListWebList(this.sagaService.findByName(search))).build();
        } else {
            return Response.builder().data(SagaWebMapper.mapper.toSagaListWebList(this.sagaService.findAll())).build();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response findById(@PathVariable Long id) {
        return Response.builder()
                .data(SagaWebMapper.mapper.toSagaListWeb(this.sagaService.findById(id)))
                .build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insert(@RequestBody SagaListWeb sagaListWeb) {
        SagaDTO sagaDTO = this.sagaService.insert(SagaWebMapper.mapper.toSagaDTO(sagaListWeb));
        return Response.builder().data(SagaWebMapper.mapper.toSagaListWeb(sagaDTO)).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody SagaListWeb sagaListWeb) {
        sagaListWeb.setId(id);
        return Response.builder()
                .data(
                    SagaWebMapper.mapper.toSagaListWeb(
                        this.sagaService.update(SagaWebMapper.mapper.toSagaDTO(sagaListWeb))
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
