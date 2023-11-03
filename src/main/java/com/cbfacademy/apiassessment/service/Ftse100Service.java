package com.cbfacademy.apiassessment.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cbfacademy.apiassessment.datamodel.Ftse100;
import com.cbfacademy.apiassessment.repository.Ftse100Respository;

@Service
@ComponentScan("com.cbfacademy.apiassessment.repository")
public class Ftse100Service {

    @Autowired
    Ftse100Respository ftse100Repository;

    public ResponseEntity<Ftse100> createCompany(Ftse100 company){
        return ftse100Repository.addFtse100Company(company);
    }

    public ResponseEntity<List<Ftse100>> getCompanies() {
        return ftse100Repository.getAllFtse100Companies();
    }

    public ResponseEntity<Ftse100> getCompany(String tickerSymbol){
        return ftse100Repository.getFtse100CompanyByTickerSymbol(tickerSymbol);
    }

    public ResponseEntity<Ftse100> updateCompany(String tickerSymbol, Ftse100 updatedCompany){
        return ftse100Repository.updateFtse100Company(tickerSymbol, updatedCompany);
    }

    public ResponseEntity<List<Ftse100>> deleteCompany(String tickerSymbol){
        return ftse100Repository.deleteFtse100Company(tickerSymbol);
    }

    public ResponseEntity<String> getStockAndPrice(String tickerSymbol){
        return ftse100Repository.getCompanyStockAndPrice(tickerSymbol);
    }

    public  ResponseEntity<String> getStocksAndPrices(){
        return ftse100Repository.getAllStocksAndAllPrices();
    }

    public ResponseEntity<String> getStocksAndMarketCapitalization(){
        return ftse100Repository.getAllStocksAndMarketCapitalization();
    }

    public ResponseEntity<String> getStocksAndPriceToEquity(){
        return ftse100Repository.getAllStocksAndAllPriceToEquity();
    }

    public ResponseEntity<String> getStocksAndPriceToBook(){
        return ftse100Repository.getAllStocksAndAllPriceToBook();
    }

    public ResponseEntity<String> getStocksAndDebtToEquity(){
        return ftse100Repository.getAllStocksAndAllDebtToEquity();
    }

    public ResponseEntity<String> getStocksAndEsg(){
        return ftse100Repository.getAllStocksAndAllEsgRatings();
    }
    }

    




    // private List<Ftse100> companies = Ftse100JsonFileReader.readFtse100JsonFile("ftse100.json");

     
//     public ResponseEntity<Ftse100> addFtse100Company(Ftse100 newCompany) {
// 		for (Ftse100 existingCompany : companies){
// 			if (newCompany.getTickerSymbol().toUpperCase().equals(existingCompany.getTickerSymbol().toUpperCase())){
// 				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null); 
// 				}}
//                 companies.add(newCompany);
//                 return ResponseEntity.status(HttpStatus.CREATED).body(newCompany);
//                 // writing back to my json file with a method here!
//                 // we want that to persist - need my file to be written back tot ht file!
//     }       

    
//     public ResponseEntity<List<Ftse100>> getAllFtse100Companies() {
//         return ResponseEntity.ok(companies);
//     }

    
//     public ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(String tickerSymbol){
//         for (Ftse100 company : companies){
//                 if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
//                     return ResponseEntity.ok(company);
//                 }} 
//                 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//     }

    
//     public ResponseEntity<Ftse100> updateFtse100Company(String tickerSymbol, Ftse100 updatedCompany) {
//         for (Ftse100 company : companies){
//                 if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
//                     int indexOfCompanyInFtse100List = companies.indexOf(company);
//                     companies.set(indexOfCompanyInFtse100List, updatedCompany);
//                     return ResponseEntity.ok(updatedCompany);
//                 }}
//                     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);   
//     }

//                     //TICKER SYMBOL, Timestamp, something else and the message: Unable to find Company with Ticker symbol + tickerSymbol. Please try again

    
//     public ResponseEntity<List<Ftse100>> deleteFtse100Company(String tickerSymbol) {	
// 		for (Ftse100 company : companies){
//             if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
// 				companies.remove(company);
// 				return ResponseEntity.ok(companies);
// 				}}
// 				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		
//     }

    
//     public ResponseEntity<String> getStockAndPrice(String tickerSymbol) {
// 			for (Ftse100 company : companies){
//                 if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
//                     return ResponseEntity.ok(company.getCompanyName() + " (" + tickerSymbol + ")" + ": " + company.getStockPrice() + " GBX");
//                 }
//             }
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//                 // adding to the body of this request through proper exception handling
//                 // Timestamp, status, error, message
//     }

    
//     public  ResponseEntity<String> getAllStocksAndAllPrices() {	
//         List<String> allCompaniesAndStockPrices = new ArrayList<>();

//         Collections.sort(companies, Comparator.comparing(Ftse100::getStockPrice));

//         for (Ftse100 company : companies) {
//             String companyNameAndStockPrice = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getStockPrice() + " GBX";
//             allCompaniesAndStockPrices.add(companyNameAndStockPrice);
//             }

//             return ResponseEntity.ok(String.join("\n", allCompaniesAndStockPrices));
//             } 
//             // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        

    
//     public ResponseEntity<String> getAllStocksAndMarketCapitalization() {
//         List<String> allCompaniesAndMarketCapitalization = new ArrayList<>();

//         Collections.sort(companies, Comparator.comparing(Ftse100::getMarketCapitalization));

//         for (Ftse100 company : companies) {
//             String companyNameAndMarketCap = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getMarketCapitalization() + " GBP";
//             allCompaniesAndMarketCapitalization.add(companyNameAndMarketCap);
//             }

//             return ResponseEntity.ok(String.join("\n", allCompaniesAndMarketCapitalization));
//             } 
//             // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    
    
//     public ResponseEntity<String> getAllStocksAndAllPriceToEquity() {
//         List<String> allCompaniesAndPriceToEquityRatio = new ArrayList<>();

//         Collections.sort(companies, Comparator.comparing(Ftse100::getPriceToEquityRatio));

//         for (Ftse100 company : companies) {
//             String companyNameAndPriceToEquityRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getPriceToEquityRatio();
//             allCompaniesAndPriceToEquityRatio.add(companyNameAndPriceToEquityRatio);
//             }

//             return ResponseEntity.ok(String.join("\n", allCompaniesAndPriceToEquityRatio));
//             } 
//             // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);


    
//     public ResponseEntity<String> getAllStocksAndAllPriceToBook() {
//         List<String> allCompaniesAndPriceToBookRatio = new ArrayList<>();

//         Collections.sort(companies, Comparator.comparing(Ftse100::getPriceToBookRatio));

//         for (Ftse100 company : companies) {
//             String companyNameAndPriceToBookRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getPriceToBookRatio();
//             allCompaniesAndPriceToBookRatio.add(companyNameAndPriceToBookRatio);
//             }

//             return ResponseEntity.ok(String.join("\n", allCompaniesAndPriceToBookRatio));
//             } 
//             // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 

    
    
//     public ResponseEntity<String> getAllStocksAndAllDebtToEquity() {
//          List<String> allCompaniesAndDebtToEquityRatio = new ArrayList<>();

//         Collections.sort(companies, Comparator.comparing(Ftse100::getDebtToEquityRatio));

//         for (Ftse100 company : companies) {
//             String companyNameAndDebtToEquityRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getDebtToEquityRatio() + "%";
//             allCompaniesAndDebtToEquityRatio.add(companyNameAndDebtToEquityRatio);
//             }

//             return ResponseEntity.ok(String.join("\n", allCompaniesAndDebtToEquityRatio));
//             }
//             // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 

        
    
//     public ResponseEntity<String> getAllStocksAndAllEsgRatings() {
//         List<String> allCompaniesAndEsgRatings = new ArrayList<>();

//         Collections.sort(companies, Comparator.comparing(Ftse100::getEsgRiskRating));

//         for (Ftse100 company : companies) {
//             String companyNameAndEsgRating = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getEsgRiskRating();
//             allCompaniesAndEsgRatings.add(companyNameAndEsgRating);
//             }

//             return ResponseEntity.ok(String.join("\n", allCompaniesAndEsgRatings));
//             } 
//             // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
// }  


                // exceptions are thrown when conditions havent been met 
                // need to update code below to throw an exception in the format of the 
                // exception class I have created 
                // try to use something that is already working (keep it simple)
                // using what is here already
                // basic exception first then see if and why I want to replace it 
                // make sure I really need it 
                // documentation - write in java doc syntax 
                // presenting a structure of the classes and 
                //interfaces - can be autogenerated (diagram to show program structure)
                // creating class diagrams (Java)
                // any built in functionalities?
                // modelling project - adding a diagram to model it all - class diagram 
//             // exception handling 
// presenting use cases - diagram sshowing the use cases 
// who is doing which action and how which part of my project is acting 
// user does this and makes this request and this happens in response 
// use case diagrams 
//connecting all the pieces with documentation
//             // error handling approriate bodies and status codes 
//             // format json in my local host port if I c
//             // writing back to my json file also when things are created???
//             // rest template also 
//             // organise the structure of my code 

        

      
