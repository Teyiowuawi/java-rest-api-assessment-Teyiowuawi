package com.cbfacademy.apiassessment;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

public interface Ftse100AdditionalCrud {
    ResponseEntity<String> getStockAndPrice(String tickerSymbol);

    ResponseEntity<String> getAllStocksAndAllPrices();

    ResponseEntity<BigInteger> getAllStocksAndMarketCapitalization();

    ResponseEntity<Double> getAllStocksAndAllPriceToEquity();

    ResponseEntity<Double> getAllStocksAndAllPriceToBook();

    ResponseEntity<Double> getAllStocksAndAllDebtToEquity();

    ResponseEntity<Double> getAllStocksAndAllEsgRatings(); 
}
