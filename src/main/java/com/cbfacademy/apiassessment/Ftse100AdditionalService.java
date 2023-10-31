package com.cbfacademy.apiassessment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class Ftse100AdditionalService implements Ftse100AdditionalCrud {
  
    private List<Ftse100> companies = new ArrayList<>();

    @Override
    public ResponseEntity<String> getStockAndPrice(String tickerSymbol) {
        Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
			for (Ftse100 company : companies){
                if (company.getTickerSymbol().toUpperCase().equals(tickerSymbol.toUpperCase())){
                return ResponseEntity.ok(company.getCompanyName() + " (" + tickerSymbol + ")" + ": " + company.getStockPrice() + " GBX");
                }}} catch (IOException e){
                    e.printStackTrace();
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                //what can I add to the body of my HTTP request? - json instance of the exception perhaps 
                    // with all of the data and the ID
                    //Or actually just the ticker symbol - timestamp etc 
                    // perhaps the type of request too 
                    // the the message can be the excpetion message
                    //TICKER SYMBOL, Timestamp, something else and the message: Unable to find Company with Ticker symbol + tickerSymbol. Please try again
                // Body message; Ticker symbol does not exist. Please ensure you type in the ticker symbol of an existing company 
               
    }

    @Override
    public  ResponseEntity<String> getAllStocksAndAllPrices() {	
	Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());

            List<String> allCompaniesAndStockPrices = new ArrayList<>();

            Collections.sort(companies, Comparator.comparing(Ftse100::getStockPrice));

            for (Ftse100 company : companies) {
                String companyNameAndStockPrice = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getStockPrice() + " GBX";
                allCompaniesAndStockPrices.add(companyNameAndStockPrice);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndStockPrices));

        } catch (IOException e){
                e.printStackTrace();
             }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            
            //BAD request (please ensure Wesite URL has been typed correctly) or not found for this one? 
        }
 
    
    @Override
    public ResponseEntity<String> getAllStocksAndMarketCapitalization() {
        Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
            
            List<String> allCompaniesAndMarketCapitalization = new ArrayList<>();

            Collections.sort(companies, Comparator.comparing(Ftse100::getMarketCapitalization));

            for (Ftse100 company : companies) {
                String companyNameAndMarketCap = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getMarketCapitalization() + " GBP";
                allCompaniesAndMarketCapitalization.add(companyNameAndMarketCap);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndMarketCapitalization));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    
    @Override
    public ResponseEntity<String> getAllStocksAndAllPriceToEquity() {
    Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
            List<String> allCompaniesAndPriceToEquityRatio = new ArrayList<>();

            Collections.sort(companies, Comparator.comparing(Ftse100::getPriceToEquityRatio));

            for (Ftse100 company : companies) {
                String companyNameAndPriceToEquityRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getPriceToEquityRatio();
                allCompaniesAndPriceToEquityRatio.add(companyNameAndPriceToEquityRatio);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndPriceToEquityRatio));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }


    @Override
    public ResponseEntity<String> getAllStocksAndAllPriceToBook() {
    Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
            List<String> allCompaniesAndPriceToBookRatio = new ArrayList<>();

            Collections.sort(companies, Comparator.comparing(Ftse100::getPriceToBookRatio));

            for (Ftse100 company : companies) {
                String companyNameAndPriceToBookRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getPriceToBookRatio();
                allCompaniesAndPriceToBookRatio.add(companyNameAndPriceToBookRatio);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndPriceToBookRatio));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  

    
    @Override
    public ResponseEntity<String> getAllStocksAndAllDebtToEquity() {
    Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
            List<String> allCompaniesAndDebtToEquityRatio = new ArrayList<>();

            Collections.sort(companies, Comparator.comparing(Ftse100::getDebtToEquityRatio));

            for (Ftse100 company : companies) {
                String companyNameAndDebtToEquityRatio = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getDebtToEquityRatio() + "%";
                allCompaniesAndDebtToEquityRatio.add(companyNameAndDebtToEquityRatio);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndDebtToEquityRatio));} catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  

        
    @Override
    public ResponseEntity<String> getAllStocksAndAllEsgRatings() {
    Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
            List<String> allCompaniesAndEsgRatings = new ArrayList<>();

            Collections.sort(companies, Comparator.comparing(Ftse100::getEsgRiskRating));

            for (Ftse100 company : companies) {
                String companyNameAndEsgRating = company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getEsgRiskRating();
                allCompaniesAndEsgRatings.add(companyNameAndEsgRating);
            }

            return ResponseEntity.ok(String.join("\n", allCompaniesAndEsgRatings));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }  
}

			//Add a patch request to my methods! - in my interface and implementing class 
            // exception handling 
            // error handling approriate bodies and status codes 
            // format json in my local host port if I can
            // writing back to my json file also when things are created???
            // rest template also 
            // exception handling - incorrect argument placed inside the file also  
            // organise the structure of my code

