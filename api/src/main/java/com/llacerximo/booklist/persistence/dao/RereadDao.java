package com.llacerximo.booklist.persistence.dao;

import com.llacerximo.booklist.persistence.model.RereadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RereadDao extends JpaRepository<RereadEntity, Long> {
}
