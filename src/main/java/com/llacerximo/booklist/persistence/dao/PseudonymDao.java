package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PseudonymDao extends JpaRepository<PseudonymDao, Long> {
}
