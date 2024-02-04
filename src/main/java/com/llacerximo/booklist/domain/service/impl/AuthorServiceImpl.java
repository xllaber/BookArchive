package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.AuthorDTO;
import com.llacerximo.booklist.common.exception.ResourceNotFoundException;
import com.llacerximo.booklist.controller.mapper.AuthorWebMapper;
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
        return AuthorDomainMapper.mapper.toAuthorDTOList(
            AuthorDomainMapper.mapper.toAuthorList(
                    this.authorRepository.findAll()
            )
        );
    }

    @Override
    public List<AuthorDTO> findAllByName(String name) {
        return AuthorDomainMapper.mapper.toAuthorDTOList(
            AuthorDomainMapper.mapper.toAuthorList(
                    this.authorRepository.findAllByName(name)
            )
        );
    }

    @Override
    public AuthorDTO findById(Long id) {
        return AuthorDomainMapper.mapper.toAuthorDTO(
            AuthorDomainMapper.mapper.toAuthor(
                this.authorRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado. ID: " + id))
            )
        );
    }

    @Override
    public AuthorDTO insert(AuthorDTO authorDTO) {
        Author author = AuthorDomainMapper.mapper.toAuthor(authorDTO);
        return this.authorRepository.save(AuthorDomainMapper.mapper.toAuthorDTO(author));
    }

    @Override
    public AuthorDTO update(AuthorDTO authorDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
