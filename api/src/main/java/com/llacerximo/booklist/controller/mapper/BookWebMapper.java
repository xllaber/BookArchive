package com.llacerximo.booklist.controller.mapper;

import com.llacerximo.booklist.common.dto.BookCreateDTO;
import com.llacerximo.booklist.common.dto.BookDTO;
import com.llacerximo.booklist.controller.model.book.BookCreateRequest;
import com.llacerximo.booklist.controller.model.book.BookResponseFull;
import com.llacerximo.booklist.controller.model.book.BookResponse;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookWebMapper {

    BookWebMapper mapper = Mappers.getMapper(BookWebMapper.class);

    @Mapping(target = "rereads", expression = "java(RereadWebMapper.mapper.toRereadResponseList(bookDTO.getRereads()))")
    @Mapping(target = "saga", expression = "java(SagaWebMapper.mapper.toSagaResponse(bookDTO.getSaga()))")
    @Mapping(target = "authors", expression = "java(AuthorWebMapper.mapper.toAuthorResponseList(bookDTO.getAuthors()))")
    @Mapping(target = "genres", ignore = true)
    @Named("toBookResponse")
    BookResponse toBookResponse(BookDTO bookDTO);
    @Mapping(target = "rereads", expression = "java(RereadWebMapper.mapper.toRereadResponseList(bookDTO.getRereads()))")
    @Mapping(target = "saga", expression = "java(SagaWebMapper.mapper.toSagaResponse(bookDTO.getSaga()))")
    @Mapping(target = "authors", expression = "java(AuthorWebMapper.mapper.toAuthorResponseList(bookDTO.getAuthors()))")
    @Mapping(target = "genres", expression = "java(GenreWebMapper.mapper.toGenreResponseList(bookDTO.getGenres()))")
    @Named("toBookResponseWithGenres")
    BookResponse toBookResponseWithGenres(BookDTO bookDTO);
    @Mapping(target = "genres", ignore = true)
    @IterableMapping(qualifiedByName = "toBookResponse")
    @Named("toBookResponseList")
    List<BookResponse> toBookResponseList(List<BookDTO> bookDTOs);

    @Mapping(target = "rereads", expression = "java(RereadWebMapper.mapper.toRereadResponseList(bookDTO.getRereads()))")
    @Mapping(target = "saga", expression = "java(SagaWebMapper.mapper.toSagaResponse(bookDTO.getSaga()))")
    @Mapping(target = "authors", expression = "java(AuthorWebMapper.mapper.toAuthorResponseList(bookDTO.getAuthors()))")
    @Mapping(target = "genres", expression = "java(GenreWebMapper.mapper.toGenreResponseList(bookDTO.getGenres()))")
    BookResponseFull toBookResponseFull(BookDTO bookDTO);

    @Mapping(target = "rereadDTO", expression = "java(RereadWebMapper.mapper.toRereadDTOFromCreateRequest(bookCreateRequest.getRereadCreateRequest()))")
    BookCreateDTO toBookCreateDTO(BookCreateRequest bookCreateRequest);
    @Mapping(target = "rereadDTO", ignore = true)
    BookCreateDTO toBookCreateDTOWithoutRereads(BookCreateRequest bookCreateRequest);

}
