// package com.cbfacademy.apiassessment;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @RequestMapping("/books")
// public class BooksController {

//     @Autowired
//     private BooksService booksService;

//     @GetMapping("all")
//     public ResponseEntity<List<Books>> getAllBooks(){
//         List<Books> books = booksService.getAllBooks();
//         return ResponseEntity.ok(books);
//     }
// }
