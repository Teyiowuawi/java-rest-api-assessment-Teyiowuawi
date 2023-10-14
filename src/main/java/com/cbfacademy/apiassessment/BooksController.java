package com.cbfacademy.apiassessment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BooksController {
    
    @Autowired
    private BooksService bookService; 

    @GetMapping("/books")
    public ResponseEntity<Books> getAllBooks(){

    }
}
