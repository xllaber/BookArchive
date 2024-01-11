package com.llacerximo.booklist.persistence.mapper;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.domain.model.Book;
import com.llacerximo.booklist.persistence.model.BookEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookPersistenceMapper {

    BookPersistenceMapper mapper = Mappers.getMapper(BookPersistenceMapper.class);

    @Mapping(target = "rereads", ignore = true)
    @Named("toBook")
    BookDTO toBookDTO(BookEntity bookEntity);
    @Named("toBookWithRereads")
    BookDTO toBookDTOWithRereads(BookEntity bookEntity);
    @Mapping(target = "rereads", ignore = true)
    @IterableMapping(qualifiedByName = "toBook")
    @Named("toBookList")
    List<BookDTO> toBookDTOList(List<BookEntity> bookEntities);

}
