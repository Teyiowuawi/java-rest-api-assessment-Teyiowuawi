package com.cbfacademy.apiassessment.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cbfacademy.apiassessment.datamodel.Ftse100;
import com.cbfacademy.apiassessment.repository.Ftse100Respository;

@Service
@ComponentScan("com.cbfacademy.apiassessment.repository")
public class Ftse100Service {

    @Autowired
    Ftse100Respository ftse100Repository;

    public ResponseEntity<Ftse100> createCompany(Ftse100 company){
        return ftse100Repository.addFtse100Company(company);
    }

    public ResponseEntity<List<Ftse100>> getCompanies() {
        return ftse100Repository.getAllFtse100Companies();
    }

    public ResponseEntity<Ftse100> getCompany(String tickerSymbol){
        return ftse100Repository.getFtse100CompanyByTickerSymbol(tickerSymbol);
    }

    public ResponseEntity<Ftse100> updateCompany(String tickerSymbol, Ftse100 updatedCompany){
        return ftse100Repository.updateFtse100Company(tickerSymbol, updatedCompany);
    }

    public ResponseEntity<List<Ftse100>> deleteCompany(String tickerSymbol){
        return ftse100Repository.deleteFtse100Company(tickerSymbol);
    }

    public ResponseEntity<String> getStockAndPrice(String tickerSymbol){
        return ftse100Repository.getCompanyStockAndPrice(tickerSymbol);
    }

    public  ResponseEntity<String> getStocksAndPrices(){
        return ftse100Repository.getAllStocksAndAllPrices();
    }

    public ResponseEntity<HashMap<String, Double>> getCompanyNameAndStockPrice(){
        return ftse100Repository.bubbleSortAlgoCompanyAndStockPrice();
    }

    public ResponseEntity<String> getStocksAndMarketCapitalization(){
        return ftse100Repository.getAllStocksAndMarketCapitalization();
    }

    public ResponseEntity<String> getStocksAndPriceToEquity(){
        return ftse100Repository.getAllStocksAndAllPriceToEquity();
    }

    public ResponseEntity<String> getStocksAndPriceToBook(){
        return ftse100Repository.getAllStocksAndAllPriceToBook();
    }

    public ResponseEntity<String> getStocksAndDebtToEquity(){
        return ftse100Repository.getAllStocksAndAllDebtToEquity();
    }

    public ResponseEntity<String> getStocksAndEsg(){
        return ftse100Repository.getAllStocksAndAllEsgRatings();
    }
}  


        

      
