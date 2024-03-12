package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
import com.llacerximo.booklist.common.exception.ResourceNotFoundException;
import com.llacerximo.booklist.domain.mapper.PseudonymDomainMapper;
import com.llacerximo.booklist.domain.model.Pseudonym;
import com.llacerximo.booklist.domain.repository.PseudonymRepository;
import com.llacerximo.booklist.domain.service.PseudonymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PseudonymServiceImpl implements PseudonymService {

    @Autowired
    PseudonymRepository pseudonymRepository;

    @Override
    public PseudonymDTO findById(Long id) {
        Pseudonym pseudonym = PseudonymDomainMapper.mapper.toPseudonym(
            this.pseudonymRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pseudonimo no encontrado. ID: " + id))
        );
        return PseudonymDomainMapper.mapper.toPseudonymDTO(pseudonym);
    }

    @Override
    public PseudonymDTO insert(PseudonymDTO pseudonymDTO) {
        Pseudonym pseudonym = PseudonymDomainMapper.mapper.toPseudonym(pseudonymDTO);
        return this.pseudonymRepository.save(
            PseudonymDomainMapper.mapper.toPseudonymDTO(pseudonym)
        );
    }

    @Override
    public PseudonymDTO update(PseudonymDTO pseudonymDTO) {
        Pseudonym pseudonym = PseudonymDomainMapper.mapper.toPseudonym(
            this.pseudonymRepository.findById(pseudonymDTO.getId())
                .orElseThrow(
                    () -> new ResourceNotFoundException("Pseudononimo no encontrado. ID: " + pseudonymDTO.getId())
                )
        );
        PseudonymDomainMapper.mapper.updatePseudonymFromPseudonymDTO(pseudonymDTO, pseudonym);
        return this.pseudonymRepository.save(
            PseudonymDomainMapper.mapper.toPseudonymDTO(pseudonym)
        );
    }

    @Override
    public void delete(Long id) {
        this.pseudonymRepository.delete(id);
    }
}
