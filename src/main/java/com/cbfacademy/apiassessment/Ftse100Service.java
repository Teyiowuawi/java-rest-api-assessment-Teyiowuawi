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
        // Gson gson = new Gson();

    // try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
    //     companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
    // } catch (IOException e){
    //     e.printStackTrace();
    // }

    private List<Ftse100> companies = new ArrayList<>();

    // then the basic methods can be implemented here 
    // need to create a rest template also within my test file 
    // when writing to json file - additional things must be written into it!
    // could potentially add the commpanies list as a constructor within the service for use by the methods 

     @Override
    public ResponseEntity<Ftse100> addFtse100Company(Ftse100 newCompany) {
        Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
			for (Ftse100 existingCompany : companies){
				if (newCompany.getTickerSymbol().toUpperCase().equals(existingCompany.getTickerSymbol().toUpperCase())){
					return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null);
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
//     public ResponseEntity<String> getStockAndPrice(String tickerSymbol) {
//         Gson gson = new Gson();
			
// 		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
// 			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
// 			for (Ftse100 company : companies){
//                 if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
//                 return ResponseEntity.ok(company.getCompanyName() + " (" + tickerSymbol + ")" + ": " + company.getStockPrice() + " GBX");
//                 }}} catch (IOException e){
//                     e.printStackTrace();
//                 }
//                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//                 // Body message; Ticker symbol does not exist. Please ensure you type in the ticker symbol of an existing company 
               
//     }

//     public  ResponseEntity<String> getAllStocksAndAllPrices() {	
// 	Gson gson = new Gson();
			
// 		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
// 			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
//             for (Ftse100 company : companies) {
//                 String companyTickerSymbolAndStockPrice = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getStockPrice();
//                 return ResponseEntity.ok(companyTickerSymbolAndStockPrice);
//             }} catch (IOException e){
//                 e.printStackTrace();
//              }
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }
//         // this response is currently only printing out the first company in the list and not the other 99?

//     public ResponseEntity<BigInteger> getAllStocksAndMarketCapitalization() {
//         Gson gson = new Gson();
			
// 		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
// 			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
//             for (Ftse100 company : companies) {
//                 return ResponseEntity.ok(company.getMarketCapitalization());
//             }} catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }
//         // this response is currently only printing out the first company in the list and not the other 99?

//         public ResponseEntity<Double> getAllStocksAndAllPriceToEquity() {
//         Gson gson = new Gson();
			
// 		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
// 			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
//             for (Ftse100 company : companies) {
//                 return ResponseEntity.ok(company.getPriceToEquityRatio());
//             }} catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }
//         // this response is currently only printing out the first company in the list and not the other 99?

//         public ResponseEntity<Double> getAllStocksAndAllPriceToBook() {
//         Gson gson = new Gson();
			
// 		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
// 			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
//             for (Ftse100 company : companies) {
//                 return ResponseEntity.ok(company.getPriceToBookRatio());
//             }} catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }  
//         // this response is currently only printing out the first company in the list and not the other 99? 

//         public ResponseEntity<Double> getAllStocksAndAllDebtToEquity() {
//         Gson gson = new Gson();
			
// 		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
// 			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
//             for (Ftse100 company : companies) {
//                 return ResponseEntity.ok(company.getDebtToEquityRatio());
//             }} catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }  
//         // this response is currently only printing out the first company in the list and not the other 99? 

//         public ResponseEntity<Double> getAllStocksAndAllEsgRatings() {
//         Gson gson = new Gson();
			
// 		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
// 			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
//             for (Ftse100 company : companies) {
//                 return ResponseEntity.ok(company.getEsgRiskRating());
//             }} catch (IOException e) {
//                 e.printStackTrace();
//             }
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//         }  
//         // this response is currently only printing out the first company in the list and not the other 99? 
// }


// 			//remember to find appropriate responses for HTTP requests and also appropriate exception handling
//             // exception handling 
//             // error handling approriate bodies and status codes 
//             //format json in my local host port if I can
//             // additiona requests for my end points 
//             //writing back to my json file also when things are created???
//             // rest template also 
//             // exception handling - incorrect argument placed inside the file also 
//             // look into exception handling and the different types of exception e.g. null, incorrect argument etc 
//             // look into appropriate HTTP response codes and also type up my bodies 
//             // organise the structure of my code 

        

      
