package com.cbfacademy.apiassessment.crud;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface Ftse100AdditionalCrud extends Ftse100BasicCrud {
    
    ResponseEntity<String> getCompanyStockAndPrice(String tickerSymbol);

    ResponseEntity<List<String>> getAllStocksAndAllPrices();

    ResponseEntity<String> getAllStocksAndMarketCapitalization();

    ResponseEntity<String> getAllStocksAndAllPriceToEquity();

    ResponseEntity<String> getAllStocksAndAllPriceToBook();

    ResponseEntity<String> getAllStocksAndAllDebtToEquity();

    ResponseEntity<String> getAllStocksAndAllEsgRatings(); 
}
