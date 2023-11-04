package com.cbfacademy.apiassessment;

import java.util.HashMap;
import java.util.List;

import com.cbfacademy.apiassessment.datamodel.Ftse100;

public class QuickSortAlgoPrice {
    
   
    // would i instead place my list of companies inside the constructor rather than reading from the kson file again?
    public QuickSortAlgoPrice(){}
    // think about the comparator
    // array - hashmap two items name and value of price
    // company name and company price
    // give sort algo this array
    // start and end index (1ist object and last object)
    // pivot point - value of the price for the item at the end index
    //pivot = array 9  = .getPrice() will be compared to all the other

    String jsonfile = "/ftse100.json";
    
    private List<Ftse100> companies = Ftse100JsonFileReader.readFtse100JsonFile(jsonfile);


    public HashMap<String, Double> companiesAndStockPrice(){
        HashMap<String, Double> companyStockPrice = new HashMap<String, Double>();
        for (Ftse100 company: companies){
            companyStockPrice.put(company.getCompanyName(), company.getStockPrice());
            }
            return companyStockPrice;
    }
    // call quicksort on this hashmap 
}
