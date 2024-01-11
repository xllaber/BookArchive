package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.domain.repository.BookRepository;
import com.llacerximo.booklist.persistence.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    BookDao bookDao;

    @Override
    public List<BookDTO> findAllByFinishDate(Date finishDate) {
        return null;
    }

    @Override
    public List<BookDTO> findAllByFaveTrue() {
        return null;
    }

    @Override
    public List<BookDTO> findAllByPseudonymId(Long id) {
        return null;
    }

    @Override
    public List<BookDTO> findAllBySagaId(Long id) {
        return null;
    }

    @Override
    public List<BookDTO> findLastFiveRead() {
        return null;
    }

    @Override
    public Optional<BookDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<BookDTO> findByName(String search) {
        return Optional.empty();
    }

}
