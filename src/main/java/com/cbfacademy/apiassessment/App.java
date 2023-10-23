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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@SpringBootApplication
@RestController
@RequestMapping
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


	@Autowired
	private Ftse100Service ftse100Service;

	 private List<Ftse100> companies = new ArrayList<>();

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}

	@GetMapping("/companies")
	public ResponseEntity<List<Ftse100>> getAllBooks(){
		companies = ftse100Service.getAllCompanies();
		return ResponseEntity.ok(companies);
		//print f - defining the format i would like to use for the loop!
	}

	// @GetMapping(value = "books/{id}", produces = "application/json")
	// public ResponseEntity<Books> getBookById(@PathVariable Long id){
	// 		Gson gson = new Gson();
			
	// 		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("books.json"))){
	// 			books = gson.fromJson(reader, new TypeToken<List<Books>>() {}.getType());
	// 			for (Books book : books){
	// 				if (book.getId() == id){
	// 					return ResponseEntity.ok(book);
	// 				}}} catch (IOException e) {
	// 					e.printStackTrace();
	// 				}
	// 				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	// 		}

	// @DeleteMapping(value = "books/{id}", produces = "application/json")
	// public ResponseEntity<List<Books>> deleteBookById(@PathVariable Long id){
	// 	Gson gson = new Gson();
			
	// 	try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("books.json"))){
	// 		books = gson.fromJson(reader, new TypeToken<List<Books>>() {}.getType());
	// 		for (Books book : books){
	// 			if (book.getId() == id){
	// 				books.remove(book);
	// 				return ResponseEntity.ok(books);
	// 			}}} catch (IOException e)
	// 				{e.printStackTrace();
	// 			}
	// 			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);			
	// }

	// @PostMapping("books")
	// public ResponseEntity<List<Books>> addBook(@RequestBody Books book){
	// 	Gson gson = new Gson();
			
	// 	try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("books.json"))){
	// 		books = gson.fromJson(reader, new TypeToken<List<Books>>() {}.getType());
	// 		for (Books exisitingBooks : books){
	// 			if (exisitingBooks.getId().equals(book.getId()) ){
	// 				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null);
	// 			}
	// 			}} catch (IOException e){
	// 				e.printStackTrace();
	// 			}
	// 			books.add(book);
	// 			return ResponseEntity.status(HttpStatus.CREATED).body(books);
	// 		} 

			// ^ need to sort out aspect where book ID must not match the id's of other books
			//remember to find appropriate responses for HTTP requests and also appropriate exception handling

	// @PutMapping("books/{id}")
	// public ResponseEntity<List<Books>> updateBook(@PathVariable Long id, @RequestBody Books updatedBook){
	// 	Gson gson = new Gson();

	// 		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("books.json"))){
	// 		books = gson.fromJson(reader, new TypeToken<List<Books>>() {}.getType());
	// 		return ResponseEntity.ok(books);
	// 			} catch (IOException e)
	// 				{e.printStackTrace();
	// 			}
	// 			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);			
	// 		}
		// come back to this put request to figure out the code 
	}





	








