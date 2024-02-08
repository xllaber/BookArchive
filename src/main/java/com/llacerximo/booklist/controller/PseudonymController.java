package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.http_response.Response;
import com.llacerximo.booklist.controller.mapper.PseudonymWebMapper;
import com.llacerximo.booklist.controller.model.pseudonym.PseudonymRequest;
import com.llacerximo.booklist.controller.model.pseudonym.PseudonymResponse;
import com.llacerximo.booklist.domain.service.PseudonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pseudonyms")
public class PseudonymController {

    @Autowired
    PseudonymService pseudonymService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insert(@RequestBody PseudonymRequest pseudonymRequest) {
        PseudonymResponse response = PseudonymWebMapper.mapper.toPseudonymResponse(
            this.pseudonymService.insert(
                PseudonymWebMapper.mapper.toPseudonymDTO(pseudonymRequest)
            )
        );
        return Response.builder().data(response).build();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Response update(@PathVariable Long id, @RequestBody PseudonymRequest pseudonymRequest) {
        pseudonymRequest.setId(id);
        PseudonymResponse response = PseudonymWebMapper.mapper.toPseudonymResponse(
            this.pseudonymService.update(
                PseudonymWebMapper.mapper.toPseudonymDTO(pseudonymRequest)
            )
        );
        return Response.builder().data(response).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.pseudonymService.delete(id);
    }

}
