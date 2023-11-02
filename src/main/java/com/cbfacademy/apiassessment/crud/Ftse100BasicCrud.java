package com.cbfacademy.apiassessment.crud;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cbfacademy.apiassessment.datamodel.Ftse100;

public interface Ftse100BasicCrud {
    
    ResponseEntity<Ftse100> addFtse100Company(Ftse100 ftse100);
    
    ResponseEntity<List<Ftse100>> getAllFtse100Companies();

    ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(String tickerSymbol);

    ResponseEntity<Ftse100> updateFtse100Company(String tickerSymbol, Ftse100 updatedCompany);

    ResponseEntity<List<Ftse100>> deleteFtse100Company(String tickerSymbol);
}   
