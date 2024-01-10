package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuthorDao extends JpaRepository<AuthorEntity, Long> {
}
