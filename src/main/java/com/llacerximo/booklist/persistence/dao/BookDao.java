package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.BookEntity;
import com.llacerximo.booklist.persistence.model.RereadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Component
public interface BookDao extends JpaRepository<BookEntity, Long> {

    @Query(nativeQuery = true,
    value = "SELECT * FROM books WHERE YEAR(finish_date) = :year")
    List<BookEntity> findAllByFinishDate(@Param("year") Integer year);
    List<BookEntity> findAllByFaveTrue();
    List<BookEntity> findAllByPseudonymEntityId(Long id);
    List<BookEntity> findAllBySagaEntityId(Long id);
    @Query(nativeQuery = true,
    value = "select * from books order by finish_date limit 5")
    List<BookEntity> findLastFiveRead();

}
