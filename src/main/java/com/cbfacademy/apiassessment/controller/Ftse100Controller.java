package com.cbfacademy.apiassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbfacademy.apiassessment.datamodel.Ftse100;
import com.cbfacademy.apiassessment.service.Ftse100Service;

@ComponentScan("com.cbfacademy.apiassessment.service")
@RestController
@RequestMapping("companies")
public class Ftse100Controller {

	@Autowired
	Ftse100Service ftse100Service;

	@GetMapping("/all")
	public ResponseEntity<List<Ftse100>> getAllCompanies(){
		return ftse100Service.getCompanies();
	}

	@GetMapping(value = "/{tickerSymbol}", produces = "application/json")
	public ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(@PathVariable String tickerSymbol){
		return ftse100Service.getCompany(tickerSymbol);
	}

	@PostMapping("/all")
	public ResponseEntity<Ftse100> addFtse100Company(@RequestBody Ftse100 ftse100){
		return ftse100Service.createCompany(ftse100);
	} 
	
	@PutMapping("/{tickerSymbol}")
	public ResponseEntity<Ftse100> updateFtse100CompanyDetails(@PathVariable String tickerSymbol, @RequestBody Ftse100 ftse100){
		return ftse100Service.updateCompany(tickerSymbol, ftse100);
	}

	@DeleteMapping(value = "/{tickerSymbol}", produces = "application/json")
	public ResponseEntity<List<Ftse100>> deleteFtse100CompanyByTickerSymbol(@PathVariable String tickerSymbol){
		return ftse100Service.deleteCompany(tickerSymbol);
	}

	@GetMapping(value = "/stockPrices/{tickerSymbol}", produces = "application/json")
	public ResponseEntity<String> getFtse100CompanyAndStockPrice(@PathVariable String tickerSymbol){
		return ftse100Service.getStockAndPrice(tickerSymbol);
	}

	@GetMapping(value = "/stockPrices/all", produces = "application/json")
	public ResponseEntity<List<String>> getAllCompaniesAndStockPrices(){
        return ftse100Service.getCompanyNamesAndStockPrices();
    }


	@GetMapping(value = "/marketCapitalization", produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyMarketCapitalization(){
		return ftse100Service.getStocksAndMarketCapitalization();
	}


	@GetMapping(value ="/priceToEquity" , produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyPriceToEquity(){
		return ftse100Service.getStocksAndPriceToEquity();
	}
	

	@GetMapping(value = "/priceToBook" , produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyPriceToBook(){
		return ftse100Service.getStocksAndPriceToBook();
	}


	@GetMapping(value = "/debtToEquity", produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyDebtToEquity(){
		return ftse100Service.getStocksAndDebtToEquity();
	}


	@GetMapping(value = "/esg" , produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyEsgRatings(){
		return ftse100Service.getStocksAndEsg();
	}
}





	








