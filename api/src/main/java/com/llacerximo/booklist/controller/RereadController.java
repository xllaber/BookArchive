package com.llacerximo.booklist.controller;

import com.llacerximo.booklist.common.dto.RereadDTO;
import com.llacerximo.booklist.controller.mapper.RereadWebMapper;
import com.llacerximo.booklist.controller.model.reread.RereadCreateRequest;
import com.llacerximo.booklist.controller.model.reread.RereadResponse;
import com.llacerximo.booklist.domain.service.RereadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"http://localhost:4200"})
@RequestMapping("/rereads")
public class RereadController {

    @Autowired
    RereadService rereadService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        RereadDTO dto = this.rereadService.getById(id);
        RereadResponse response = RereadWebMapper.mapper.toRereadResponse(dto);
        return new ResponseEntity<>(RereadWebMapper.mapper.toRereadResponse(this.rereadService.getById(id)), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody RereadCreateRequest request) {
        return new ResponseEntity<>(
                RereadWebMapper.mapper.toRereadResponse(
                        this.rereadService.insert(RereadWebMapper.mapper.toRereadDTOFromCreateRequest(request))
                ),
                HttpStatus.CREATED
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RereadCreateRequest request) {
        request.setId(id);
        return new ResponseEntity<>(
                RereadWebMapper.mapper.toRereadResponse(
                        this.rereadService.update(RereadWebMapper.mapper.toRereadDTOFromCreateRequest(request))
                ),
                HttpStatus.CREATED
        );
    }

}
