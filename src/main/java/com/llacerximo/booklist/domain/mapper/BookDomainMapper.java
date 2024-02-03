package com.llacerximo.booklist.domain.mapper;

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
public interface BookDomainMapper {

    BookDomainMapper mapper = Mappers.getMapper(BookDomainMapper.class);

    @Mapping(target = "rereads", expression = "java(RereadDomainMapper.mapper.toRereadList(bookDTO.getRereads()))")
    @Mapping(target = "genres", ignore = true)
    @Named("toBook")
    Book toBook(BookDTO bookDTO);
    @Mapping(target = "rereads", expression = "java(RereadDomainMapper.mapper.toRereadList(bookDTO.getRereads()))")
    @Mapping(target = "saga", expression = "java(SagaDomainMapper.mapper.toSaga(bookDTO.getSaga()))")
    @Named("toBookWithGenres")
    Book toBookWithGenres(BookDTO bookDTO);
    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBook")
    @Named("toBookList")
    List<Book> toBookList(List<BookDTO> bookEntities);

    @Mapping(target = "genres", ignore = true)
    @Named("toBookDTO")
    BookDTO toBookDTO(Book book);
    @Named("toBookDTOWithGenres")
    BookDTO toBookDTOWithGenres(Book book);
    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBookDTO")
    @Named("toBookDTOList")
    List<BookDTO> toBookDtoList(List<Book> books);

}
