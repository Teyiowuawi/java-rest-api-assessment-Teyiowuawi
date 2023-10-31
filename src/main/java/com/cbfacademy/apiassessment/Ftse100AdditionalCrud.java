package com.cbfacademy.apiassessment;

import org.springframework.http.ResponseEntity;

public interface Ftse100AdditionalCrud {
    ResponseEntity<String> getStockAndPrice(String tickerSymbol);

    ResponseEntity<String> getAllStocksAndAllPrices();

    ResponseEntity<String> getAllStocksAndMarketCapitalization();

    ResponseEntity<String> getAllStocksAndAllPriceToEquity();

    ResponseEntity<String> getAllStocksAndAllPriceToBook();

    ResponseEntity<String> getAllStocksAndAllDebtToEquity();

    ResponseEntity<String> getAllStocksAndAllEsgRatings(); 
}
