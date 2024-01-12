package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.controller.model.book.BookDetailWeb;
import com.llacerximo.booklist.controller.model.book.BookListWeb;
import com.llacerximo.booklist.persistence.model.BookEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookWebMapper {

    BookWebMapper mapper = Mappers.getMapper(BookWebMapper.class);

    @Named("toBookListWeb")
    BookListWeb toBookListWeb(BookDTO bookDTO);
    @Mapping(target = "rereads", ignore = true)
    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBookListWeb")
    @Named("toBookListWebList")
    List<BookListWeb> toBookListWebList(List<BookDTO> bookDTOs);

    BookDetailWeb toBookDetailWeb(BookDTO bookDTO);

}
