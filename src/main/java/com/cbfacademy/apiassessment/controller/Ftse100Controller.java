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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@ComponentScan("com.cbfacademy.apiassessment.service")
@RestController
@RequestMapping("companies")
public class Ftse100Controller {

	@Autowired
	Ftse100Service ftse100Service;

	@Operation(summary = "Get all companies in the FTSE100")
	@ApiResponse(responseCode =  "200", description = "FTSE100 companies found")
	@GetMapping("/all")
	public ResponseEntity<List<Ftse100>> getAllCompanies(){
		return ftse100Service.getCompanies();
	}

	@Operation(summary = "Get a FTSE100 company by it's Ticker Symbol")
	@ApiResponses(value = {
		@ApiResponse(responseCode =  "200", description = "FTSE100 company found", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Ftse100.class))}), 
		@ApiResponse(responseCode = "404", description = "FTSE100 company not found", content = @Content) })
	@GetMapping(value = "/{tickerSymbol}", produces = "application/json")
	public ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(@Parameter(description = "Ticker symbol of company to be searched") @PathVariable String tickerSymbol){
		return ftse100Service.getCompany(tickerSymbol);
	}

	@Operation(summary = "Create a FTSE100 company")
	@ApiResponses(value = {
		@ApiResponse(responseCode =  "201", description = "New FTSE100 company created", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Ftse100.class)) }), 
		@ApiResponse(responseCode = "403", description = "FTSE100 company already exists", content = @Content),
		@ApiResponse(responseCode = "404", description = "FTSE100 company not found", content = @Content) })
	@PostMapping("/all")
	public ResponseEntity<Ftse100> addFtse100Company(@Parameter(description = "Body of company to be created") @RequestBody Ftse100 ftse100){
		return ftse100Service.createCompany(ftse100);
	}
	 
	@Operation(summary = "Update a FTSE100 company using it's Ticker Symbol")
	@ApiResponses(value = {
		@ApiResponse(responseCode =  "200", description = "FTSE100 company updated", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Ftse100.class)) }), 
		@ApiResponse(responseCode = "404", description = "FTSE100 company not found", content = @Content) })
	@PutMapping("/{tickerSymbol}")
	public ResponseEntity<Ftse100> updateFtse100CompanyDetails(@Parameter(description = "Ticker symbol of company to be updated as well as updated changes") @PathVariable String tickerSymbol, @RequestBody Ftse100 ftse100){
		return ftse100Service.updateCompany(tickerSymbol, ftse100);
	}

	@Operation(summary = "Delete a FTSE100 company using it's Ticker Symbol")
	@ApiResponses(value = {
		@ApiResponse(responseCode =  "200", description = "FTSE100 company deleted", content = {@Content}), 
		@ApiResponse(responseCode = "404", description = "FTSE100 company not found", content = @Content) })
	@DeleteMapping(value = "/{tickerSymbol}", produces = "application/json")
	public ResponseEntity<List<Ftse100>> deleteFtse100CompanyByTickerSymbol(@Parameter(description = "Ticker symbol of company to be deleted") @PathVariable String tickerSymbol){
		return ftse100Service.deleteCompany(tickerSymbol);
	}

	@Operation(summary = "Get a company and it's stock price")
	@ApiResponses(value = {
		@ApiResponse(responseCode =  "200", description = "FTSE100 company found", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }), 
		@ApiResponse(responseCode = "404", description = "FTSE100 company not found", content = @Content) })
	@GetMapping(value = "/stockPrices/{tickerSymbol}", produces = "application/json")
	public ResponseEntity<String> getFtse100CompanyAndStockPrice(@Parameter(description = "Ticker symbol of company stock price to be searched") @PathVariable String tickerSymbol){
		return ftse100Service.getStockAndPrice(tickerSymbol);
	}

	@Operation(summary = "Get all companies and their stock prices in ascending order")
		@ApiResponse(responseCode =  "200", description = "Stock prices in ascending order found")
	@GetMapping(value = "/stockPrices/all", produces = "application/json")
	public ResponseEntity<List<String>> getAllCompaniesAndStockPrices(){
        return ftse100Service.getCompanyNamesAndStockPrices();
    }

	@Operation(summary = "Get all companies and their Market capitalization in ascending order")
		@ApiResponse(responseCode =  "200", description = "Market capitalization in ascending order found")
	@GetMapping(value = "/marketCapitalization", produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyMarketCapitalization(){
		return ftse100Service.getStocksAndMarketCapitalization();
	}

	@Operation(summary = "Get all companies and their price to equity ratio in ascending order")
		@ApiResponse(responseCode =  "200", description = "Price to equity in ascending order found")
	@GetMapping(value ="/priceToEquity" , produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyPriceToEquity(){
		return ftse100Service.getStocksAndPriceToEquity();
	}
	
	@Operation(summary = "Get all companies and their price to book ratio in ascending order")
		@ApiResponse(responseCode =  "200", description = "Price to book in ascending order found")
	@GetMapping(value = "/priceToBook" , produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyPriceToBook(){
		return ftse100Service.getStocksAndPriceToBook();
	}

	@Operation(summary = "Get all companies and their debt to equity ratio in ascending order")
		@ApiResponse(responseCode =  "200", description = "Debt to equity in ascending order found")
	@GetMapping(value = "/debtToEquity", produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyDebtToEquity(){
		return ftse100Service.getStocksAndDebtToEquity();
	}

	@Operation(summary = "Get all companies and their ESG rating in ascending order")
		@ApiResponse(responseCode =  "200", description = "ESG in ascending order found")
	@GetMapping(value = "/esg" , produces = "application/json")
	public ResponseEntity<List<String>> getAllFtse100CompanyEsgRatings(){
		return ftse100Service.getStocksAndEsg();
	}
}





	








