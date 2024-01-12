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

    @Mapping(target = "rereads", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Named("toBook")
    Book toBook(BookDTO bookDTO);
    @Named("toBookWithRereads")
    Book toBookDTOWithRereadsAndGenres(BookDTO bookDTO);
    @Mapping(target = "rereads", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBook")
    @Named("toBookList")
    List<Book> toBookList(List<BookDTO> bookEntities);

    @Mapping(target = "rereads", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @Named("toBookDTO")
    BookDTO toBookDTO(Book book);
    @Named("toBookDtoWithRereadsAndGenres")
    BookDTO toBookDtoWithRereadsAndGenres(Book book);
    @Mapping(target = "rereads", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBookDTO")
    @Named("toBookDTOList")
    List<BookDTO> toBookDtoList(List<Book> books);

}
