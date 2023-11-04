package com.cbfacademy.apiassessment.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.Ftse100JsonFileReader;
import com.cbfacademy.apiassessment.bubblesort.BubbleSortAlgo;
import com.cbfacademy.apiassessment.crud.Ftse100AdditionalCrud;
import com.cbfacademy.apiassessment.datamodel.Ftse100;

@Repository 
public class Ftse100Respository implements Ftse100AdditionalCrud {

    @Autowired
    BubbleSortAlgo bubbleSortAlgo;

    String jsonfile = "/ftse100.json";
    
    private List<Ftse100> companies = Ftse100JsonFileReader.readFtse100JsonFile(jsonfile);
    
    public ResponseEntity<Ftse100> addFtse100Company(Ftse100 newCompany) {
		for (Ftse100 existingCompany : companies){
			if (newCompany.getTickerSymbol().toUpperCase().equals(existingCompany.getTickerSymbol().toUpperCase())){
				return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(null); 
				}}
                companies.add(newCompany);
                return ResponseEntity.status(HttpStatus.CREATED).body(newCompany);
                // writing back to my json file with a method here           
    }       

    
    public ResponseEntity<List<Ftse100>> getAllFtse100Companies() {
        return ResponseEntity.ok(companies);
    }

    
    public ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(String tickerSymbol){
        for (Ftse100 company : companies){
                if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
                    return ResponseEntity.ok(company);
                }} 
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    
    public ResponseEntity<Ftse100> updateFtse100Company(String tickerSymbol, Ftse100 updatedCompany) {
        for (Ftse100 company : companies){
                if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
                    int indexOfCompanyInFtse100List = companies.indexOf(company);
                    companies.set(indexOfCompanyInFtse100List, updatedCompany);
                    return ResponseEntity.ok(updatedCompany);
                }}
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);   
    }
// writing back to my json file with a method here!
// use getters and setters here then return new list of companies 
                

    
    public ResponseEntity<List<Ftse100>> deleteFtse100Company(String tickerSymbol) {	
		for (Ftse100 company : companies){
            if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
				companies.remove(company);
				return ResponseEntity.ok(companies);
				}}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		
    }
    // writing back to my json file with a method here!

    
    public ResponseEntity<String> getCompanyStockAndPrice(String tickerSymbol) {
			for (Ftse100 company : companies){
                if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
                    return ResponseEntity.ok(company.getCompanyName() + " (" + tickerSymbol + ")" + ": " + company.getStockPrice() + " GBX");
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                // adding to the body of this request through proper exception handling
                // Timestamp, status, error, message
    }

    
    public  ResponseEntity<String> getAllStocksAndAllPrices() {	
        List<String> allCompaniesAndStockPrices = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getStockPrice));

        for (Ftse100 company : companies) {
            String companyNameAndStockPrice = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getStockPrice() + " GBX";
            allCompaniesAndStockPrices.add(companyNameAndStockPrice);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndStockPrices));
            } 
            // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    


    // public ResponseEntity<HashMap<String, Double>> getAllFtse100CompaniesAndAllStockPrices(){
    //         HashMap<String, Double> companyStockPrice = new HashMap<String, Double>();
    //         for (Ftse100 company: companies){
    //             companyStockPrice.put(company.getCompanyName(), company.getStockPrice());
    //         }

    //         return ResponseEntity.ok(bubbleSortHashMapByStockPrice(companyStockPrice));
    // }

    public ResponseEntity<HashMap<String, Double>> bubbleSortHashMapByStockPrice(){
        HashMap<String, Double> companyStockPrice = new HashMap<String, Double>();
            for (Ftse100 company: companies){
                companyStockPrice.put(company.getCompanyName(), company.getStockPrice());
            }

        List<HashMap.Entry<String, Double>> stockPricesUnsorted = new ArrayList<>(companyStockPrice.entrySet());
        boolean swapped; 
        int prices = stockPricesUnsorted.size(); 

        do{
            swapped = false; 
            for (int i = 0; i < prices -1; i++){
                if (stockPricesUnsorted.get(i).getValue() > stockPricesUnsorted.get(i + 1).getValue()){
                    HashMap.Entry<String, Double> temp = stockPricesUnsorted.get(i);
                    stockPricesUnsorted.set(i, stockPricesUnsorted.get(i +1));
                    stockPricesUnsorted.set(i + 1, temp);
                    swapped = true;
                }
            }
            prices --;
        } while (swapped);

        HashMap<String, Double> stockPricesSortedHashMap = new HashMap<>();
        for (HashMap.Entry<String, Double> stockPrice: stockPricesUnsorted){
            stockPricesSortedHashMap.put(stockPrice.getKey(), stockPrice.getValue());
        }

        return ResponseEntity.ok(stockPricesSortedHashMap);
    }
    // abtract algo logic to it's own class - currently not working
    // algo not printing out stock prices in order 

    
    public ResponseEntity<String> getAllStocksAndMarketCapitalization() {
        List<String> allCompaniesAndMarketCapitalization = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getMarketCapitalization));

        for (Ftse100 company : companies) {
            String companyNameAndMarketCap = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getMarketCapitalization() + " GBP";
            allCompaniesAndMarketCapitalization.add(companyNameAndMarketCap);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndMarketCapitalization));
            } 
            // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

    
    
    public ResponseEntity<String> getAllStocksAndAllPriceToEquity() {
        List<String> allCompaniesAndPriceToEquityRatio = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getPriceToEquityRatio));

        for (Ftse100 company : companies) {
            String companyNameAndPriceToEquityRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getPriceToEquityRatio();
            allCompaniesAndPriceToEquityRatio.add(companyNameAndPriceToEquityRatio);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndPriceToEquityRatio));
            } 
            // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);


    
    public ResponseEntity<String> getAllStocksAndAllPriceToBook() {
        List<String> allCompaniesAndPriceToBookRatio = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getPriceToBookRatio));

        for (Ftse100 company : companies) {
            String companyNameAndPriceToBookRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getPriceToBookRatio();
            allCompaniesAndPriceToBookRatio.add(companyNameAndPriceToBookRatio);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndPriceToBookRatio));
            } 
            // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 

    
    
    public ResponseEntity<String> getAllStocksAndAllDebtToEquity() {
         List<String> allCompaniesAndDebtToEquityRatio = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getDebtToEquityRatio));

        for (Ftse100 company : companies) {
            String companyNameAndDebtToEquityRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getDebtToEquityRatio() + "%";
            allCompaniesAndDebtToEquityRatio.add(companyNameAndDebtToEquityRatio);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndDebtToEquityRatio));
            }
            // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 

        
    
    public ResponseEntity<String> getAllStocksAndAllEsgRatings() {
        List<String> allCompaniesAndEsgRatings = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getEsgRiskRating));

        for (Ftse100 company : companies) {
            String companyNameAndEsgRating = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getEsgRiskRating();
            allCompaniesAndEsgRatings.add(companyNameAndEsgRating);
            }
            return ResponseEntity.ok(String.join("\n", allCompaniesAndEsgRatings));
            } 
            // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
}  
   

