package com.cbfacademy.apiassessment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("books")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


	@Autowired
	private BooksService booksService;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s", name);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Books>> getAllBooks(){
		List<Books> books = booksService.getAllBooks();
		return ResponseEntity.ok(books);
	}
}

	// @GetMapping("/all")
    // public ResponseEntity<List<Books>> getAllBooks(){
	// 	try{
	// 		Gson gson = new Gson();
    //         java.lang.reflect.Type bookType = new TypeToken<List<Books>>() {}.getType();

    //         InputStream inputStream = getClass().getResourceAsStream("/resources/books.json");
    //         InputStreamReader reader = new InputStreamReader(inputStream);

    //         List<Books> books = gson.fromJson(reader, bookType);

	// 		return ResponseEntity.ok(books);
	// 	// } catch (IOException e){
	// 	// 	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
	// 	// }
    // } finally {
	// 	System.out.println("this code runs");
	// }







