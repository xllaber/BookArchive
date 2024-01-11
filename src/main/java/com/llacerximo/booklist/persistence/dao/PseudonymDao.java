package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.BookEntity;
import com.llacerximo.booklist.persistence.model.PseudonymEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PseudonymDao extends JpaRepository<PseudonymDao, Long> {

    List<PseudonymEntity> findAllByPseudonymContaining(String search);

}
