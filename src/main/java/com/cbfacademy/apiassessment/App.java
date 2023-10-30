package com.cbfacademy.apiassessment;


import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@RequestMapping("companies")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}


	@Autowired
	private Ftse100Service ftse100Service;

	@Autowired
	private Ftse100AdditionalService ftse100AdditionalService;


	@GetMapping("/all")
	public ResponseEntity<List<Ftse100>> getAllCompanies(){
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

	@GetMapping(value = "/{tickerSymbol}/stockPrice", produces = "application/json")
	public ResponseEntity<String> getAFtse100CompanyStockPrice(@PathVariable String tickerSymbol){
		return ftse100AdditionalService.getStockAndPrice(tickerSymbol);
	}

	@GetMapping(value = "/allStockPrices", produces = "application/json")
	public ResponseEntity<String> getAllFtse100CompanyStockPrices(){
		return ftse100AdditionalService.getAllStocksAndAllPrices();
	}


	@GetMapping("/marketCapitalization")
	public ResponseEntity<BigInteger> getAllFtse100CompanyMarketCapitalization(){
		return ftse100AdditionalService.getAllStocksAndMarketCapitalization();
	}

	// this response is currently only printing out the first company in the list and not the other 99? why?

	@GetMapping("/priceToEquity")
	public ResponseEntity<Double> getAllFtse100CompanyPriceToEquity(){
		return ftse100AdditionalService.getAllStocksAndAllPriceToEquity();
	}
	// this response is currently only printing out the first company in the list and not the other 99? why?

	@GetMapping("/priceToBook")
	public ResponseEntity<Double> getAllFtse100CompanyPriceToBook(){
		return ftse100AdditionalService.getAllStocksAndAllPriceToBook();
	}
	// this response is currently only printing out the first company in the list and not the other 99? why?

	@GetMapping("/debtToEquity")
	public ResponseEntity<Double> getAllFtse100CompanyDebtToEquity(){
		return ftse100AdditionalService.getAllStocksAndAllDebtToEquity();
	}
	// this response is currently only printing out the first company in the list and not the other 99? why?

	@GetMapping("/esg")
	public ResponseEntity<Double> getAllFtse100CompanyEsgRatings(){
		return ftse100AdditionalService.getAllStocksAndAllEsgRatings();
	}
	// this response is currently only printing out the first company in the list and not the other 99? why?

// @GetMapping(value = "/{sector}", produces = "application/json")
// public ResponseEntity <List<Ftse100>> getAllFtse100CompaniesInSector(@PathVariable String sector){
// 	return ftse100Service.getCompaniesInSector(sector);
// }

	


}





	








