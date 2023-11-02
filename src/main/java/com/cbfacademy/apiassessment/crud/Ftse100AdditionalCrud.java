package com.cbfacademy.apiassessment.crud;

import org.springframework.http.ResponseEntity;

public interface Ftse100AdditionalCrud extends Ftse100BasicCrud {
    
    ResponseEntity<String> getStockAndPrice(String tickerSymbol);

    ResponseEntity<String> getAllStocksAndAllPrices();

    ResponseEntity<String> getAllStocksAndMarketCapitalization();

    ResponseEntity<String> getAllStocksAndAllPriceToEquity();

    ResponseEntity<String> getAllStocksAndAllPriceToBook();

    ResponseEntity<String> getAllStocksAndAllDebtToEquity();

    ResponseEntity<String> getAllStocksAndAllEsgRatings(); 
}
