package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public interface BookDao extends JpaRepository<BookEntity, Long> {
}
