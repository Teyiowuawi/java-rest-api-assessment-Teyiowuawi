package com.cbfacademy.apiassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cbfacademy.apiassessment.service.Ftse100RestTemplateService;

@RestController 
@RequestMapping("ftse100RestTemplate")
public class Ftse100RestTemplateController {

    @Autowired
    private Ftse100RestTemplateService ftse100RestTemplateService;

    @PostMapping("/all")
    public ResponseEntity<Ftse100> addNewCompany(@RequestBody Ftse100 ftse100){
        return ftse100RestTemplateService.addCompany(ftse100);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Ftse100>> getAllCompanies(){
        return ftse100RestTemplateService.allCompanies();   
    }

    @GetMapping(value = "/{tickerSymbol}", produces = "application/json")
    public Ftse100 getCompanyByTickerSymbol(@PathVariable String tickerSymbol){
        return ftse100RestTemplateService.getCompany(tickerSymbol);
    }
    
    @PutMapping(value = "/{tickerSymbol}", produces = "application/json")
    public void  updateCompanyByTickerSymbol(@PathVariable String tickerSymbol, @RequestBody Ftse100 ftse100){
        ftse100RestTemplateService.updateCompany(tickerSymbol, ftse100);
    }

    @DeleteMapping(value = "/{tickerSymbol}", produces = "application/json")
    public void deleteCompanyByTickerSymbol(@PathVariable String tickerSymbol){
        ftse100RestTemplateService.deleteCompany(tickerSymbol);
    }

    @GetMapping(value = "/stockPrices/{tickerSymbol}", produces = "application/json")
    public ResponseEntity<String> getCompanyAndStockPrice(@PathVariable String tickerSymbol){
        return ftse100RestTemplateService.getCompanyAndPrice(tickerSymbol);

    }  

    @GetMapping(value = "/stockPrices/all", produces = "application/json")
    public ResponseEntity<List<String>> getAllCompaniesAndStockPrices(){
        return ftse100RestTemplateService.getCompaniesAndPrices();
    }
    
    
    @GetMapping(value = "/marketCapitalization", produces = "application/json")
    public ResponseEntity<List<String>> getAllCompaniesAndMarketCap(){
        return ftse100RestTemplateService.getCompaniesAndMarketCap();
    }

    @GetMapping(value = "/priceToEquity", produces = "application/json")
    public ResponseEntity<List<String>> getAllCompaniesAndPriceToEquity(){
        return ftse100RestTemplateService.getCompaniesAndPriceToEquity();
    }

    @GetMapping(value = "/priceToBook", produces = "application/json")
    public ResponseEntity<List<String>> getAllCompaniesAndPriceToBook(){
        return ftse100RestTemplateService.getCompaniesAndPriceToBook();
    }

    @GetMapping(value = "/debtToEquity", produces = "application/json")
    public ResponseEntity<List<String>> getAllCompaniesAndDebtToEquity(){
        return ftse100RestTemplateService.getCompaniesAndDebtToEquity();
    }

    @GetMapping(value = "/esg", produces = "application/json")
    public ResponseEntity<List<String>> getAllCompaniesAndEsgRiskRating(){
        return ftse100RestTemplateService.getCompaniesAndEsgRiskRating();
    }





    
}
