package com.llacerximo.booklist.persistence.mapper;

import com.llacerximo.booklist.common.dto.BookDTO;
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

    @Mapping(target = "rereadEntities", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Named("toBookEntity")
    BookEntity toBookEntity(BookDTO bookDTO);
    @Named("toBookEntityWithRereadsAndGenres")
    BookEntity toBookEntityWithRereads(BookDTO bookDTO);
    @Mapping(target = "rereadEntities", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBookEntity")
    @Named("toBookEntityList")
    List<BookEntity> toBookEntityList(List<BookDTO> bookDTOs);

    @Mapping(target = "rereads", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Named("toBookDTO")
    BookDTO toBookDTO(BookEntity bookEntity);
    @Named("toBookDTOWithRereads")
    BookDTO toBookDTOWithRereadsAndGenres(BookEntity bookEntity);
    @Mapping(target = "rereads", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBookDTO")
    @Named("toBookDTOList")
    List<BookDTO> toBookDTOList(List<BookEntity> bookEntities);

}
