package com.cbfacademy.apiassessment.bubblesortalgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.cbfacademy.apiassessment.datamodel.Ftse100;

public class BubbleSortAlgo {
    
    // public static HashMap<String, Double> bubbleSortStockPrices(HashMap<String, Double> unsortedPricesHashMap){
    //     List<HashMap.Entry<String, Double>> stockPrices = new ArrayList<>(unsortedPricesHashMap.entrySet());
        
    //     boolean swapped = false;
    //     int prices = stockPrices.size(); 

    //     while(!swapped){
    //         swapped = true; 
    //         for (int i = 0; i < prices -1; i++){
    //             if (stockPrices.get(i).getValue() > stockPrices.get(i + 1).getValue()){
    //                 HashMap.Entry<String, Double> stockPrice = stockPrices.get(i);
    //                 stockPrices.set(i, stockPrices.get(i + 1));
    //                 stockPrices.set(i + 1, stockPrice);
    //                 swapped = false;
    //             }
    //         }
    //     }
        

    //     HashMap<String, Double> sortedPrices = new LinkedHashMap<>();
    
    //     for (HashMap.Entry<String, Double> stockPrice: stockPrices){
    //         sortedPrices.put(stockPrice.getKey(), stockPrice.getValue());
    //     }
    //     return sortedPrices;
    // }

    public static List<String> bubbleSortStockPrices(List<Ftse100> companies){
        
        boolean swapped = false;
        int allPrices = companies.size(); 

        while(!swapped){
            swapped = true; 
            for (int i = 0; i < allPrices -1; i++){
                if (companies.get(i).getStockPrice() > companies.get(i + 1).getStockPrice()){
                    Ftse100 price = companies.get(i);
                    companies.set(i, companies.get(i + 1));
                    companies.set(i + 1, price);
                    swapped = false;
                }
            }
        }

        List<String> sortedPrices = new ArrayList<>();
    
        for (Ftse100 company : companies){
            sortedPrices.add(company.getCompanyName() + " (" + company.getTickerSymbol() + "): " + company.getStockPrice() + " GBX");
        }
        return sortedPrices;
    }
}
