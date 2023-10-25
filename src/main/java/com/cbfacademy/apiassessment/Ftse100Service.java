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

    private List<Ftse100> companies = new ArrayList<>();

     @Override
    public ResponseEntity<Ftse100> addFtse100Company(Ftse100 newCompany) {
        Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
			for (Ftse100 existingCompany : companies){
				if (newCompany.getTickerSymbol().equals(existingCompany.getTickerSymbol()) ){
					return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null);
                    // make sure this is a correct response
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
        // define formatting to make it more visually appealing
    }

    @Override
    public ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(String tickerSymbol){
        Gson gson = new Gson();
			
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
            companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
            for (Ftse100 company : companies){
                if (company.getTickerSymbol().equals(tickerSymbol)){
                    return ResponseEntity.ok(company);
                }}} catch (IOException e) {
                    e.printStackTrace();
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @Override
    public ResponseEntity<Ftse100> updateFtse100Company(String tickerSymbol) {
        // figure out this method implementation
        throw new UnsupportedOperationException("Unimplemented method 'updateFtse100Company'");
    }

    @Override
    public ResponseEntity<List<Ftse100>> deleteFtse100Company(String tickerSymbol) {	
		Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
			for (Ftse100 company : companies){
                    if (company.getTickerSymbol().toLowerCase().equals(tickerSymbol.toLowerCase())){
					companies.remove(company);
					return ResponseEntity.ok(companies);
				}}} catch (IOException e)
					{e.printStackTrace();
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);			
    }
    // come back to add a proper body



}
			// ^ need to sort out aspect where book ID must not match the id's of other books
			//remember to find appropriate responses for HTTP requests and also appropriate exception handling
            // dry principle - need to stop repeating the reading of the json file!

    	// question 
		// to make code more modular, should I have the simple CRUD operations in the BookService?   
        // do i have to... i forgot what i wanted to ask here       
