package com.cbfacademy.apiassessment.service;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
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
   
    @Value("${rest.url.base}")
    private String baseUrl;

    @Value("${rest.url.companies}") 
    private String getAllCompaniesURL;
    
    @Value("${rest.url.companies}") 
    private String addNewCompanyURL;
     
    @Value("${rest.url.company}") 
    private String getCompanyURL;

    @Value("${rest.url.company}")
    private String updateCompanyURL;

    @Value("${rest.url.company}")
    private String deleteCompanyURL;

    @Value("${rest.url.stockPrices}")
    private String getCompanyAndStockPriceURL;

    @Value("${rest.url.stockPrices.all}")
    private String getCompaniesAndStockPricesURL;

    @Value("${rest.url.marketCapitalization}")
    private String getCompaniesAndMarketCapURL;

    @Value("${rest.url.priceToEquity}")
    private String getCompaniesAndPriceToEquityURL;

    @Value("${rest.url.priceToBook}")
    private String getCompaniesAndPriceToBookURL;

    @Value("${rest.url.debtToEquity}")
    private String getCompaniesAndDebtToEquityURL;
    
    @Value("${rest.url.esg}")
    private String getCompaniesAndEsgRiskRatingURL;
    
     RestTemplate restTemplate = new RestTemplate();
    
    //exception handling - remember to try and then catch these errors!

    public ResponseEntity<List<Ftse100>> allCompanies(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        
        ResponseEntity<List<Ftse100>> response = restTemplate.exchange(baseUrl + getAllCompaniesURL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Ftse100>>(){});
        return response; 
    }

    public ResponseEntity<Ftse100> addCompany(Ftse100 ftse100){
        try{
            return restTemplate.postForEntity(baseUrl + addNewCompanyURL, ftse100, Ftse100.class);
        } catch (CompanyAlreadyExistsException e){
            throw new CompanyAlreadyExistsException(e.getMessage());
         }
    }

    public Ftse100 getCompany(String tickerSymbol){
        Map<String, String> param = new HashMap<String,String>();
        param.put("tickerSymbol", tickerSymbol);

        return restTemplate.getForObject( baseUrl + getCompanyURL, Ftse100.class, param);
    }


    public void updateCompany(String tickerSymbol, Ftse100 updatedCompany){
        Map<String, String> params = new HashMap<String, String>();
        params.put("tickerSymbol", tickerSymbol);

        restTemplate.put(baseUrl + updateCompanyURL, updatedCompany, params);
    }

    public void deleteCompany(String tickerSymbol) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("tickerSymbol", tickerSymbol);

        restTemplate.delete(baseUrl + deleteCompanyURL, param);
    }

    public ResponseEntity<String> getCompanyAndPrice(String tickerSymbol){
        ResponseEntity<String> response = restTemplate.exchange(baseUrl + "stockPrices/" + getCompanyAndStockPriceURL, HttpMethod.GET, null, String.class, tickerSymbol);
        return response;
    }

    public ResponseEntity<List<String>> getCompaniesAndPrices(){
        ResponseEntity<List<String>> response = restTemplate.exchange(baseUrl + "stockPrices/" + getCompaniesAndStockPricesURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }


    public ResponseEntity<List<String>> getCompaniesAndMarketCap(){
        ResponseEntity<List<String>> response = restTemplate.exchange(baseUrl + getCompaniesAndMarketCapURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

    public ResponseEntity<List<String>> getCompaniesAndPriceToEquity(){
        ResponseEntity<List<String>> response = restTemplate.exchange(baseUrl + getCompaniesAndPriceToEquityURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

    public ResponseEntity<List<String>>getCompaniesAndPriceToBook(){
        ResponseEntity<List<String>> response = restTemplate.exchange(baseUrl + getCompaniesAndPriceToBookURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

    public ResponseEntity<List<String>> getCompaniesAndDebtToEquity(){
        ResponseEntity<List<String>> response = restTemplate.exchange(baseUrl + getCompaniesAndDebtToEquityURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

    public ResponseEntity<List<String>>getCompaniesAndEsgRiskRating(){
        ResponseEntity<List<String>> response = restTemplate.exchange(baseUrl + getCompaniesAndEsgRiskRatingURL, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>(){});
        return response;
    }

}
