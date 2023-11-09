package com.cbfacademy.apiassessment.service;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.cbfacademy.apiassessment.datamodel.Ftse100;
import com.cbfacademy.apiassessment.exceptionhandling.CompanyAlreadyExistsException;

@Service
public class Ftse100RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();

    private static final String getAllCompaniesURL = "http://localhost:8080/companies/all";
    private static final String addNewCompanyURL = "http://localhost:8080/companies/all";
    private static final String getCompanyURL = "http://localhost:8080/companies/{tickerSymbol}";
    private static final String updateCompanyURL = "http://localhost:8080/companies/{tickerSymbol}";
    private static final String deleteCompanyURL = "http://localhost:8080/companies/{tickerSymbol}";
    private static final String getCompanyAndStockPriceURL = "http://localhost:8080/companies/stockPrices/{tickerSymbol}";
    private static final String getCompaniesAndStockPricesURL = "http://localhost:8080/companies/stockPrices/all";
    private static final String getCompaniesAndMarketCapURL = "http://localhost:8080/companies/marketCapitalization";
    private static final String getCompaniesAndPriceToEquityURL = "http://localhost:8080/companies/marketCapitalization";
    private static final String getCompaniesAndPriceToBookURL = "http://localhost:8080/companies/priceToBook";
    private static final String getCompaniesAndDebtToEquityURL = "http://localhost:8080/companies/debtToEquity";
    private static final String getCompaniesAndEsgRiskRatingURL = "http://localhost:8080/companies/esg";
    // look at the next youtube video to add these links to application propeties instead"
    //exception handling - remember to try and then catch these errors!

    public ResponseEntity<List<Ftse100>> allCompanies(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        
        ResponseEntity<List<Ftse100>> response = restTemplate.exchange(getAllCompaniesURL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Ftse100>>(){});
        return response; 
    }

    public ResponseEntity<Ftse100> addCompany(Ftse100 ftse100){
        try{
            return restTemplate.postForEntity(addNewCompanyURL, ftse100, Ftse100.class);
        } catch (CompanyAlreadyExistsException e){
            throw new CompanyAlreadyExistsException(e.getMessage());
         }
    }

    public Ftse100 getCompany(String tickerSymbol){
        Map<String, String> param = new HashMap<String,String>();
        param.put("StockPrice", tickerSymbol);

        return restTemplate.getForObject(getCompanyURL, Ftse100.class, param);
    }


    public void updateCompany(String tickerSymbol, Ftse100 updatedCompany){
        Map<String, String> params = new HashMap<String, String>();
        params.put("tickerSymbol", tickerSymbol);

        restTemplate.put(updateCompanyURL, updatedCompany, params);
    }

    public void deleteCompany(String tickerSymbol) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("tickerSymbol", tickerSymbol);

        restTemplate.delete(deleteCompanyURL, param);
    }

    public ResponseEntity<String> getCompanyAndPrice(String tickerSymbol){
        ResponseEntity<String> response = restTemplate.exchange(getCompanyAndStockPriceURL, HttpMethod.GET, null, String.class, tickerSymbol);
        return response;
    }

    public ResponseEntity<List<String>> getCompaniesAndPrices(){
        ResponseEntity<List<String>> response = restTemplate.exchange(getCompaniesAndStockPricesURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }


    public ResponseEntity<List<String>> getCompaniesAndMarketCap(){
        ResponseEntity<List<String>> response = restTemplate.exchange(getCompaniesAndMarketCapURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

    public ResponseEntity<List<String>> getCompaniesAndPriceToEquity(){
        ResponseEntity<List<String>> response = restTemplate.exchange(getCompaniesAndPriceToEquityURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

    public ResponseEntity<List<String>>getCompaniesAndPriceToBook(){
        ResponseEntity<List<String>> response = restTemplate.exchange(getCompaniesAndPriceToBookURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

    public ResponseEntity<List<String>> getCompaniesAndDebtToEquity(){
        ResponseEntity<List<String>> response = restTemplate.exchange(getCompaniesAndDebtToEquityURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

    public ResponseEntity<List<String>>getCompaniesAndEsgRiskRating(){
        ResponseEntity<List<String>> response = restTemplate.exchange(getCompaniesAndEsgRiskRatingURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

}
