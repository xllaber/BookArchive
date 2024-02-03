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

    @Mapping(target = "rereads", expression = "java(RereadWebMapper.mapper.toRereadListWebList(bookDTO.getRereads()))")
    @Named("toBookListWeb")
    BookListWeb toBookListWeb(BookDTO bookDTO);
    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBookListWeb")
    @Named("toBookListWebList")
    List<BookListWeb> toBookListWebList(List<BookDTO> bookDTOs);

    @Mapping(target = "rereads", expression = "java(RereadWebMapper.mapper.toRereadListWebList(bookDTO.getRereads()))")
    @Mapping(target = "saga", expression = "java(SagaWebMapper.mapper.toSagaListWeb(bookDTO.getSaga()))")
    BookDetailWeb toBookDetailWeb(BookDTO bookDTO);

}
