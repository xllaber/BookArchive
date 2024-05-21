package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.BookEntity;
import com.llacerximo.booklist.persistence.model.PseudonymEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PseudonymDao extends JpaRepository<PseudonymEntity, Long> {

    List<PseudonymEntity> findAllByPseudonymContaining(String search);
    @Query(nativeQuery = true,
            value = "SELECT ab.id, ab.pseudonym FROM authors_books ab WHERE ab.book_id = :bookId")
    Optional<PseudonymEntity> findByBookEntityId(@Param("bookId") Long bookId);

}
