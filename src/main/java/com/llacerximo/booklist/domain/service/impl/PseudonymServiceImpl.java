package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.PseudonymDTO;
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
    public List<PseudonymDTO> findAll() {
        return null;
    }

    @Override
    public Optional<PseudonymDTO> findByName(String search) {
        return Optional.empty();
    }

    @Override
    public Optional<PseudonymDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<PseudonymDTO> findByBookId(Long bookId) {
        PseudonymDTO pseudonymDTO = this.pseudonymRepository.findByBookId(bookId).get();
        Pseudonym pseudonym = PseudonymDomainMapper.mapper.toPseudonym(pseudonymDTO);
        PseudonymDTO pseudonymDTO1 = PseudonymDomainMapper.mapper.toPseudonymDTO(pseudonym);
        return Optional.empty();
    }
}
