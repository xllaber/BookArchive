package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.domain.mapper.AuthorDomainMapper;
import com.llacerximo.booklist.domain.model.Author;
import com.llacerximo.booklist.domain.repository.AuthorRepository;
import com.llacerximo.booklist.domain.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<AuthorDTO> findAll() {
        List<AuthorDTO> authorDTOList = this.authorRepository.findAll();
        List<Author> authors = AuthorDomainMapper.mapper.toAuthorList(authorDTOList);
        List<AuthorDTO> authorDTOList1 = AuthorDomainMapper.mapper.toAuthorDTOList(authors);
        return authorDTOList1;
    }

    @Override
    public List<AuthorDTO> findAllByName(String search) {
        return null;
    }

    @Override
    public AuthorDTO findById(Long id) {
        return null;
    }

    @Override
    public AuthorDTO insert(AuthorDTO authorDTO) {
        return null;
    }

    @Override
    public AuthorDTO update(AuthorDTO authorDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
