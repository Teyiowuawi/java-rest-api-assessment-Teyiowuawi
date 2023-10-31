package com.cbfacademy.apiassessment;

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


	@GetMapping(value = "/marketCapitalization", produces = "application/json")
	public ResponseEntity<String> getAllFtse100CompanyMarketCapitalization(){
		return ftse100AdditionalService.getAllStocksAndMarketCapitalization();
	}


	@GetMapping(value ="/priceToEquity" , produces = "application/json")
	public ResponseEntity<String> getAllFtse100CompanyPriceToEquity(){
		return ftse100AdditionalService.getAllStocksAndAllPriceToEquity();
	}
	

	@GetMapping(value = "/priceToBook" , produces = "application/json")
	public ResponseEntity<String> getAllFtse100CompanyPriceToBook(){
		return ftse100AdditionalService.getAllStocksAndAllPriceToBook();
	}


	@GetMapping(value = "/debtToEquity", produces = "application/json")
	public ResponseEntity<String> getAllFtse100CompanyDebtToEquity(){
		return ftse100AdditionalService.getAllStocksAndAllDebtToEquity();
	}


	@GetMapping(value = "/esg" , produces = "application/json")
	public ResponseEntity<String> getAllFtse100CompanyEsgRatings(){
		return ftse100AdditionalService.getAllStocksAndAllEsgRatings();
	}


// @GetMapping(value = "/{sector}", produces = "application/json")
// public ResponseEntity <List<Ftse100>> getAllFtse100CompaniesInSector(@PathVariable String sector){
// 	return ftse100Service.getCompaniesInSector(sector);
// } - could pontetially also add this end point - if an individual wants to find out whihc companies are in a certain sector 

	


}





	








