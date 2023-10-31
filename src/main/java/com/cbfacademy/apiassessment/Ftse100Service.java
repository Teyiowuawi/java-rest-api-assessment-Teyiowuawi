package com.cbfacademy.apiassessment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class Ftse100Service implements Ftse100BasicCrud {
    // need to move reading of Java file elsewhere

    // JsonFileReader jsonToPojo = new JsonFileReader(); 

    // need to create a rest template also within my test file 
    // when writing to json file - additional things must be written into it!

    private List<Ftse100> companies = new ArrayList<>();

     @Override
    public ResponseEntity<Ftse100> addFtse100Company(Ftse100 newCompany) {
        Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
			for (Ftse100 existingCompany : companies){
				if (newCompany.getTickerSymbol().toUpperCase().equals(existingCompany.getTickerSymbol().toUpperCase())){
					return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null);
                    //what can I add to the body of my HTTP request? - json instance of the exception perhaps 
                    // with all of the data and the ID
                    //Or actually just the ticker symbol - timestamp etc 
                    // perhaps the type of request too 
                    // the the message can be the excpetion message
                
				}
				}} catch (IOException e){
					e.printStackTrace();
				}
				companies.add(newCompany);
				return ResponseEntity.status(HttpStatus.CREATED).body(newCompany);
        
    }

    @Override
    public ResponseEntity<List<Ftse100>> getAllFtse100Companies() {
                Gson gson = new Gson();
        
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
            companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
        } catch (IOException e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(companies);
    }

    @Override
    public ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(String tickerSymbol){
        Gson gson = new Gson();
			
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
            companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
            for (Ftse100 company : companies){
                if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
                    return ResponseEntity.ok(company);
                }}} catch (IOException e) {
                    e.printStackTrace();
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<Ftse100> updateFtse100Company(String tickerSymbol, Ftse100 updatedCompany) {
        
        Gson gson = new Gson();
			
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
            companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
            for (Ftse100 company : companies){
                if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
                    int indexOfCompanyInFtse100List = companies.indexOf(company);
                    companies.set(indexOfCompanyInFtse100List, updatedCompany);
                    return ResponseEntity.ok(updatedCompany);
                }}} catch (IOException e) {
                    e.printStackTrace();
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

                    //TICKER SYMBOL, Timestamp, something else and the message: Unable to find Company with Ticker symbol + tickerSymbol. Please try again
    }

    @Override
    public ResponseEntity<List<Ftse100>> deleteFtse100Company(String tickerSymbol) {	
		Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
			for (Ftse100 company : companies){
                    if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
					companies.remove(company);
					return ResponseEntity.ok(companies);
				}}} catch (IOException e)
					{e.printStackTrace();
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		
    }
}


//             // exception handling 
//             // error handling approriate bodies and status codes 
//             //format json in my local host port if I can
//             // additional requests for my end points 
//             //writing back to my json file also when things are created???
//             // rest template also 
//             // organise the structure of my code 

        

      
