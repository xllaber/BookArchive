package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface GenreDao extends JpaRepository<GenreEntity, Long> {
}
