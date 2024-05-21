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

    @Mapping(target = "rereadEntities", expression = "java(RereadPersistenceMapper.mapper.toRereadEntityList(bookDTO.getRereads()))")
    @Mapping(target = "sagaEntity", expression = "java(SagaPersistenceMapper.mapper.toSagaEntity(bookDTO.getSaga() != null ? bookDTO.getSaga() : null))")
    @Mapping(target = "authorEntities", expression = "java(AuthorPersistenceMapper.mapper.toAuthorEntityList(bookDTO.getAuthors()))")
    @Mapping(target = "genreEntities", ignore = true)
    @Named("toBookEntity")
    BookEntity toBookEntity(BookDTO bookDTO);
    @Mapping(target = "rereadEntities", expression = "java(RereadPersistenceMapper.mapper.toRereadEntityList(bookDTO.getRereads()))")
    @Mapping(target = "sagaEntity", expression = "java(SagaPersistenceMapper.mapper.toSagaEntity(bookDTO.getSaga() != null ? bookDTO.getSaga() : null))")
    @Mapping(target = "authorEntities", expression = "java(AuthorPersistenceMapper.mapper.toAuthorEntityList(bookDTO.getAuthors()))")
    @Mapping(target = "genreEntities", expression = "java(GenrePersistenceMapper.mapper.toGenreEntityList(bookDTO.getGenres()))")
    @Named("toBookEntityWithGenres")
    BookEntity toBookEntityWithGenres(BookDTO bookDTO);

    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBookEntity")
    @Named("toBookEntityList")
    List<BookEntity> toBookEntityList(List<BookDTO> bookDTOs);

    @Mapping(target = "rereads", expression = "java(RereadPersistenceMapper.mapper.toRereadDTOList(bookEntity.getRereadEntities()))")
    @Mapping(target = "saga", expression = "java(SagaPersistenceMapper.mapper.toSagaDTO(bookEntity.getSagaEntity() != null ? bookEntity.getSagaEntity() : null))")
    @Mapping(target = "authors", expression = "java(AuthorPersistenceMapper.mapper.toAuthorDTOList(bookEntity.getAuthorEntities()))")
    @Mapping(target = "genres", ignore = true)
    @Named("toBookDTO")
    BookDTO toBookDTO(BookEntity bookEntity);
    @Mapping(target = "rereads", expression = "java(RereadPersistenceMapper.mapper.toRereadDTOList(bookEntity.getRereadEntities()))")
    @Mapping(target = "saga", expression = "java(SagaPersistenceMapper.mapper.toSagaDTO(bookEntity.getSagaEntity() != null ? bookEntity.getSagaEntity() : null))")
    @Mapping(target = "authors", expression = "java(AuthorPersistenceMapper.mapper.toAuthorDTOList(bookEntity.getAuthorEntities()))")
    @Mapping(target = "genres", expression = "java(GenrePersistenceMapper.mapper.toGenreDTOList(bookEntity.getGenreEntities()))")
    @Named("toBookDTOWithGenres")
    BookDTO toBookDTOWithGenres(BookEntity bookEntity);

    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBookDTO")
    @Named("toBookDTOList")
    List<BookDTO> toBookDTOList(List<BookEntity> bookEntities);

}
