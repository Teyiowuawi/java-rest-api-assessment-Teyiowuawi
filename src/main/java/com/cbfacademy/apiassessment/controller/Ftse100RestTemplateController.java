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
    
    @GetMapping("/all")
    public ResponseEntity<List<Ftse100>> getAllCompanies(){
        return ftse100RestTemplateService.allCompanies();
        
    }

   @PostMapping("/addCompany")
    public ResponseEntity<Ftse100> addNewCompany(@RequestBody Ftse100 ftse100){
        return ftse100RestTemplateService.addCompany(ftse100);
    }

    @GetMapping(value = "/{tickerSymbol}", produces = "application/json")
    public Ftse100 getCompanyByTickerSymbol(@PathVariable String tickerSymbol){
        return ftse100RestTemplateService.getCompany(tickerSymbol);
    }
    
    @PutMapping(value = "/{tickerSymbol}", produces = "application/json")
    public void  updateCompanyByTickerSymbol(@RequestBody Ftse100 ftse100){
        ftse100RestTemplateService.updateCompany(ftse100);
        // java.lang.IllegalArgumentException: Not enough variable values available
        // to expand 'tickerSymbol'
    }

    @DeleteMapping(value = "/{tickerSymbol}", produces = "application/json")
    public void deleteCompanyByTickerSymbol(@PathVariable String tickerSymbol){
        ftse100RestTemplateService.deleteCompany(tickerSymbol);
        // this is the only request that works
    }

    
}
