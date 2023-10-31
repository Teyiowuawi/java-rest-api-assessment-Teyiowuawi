package com.cbfacademy.apiassessment;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Ftse100Service implements Ftse100BasicCrud {

    private List<Ftse100> companies = Ftse100JsonFileReader.readFtse100JsonFile("ftse100.json");

     @Override
    public ResponseEntity<Ftse100> addFtse100Company(Ftse100 newCompany) {
		for (Ftse100 existingCompany : companies){
			if (newCompany.getTickerSymbol().toUpperCase().equals(existingCompany.getTickerSymbol().toUpperCase())){
				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null); 
				}}
                companies.add(newCompany);
                return ResponseEntity.status(HttpStatus.CREATED).body(newCompany);
    }       

    @Override
    public ResponseEntity<List<Ftse100>> getAllFtse100Companies() {
        return ResponseEntity.ok(companies);
    }

    @Override
    public ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(String tickerSymbol){
        for (Ftse100 company : companies){
                if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
                    return ResponseEntity.ok(company);
                }}

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<Ftse100> updateFtse100Company(String tickerSymbol, Ftse100 updatedCompany) {
        for (Ftse100 company : companies){
                if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
                    int indexOfCompanyInFtse100List = companies.indexOf(company);
                    companies.set(indexOfCompanyInFtse100List, updatedCompany);
                    return ResponseEntity.ok(updatedCompany);
                }}
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);   
    }

                    //TICKER SYMBOL, Timestamp, something else and the message: Unable to find Company with Ticker symbol + tickerSymbol. Please try again
    

    @Override
    public ResponseEntity<List<Ftse100>> deleteFtse100Company(String tickerSymbol) {	
		for (Ftse100 company : companies){
            if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
				companies.remove(company);
				return ResponseEntity.ok(companies);
				}}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		
    }
}

//             // exception handling 
//             // error handling approriate bodies and status codes 
//             // format json in my local host port if I can
//             // additional requests for my end points 
//             // writing back to my json file also when things are created???
//             // rest template also 
//             // organise the structure of my code 

        

      
