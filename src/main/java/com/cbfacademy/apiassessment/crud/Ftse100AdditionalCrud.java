package com.cbfacademy.apiassessment.crud;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface Ftse100AdditionalCrud extends Ftse100BasicCrud {
    
    ResponseEntity<String> getCompanyStockAndPrice(String tickerSymbol);

    ResponseEntity<List<String>> getAllStocksAndMarketCapitalization();

    ResponseEntity<List<String>> getAllStocksAndAllPriceToEquity();

    ResponseEntity<List<String>> getAllStocksAndAllPriceToBook();

    ResponseEntity<List<String>> getAllStocksAndAllDebtToEquity();

    ResponseEntity<List<String>> getAllStocksAndAllEsgRatings(); 
}
