package com.cbfacademy.apiassessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class Ftse100AdditionalService implements Ftse100AdditionalCrud {
    private List<Ftse100> companies = Ftse100JsonFileReader.readFtse100JsonFile("ftse100.json");

    @Override
    public ResponseEntity<String> getStockAndPrice(String tickerSymbol) {
			for (Ftse100 company : companies){
                if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
                    return ResponseEntity.ok(company.getCompanyName() + " (" + tickerSymbol + ")" + ": " + company.getStockPrice() + " GBX");
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                // adding to the body of this request through proper exception handling
                // Timestamp, status, error, message
    }

    @Override
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
        

    @Override
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

    
    @Override
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


    @Override
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

    
    @Override
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

        
    @Override
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


			//Add a patch request to my methods! - in my interface and implementing class 
            // exception handling 
            // error handling approriate bodies and status codes 
            // format json in my local host port if I can
            // writing back to my json file also when things are created???
            // rest template also   
            // organise the structure of my code


