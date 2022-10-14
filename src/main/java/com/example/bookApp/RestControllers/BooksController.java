package com.example.bookApp.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.bookApp.DTO.BookDTO;
import com.example.bookApp.DTO.BookImageDTO;
import com.example.bookApp.Services.impl.ImageServiceImpl;


@RestController
@RequestMapping("/api/books")
public class BooksController {
    @Autowired
    ImageServiceImpl imageServiceImpl;
    

    @PostMapping("/book")
    public ResponseEntity<String> saveBook(@RequestBody BookDTO book ){
        BookImageDTO image= book.getCover_front();
        String nameOnDataBase= imageServiceImpl.saveImage(image);
        
        return ResponseEntity.status(HttpStatus.OK).body(nameOnDataBase);
    }

}
