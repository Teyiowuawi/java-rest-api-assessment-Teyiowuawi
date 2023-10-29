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
@RequestMapping("companies")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


	@Autowired
	private Ftse100Service ftse100Service;

	@GetMapping("/all")
	public ResponseEntity<List<Ftse100>> getAllBooks(){
		return ftse100Service.getAllFtse100Companies();
	}

	@GetMapping(value = "/{tickerSymbol}", produces = "application/json")
	public ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(@PathVariable String tickerSymbol){
		return ftse100Service.getFtse100CompanyByTickerSymbol(tickerSymbol);
	}

	@PostMapping("/all")
	public ResponseEntity<Ftse100> addFtse100Company(@RequestBody Ftse100 ftse100){
		return ftse100Service.addFtse100Company(ftse100);
			} 

	@DeleteMapping(value = "/{tickerSymbol}", produces = "application/json")
	public ResponseEntity<List<Ftse100>> deleteFtse100CompanyByTickerSymbol(@PathVariable String tickerSymbol){
		return ftse100Service.deleteFtse100Company(tickerSymbol);
	}

	@PutMapping("/{tickerSymbol}")
	public ResponseEntity<Ftse100> updateFtse100CompanyDetails(@PathVariable String tickerSymbol, @RequestBody Ftse100 ftse100){
		return ftse100Service.updateFtse100Company(tickerSymbol, ftse100);
	}

	// @GetMapping(value = "/{tickerSymbol}/stockPrice", produces = "application/json")
	// public ResponseEntity<String> getFtse100CompanyStockPrice(@PathVariable String tickerSymbol){
	// 	return ftse100Service.getStockAndPrice(tickerSymbol);
	// }

	// @GetMapping("/stockPrices")
	// public ResponseEntity<String> getAllFtse100CompanyStockPrices(){
	// 	return ftse100Service.getAllStocksAndAllPrices();
	// }

	@GetMapping(value = "/{sector}", produces = "application/json")
	public ResponseEntity <List<Ftse100>> getAllFtse100CompaniesInSector(@PathVariable String sector){
		return ftse100Service.getCompaniesInSector(sector);
	}

	


}





	








