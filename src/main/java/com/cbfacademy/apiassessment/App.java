package com.cbfacademy.apiassessment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SpringBootApplication
@RestController
@RequestMapping("books")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


	@Autowired
	private BooksService booksService;

	 private List<Books> books = new ArrayList<>();

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Books>> getAllBooks(){
		List<Books> books = booksService.getAllBooks();
		return ResponseEntity.ok(books);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Books> getBookByID(@PathVariable Long id){
			Gson gson = new Gson();
			
			try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("books.json"))){
				books = gson.fromJson(reader, new TypeToken<List<Books>>() {}.getType());
				for (Books book : books){
					if (book.getId().equals(id)){
						return ResponseEntity.ok(book);
					}}} catch (IOException e) {
						e.printStackTrace();
					}
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}

	// @PostMapping("/addBook")
	// // how shuld post mapping look
	// public ResponseEntity<List<Books>> getAllBooksNew(){
	// 	List<Books> books = booksService.getAllBooks();
	// 	books.add();
	// 	return ResponseEntity.ok(books);
	// }
	// }

//question 
// 	@GetMapping("/all")
// 	public Books getAllBooksNow(){
// 		List<Books> books = booksService.getAllBooks();
// 		for (Books book : books){
// 			System.out.println(book);
// 		}
// 	}
// }
	// when I run this, it doesnt print each object on it's own line? 
	// instead it prints th eobjects in the terminal. 
	// is this because I am converting from json to java?

	








