package com.InfoSpring.API.controllers.impl;

import com.InfoSpring.API.domain.Author;
import com.InfoSpring.API.domain.Book;
import com.InfoSpring.API.mapper.author.AuthorMapper;
import com.InfoSpring.API.mapper.book.BookMapper;
import com.InfoSpring.API.mapper.book.impl.BookMapperImpl;
import com.InfoSpring.API.mapper.mapperbase.EntityMapper;
import com.InfoSpring.API.mapper.mapperbase.impl.EntityMapperImpl;
import com.InfoSpring.API.model.dto.DTO;
import com.InfoSpring.API.model.dto.book.BookDto;
import com.InfoSpring.API.services.author.impl.AuthorServiceImpl;
import com.InfoSpring.API.services.book.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/book")
public class BookController extends BaseControllerImpl<Book, BookServiceImpl,BookDto> {

    @Autowired
    private final BookServiceImpl bookService;
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    public BookController (BookServiceImpl bookService, BookMapper bookMapper){
        super(bookService,  (EntityMapperImpl<Book, DTO>) bookMapper);
        this.bookService = bookService;
    }

    @GetMapping("/title")
    public ResponseEntity<?> findBookByTitle(@RequestParam("titleBook") String titleBook){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(bookService.findBookByTitle(titleBook));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}
