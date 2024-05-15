package com.llacerximo.booklist.domain.service.impl;

import com.llacerximo.booklist.common.dto.RereadDTO;
import com.llacerximo.booklist.common.exception.ResourceNotFoundException;
import com.llacerximo.booklist.domain.mapper.RereadDomainMapper;
import com.llacerximo.booklist.domain.model.Reread;
import com.llacerximo.booklist.domain.repository.RereadRepository;
import com.llacerximo.booklist.domain.service.RereadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.time.temporal.ChronoUnit;

@Service
public class RereadServiceImpl implements RereadService {

    @Autowired
    RereadRepository rereadRepository;

    @Override
    public RereadDTO getById(Long id) {
        Reread reread = RereadDomainMapper.mapper.toReread(this.rereadRepository.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe la relectura con id: " + id))
        );
        reread.setReadTime(Period.between(reread.getStartDate(), reread.getFinishDate()).getDays() * 24);
        return RereadDomainMapper.mapper.toRereadDTO(reread);
    }

    @Override
    public RereadDTO insert(RereadDTO rereadDTO) {
        Reread created = RereadDomainMapper.mapper.toReread(
                this.rereadRepository.save(rereadDTO)
        );
        created.setReadTime(Period.between(created.getStartDate(), created.getFinishDate()).getDays() * 24);
        return RereadDomainMapper.mapper.toRereadDTO(created);
    }

    @Override
    public RereadDTO update(RereadDTO rereadDTO) {
        Reread existing = RereadDomainMapper.mapper.toReread(
                this.rereadRepository.getById(rereadDTO.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("No existe la relectura con id: " + rereadDTO.getId()))
        );
        existing.setImpressions(rereadDTO.getImpressions());
        existing.setFinishDate(rereadDTO.getFinishDate());
        existing.setStartDate(rereadDTO.getStartDate());
        existing.setBookId(rereadDTO.getId());
        Reread updated = RereadDomainMapper.mapper.toReread(
                this.rereadRepository.save(RereadDomainMapper.mapper.toRereadDTO(existing))
        );
        updated.setReadTime(Period.between(updated.getStartDate(), updated.getFinishDate()).getDays() * 24);
        return RereadDomainMapper.mapper.toRereadDTO(updated);
    }

}
