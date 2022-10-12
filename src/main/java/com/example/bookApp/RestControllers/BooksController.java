package com.example.bookApp.RestControllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookApp.DTO.BookDTO;


@RestController
@RequestMapping("/api/books")
public class BooksController {
    
    private static final Logger log= LoggerFactory.getLogger(BooksController.class);
    
    Resource resource;

    @PostMapping("/book")
    public ResponseEntity<String> saveBook(@RequestBody BookDTO book ){
        log.info(book.getCover_front());
        
        
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
