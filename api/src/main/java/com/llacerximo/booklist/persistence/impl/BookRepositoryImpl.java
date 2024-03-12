package com.llacerximo.booklist.persistence.impl;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.common.dto.SagaDTO;
import com.llacerximo.booklist.common.exception.ResourceNotFoundException;
import com.llacerximo.booklist.domain.repository.BookRepository;
import com.llacerximo.booklist.persistence.dao.BookDao;
import com.llacerximo.booklist.persistence.mapper.BookPersistenceMapper;
import com.llacerximo.booklist.persistence.mapper.SagaPersistenceMapper;
import com.llacerximo.booklist.persistence.model.BookEntity;
import jakarta.transaction.Transactional;
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
    public List<BookDTO> findAllByFinishDate(Integer year) {
        List<BookEntity> books = bookDao.findAllByFinishDate(year);
        List<BookDTO> bookDTOS = BookPersistenceMapper.mapper.toBookDTOList(books);
        return bookDTOS;
    }

    @Override
    public Optional<BookDTO> findById(Long id) {
        Optional<BookEntity> bookEntity = this.bookDao.findById(id);
        BookDTO bookDTO = BookPersistenceMapper.mapper.toBookDTOWithGenres(bookEntity.get());
        return Optional.of(bookDTO);
    }

    @Override
    public List<BookDTO> findAllByFaveTrue() {
        return null;
    }

    @Override
    public List<BookDTO> findAllBySagaId(Long id) {
        return BookPersistenceMapper.mapper.toBookDTOList(this.bookDao.findAllBySagaEntityId(id));
    }

    @Override
    public List<BookDTO> findLastFiveRead() {
        return null;
    }

    @Override
    public Optional<BookDTO> findByName(String search) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public BookDTO save(BookDTO bookDTO) {
        return BookPersistenceMapper.mapper.toBookDTOWithGenres(
            this.bookDao.save(
                BookPersistenceMapper.mapper.toBookEntityWithGenres(bookDTO)
            )
        );
    }

    @Override
    public void delete(Long id) {
        this.bookDao.deleteById(id);
    }

}
