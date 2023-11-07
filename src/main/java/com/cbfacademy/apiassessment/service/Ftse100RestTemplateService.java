package com.cbfacademy.apiassessment.service;


import java.util.Arrays;
import java.util.Collections;
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

    // look at the next youtube video to add these links to application propeties instead"

    public ResponseEntity<List<Ftse100>> allCompanies(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        
        ResponseEntity<List<Ftse100>> response = restTemplate.exchange(getAllCompaniesURL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Ftse100>>(){});
        return response; 
    }

    public ResponseEntity<Ftse100> addCompany(Ftse100 ftse100){
        return restTemplate.postForEntity(addNewCompanyURL, ftse100, Ftse100.class); 
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

    public ResponseEntity<String> getCompaniesAndStockPrices(){
        ResponseEntity<String> response = restTemplate.exchange(getCompaniesAndStockPricesURL, HttpMethod.GET, null, String.class);
        return response;
    }


    


}
