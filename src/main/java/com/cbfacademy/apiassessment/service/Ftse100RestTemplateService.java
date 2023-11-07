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

@Service
public class Ftse100RestTemplateService {

    RestTemplate restTemplate = new RestTemplate();

    private static final String getAllCompaniesURL = "http://localhost:8080/companies/all";
    private static final String addNewCompanyURL = "http://localhost:8080/companies/all";
    private static final String getCompanyURL = "http://localhost:8080/companies/{tickerSymbol}";
    private static final String updateCompanyURL = "http://localhost:8080/companies/{tickerSymbol}";
    private static final String deleteCompanyURL = "http://localhost:8080/companies/{tickerSymbol}";

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
        param.put("tickerSymbol", tickerSymbol);
        return restTemplate.getForObject(getCompanyURL, Ftse100.class, param);
        //working
    }


    public void updateCompany(Ftse100 ftse100){
     restTemplate.put(updateCompanyURL, ftse100);
     // not working
}

    public void deleteCompany(String tickerSymbol) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("tickerSymbol", tickerSymbol);
        restTemplate.delete(deleteCompanyURL, param);
        //working
    }
}
