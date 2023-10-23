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

	//  private List<Ftse100> companies = new ArrayList<>();

	@GetMapping("/companies")
	public ResponseEntity<List<Ftse100>> getAllBooks(){
		return ftse100Service.getAllFtse100Companies();
		
		
		//print f - defining the format i would like to use for the loop!
	}


	@PostMapping("/companies")
	public ResponseEntity<Ftse100> addFtse100Company(@RequestBody Ftse100 ftse100){
		return ftse100Service.addFtse100Company(ftse100);
			} 

	@DeleteMapping(value = "companies/{tickerSymbol}", produces = "application/json")
	public ResponseEntity<List<Ftse100>> deleteFtse100CompanyByTickerSymbol(@PathVariable String tickerSymbol){
		return ftse100Service.deleteFtse100Company(tickerSymbol);
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





	








