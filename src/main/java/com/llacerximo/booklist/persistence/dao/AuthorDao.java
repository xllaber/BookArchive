package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorDao extends JpaRepository<AuthorEntity, Long> {

    List<AuthorEntity> findByNameContaining(String name);

}
