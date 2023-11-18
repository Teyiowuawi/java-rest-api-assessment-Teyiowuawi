package com.cbfacademy.apiassessment.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.Ftse100JsonFileHandler;
import com.cbfacademy.apiassessment.bubblesortalgo.BubbleSortAlgo;
import com.cbfacademy.apiassessment.crud.Ftse100AdditionalCrud;
import com.cbfacademy.apiassessment.datamodel.Ftse100;
import com.cbfacademy.apiassessment.exceptionhandling.CompanyAlreadyExistsException;
import com.cbfacademy.apiassessment.exceptionhandling.CompanyDoesNotExistException;

@Repository 
public class Ftse100Respository implements Ftse100AdditionalCrud {

    private String jsonFile = "src/main/resources/ftse101.json";
    
    Ftse100JsonFileHandler fileHandler = new Ftse100JsonFileHandler();
    private List<Ftse100> companies = fileHandler.readFtse100JsonFile(jsonFile);
    
    public ResponseEntity<Ftse100> addFtse100Company(Ftse100 newCompany){
		for (Ftse100 existingCompany : companies){
			if (newCompany.getTickerSymbol().equalsIgnoreCase(existingCompany.getTickerSymbol())){
                throw new CompanyAlreadyExistsException("FTSE100 company already present with Ticker Symbol: " + existingCompany.getTickerSymbol());
				}} 
                companies.add(newCompany);
                fileHandler.ftse100WriteToJsonFile(jsonFile, companies);
                return ResponseEntity.status(HttpStatus.CREATED).body(newCompany);           
    }       

    
    public ResponseEntity<List<Ftse100>> getAllFtse100Companies() {
        return ResponseEntity.ok(companies);
    }

    
    public ResponseEntity<Ftse100> getFtse100CompanyByTickerSymbol(String tickerSymbol){
        for (Ftse100 company : companies){
                if (company.getTickerSymbol().equalsIgnoreCase(tickerSymbol)){
                    return ResponseEntity.ok(company);
                }} 
        
        throw new CompanyDoesNotExistException("No FTSE100 company present with Ticker Symbol: " + tickerSymbol);       
    }

    
    public ResponseEntity<Ftse100> updateFtse100Company(String tickerSymbol, Ftse100 updatedCompany) {
        for (Ftse100 company : companies){
                if (company.getTickerSymbol().equalsIgnoreCase(tickerSymbol)){
                    company.setTickerSymbol(updatedCompany.getTickerSymbol());
                    company.setCompanyName(updatedCompany.getCompanyName());
                    company.setSector(updatedCompany.getSector());
                    company.setStockPrice(updatedCompany.getStockPrice());
                    company.setMarketCapitalization(updatedCompany.getMarketCapitalization());
                    company.setPriceToEquityRatio(updatedCompany.getPriceToEquityRatio());
                    company.setPriceToBookRatio(updatedCompany.getPriceToBookRatio());
                    company.setDebtToEquityRatio(updatedCompany.getDebtToEquityRatio());
                    company.setEsgRiskRating(updatedCompany.getEsgRiskRating());

                    int indexOfCompanyInFtse100List = companies.indexOf(company);
                    companies.set(indexOfCompanyInFtse100List, updatedCompany);
                    fileHandler.ftse100WriteToJsonFile(jsonFile, companies);
                    return ResponseEntity.ok(updatedCompany);
                }}
        throw new CompanyDoesNotExistException("No FTSE100 company present with Ticker Symbol: " + tickerSymbol);
    }

    public ResponseEntity<List<Ftse100>> deleteFtse100Company(String tickerSymbol) {	
		for (Ftse100 company : companies){
            if (company.getTickerSymbol().equalsIgnoreCase(tickerSymbol)){
				companies.remove(company);
                fileHandler.ftse100WriteToJsonFile(jsonFile, companies);
				return ResponseEntity.ok(companies);
				}}
        throw new CompanyDoesNotExistException("No FTSE100 company present with Ticker Symbol: " + tickerSymbol);
    }

    
    public ResponseEntity<String> getCompanyStockAndPrice(String tickerSymbol) {
			for (Ftse100 company : companies){
                if (company.getTickerSymbol().equalsIgnoreCase(tickerSymbol)){
                    String companyTickerSymbolAndStockPrice = company.getCompanyName() + " (" + tickerSymbol + ")" + ": " + company.getStockPrice();
                    return ResponseEntity.ok(companyTickerSymbolAndStockPrice);
                }}
            throw new CompanyDoesNotExistException("No FTSE100 company present with Ticker Symbol: " + tickerSymbol);
            }

    
    public ResponseEntity<List<String>> getAllStocksAndAllPrices(){
        return ResponseEntity.ok(BubbleSortAlgo.bubbleSortStockPrices(companies));
    }
    

    public ResponseEntity<List<String>> getAllStocksAndMarketCapitalization() {
        List<String> allCompaniesAndMarketCapitalization = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getMarketCapitalization));

        for (Ftse100 company : companies) {
            String companyNameAndMarketCap = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getMarketCapitalization() + " GBP";
            allCompaniesAndMarketCapitalization.add(companyNameAndMarketCap);
            }

            return ResponseEntity.ok(allCompaniesAndMarketCapitalization);
        } 

    
    
    public ResponseEntity<List<String>> getAllStocksAndAllPriceToEquity() {
        List<String> allCompaniesAndPriceToEquityRatio = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getPriceToEquityRatio));

        for (Ftse100 company : companies) {
            String companyNameAndPriceToEquityRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getPriceToEquityRatio();
            allCompaniesAndPriceToEquityRatio.add(companyNameAndPriceToEquityRatio);
            }

            return ResponseEntity.ok(allCompaniesAndPriceToEquityRatio);
        } 


    
    public ResponseEntity<List<String>> getAllStocksAndAllPriceToBook() {
        List<String> allCompaniesAndPriceToBookRatio = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getPriceToBookRatio));

        for (Ftse100 company : companies) {
            String companyNameAndPriceToBookRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getPriceToBookRatio();
            allCompaniesAndPriceToBookRatio.add(companyNameAndPriceToBookRatio);
            }

            return ResponseEntity.ok(allCompaniesAndPriceToBookRatio);
        } 

    
    public ResponseEntity<List<String>> getAllStocksAndAllDebtToEquity() {
         List<String> allCompaniesAndDebtToEquityRatio = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getDebtToEquityRatio));

        for (Ftse100 company : companies) {
            String companyNameAndDebtToEquityRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getDebtToEquityRatio() + "%";
            allCompaniesAndDebtToEquityRatio.add(companyNameAndDebtToEquityRatio);
            }

            return ResponseEntity.ok(allCompaniesAndDebtToEquityRatio);
        }

        
    
    public ResponseEntity<List<String>> getAllStocksAndAllEsgRatings() {
        List<String> allCompaniesAndEsgRatings = new ArrayList<>();

        Collections.sort(companies, Comparator.comparing(Ftse100::getEsgRiskRating));

        for (Ftse100 company : companies) {
            String companyNameAndEsgRating = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getEsgRiskRating();
            allCompaniesAndEsgRatings.add(companyNameAndEsgRating);
            }
            return ResponseEntity.ok(allCompaniesAndEsgRatings);
        } 
}  
   

