package com.cbfacademy.apiassessment.bubblesortalgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BubbleSortAlgo {
    
    public static HashMap<String, Double> bubbleSortStockPrices(HashMap<String, Double> unsortedPricesHashMap){
        List<HashMap.Entry<String, Double>> stockPrices = new ArrayList<>(unsortedPricesHashMap.entrySet());
        
        boolean swapped = false; 
        int prices = stockPrices.size(); 

        while(!swapped)
            swapped = true; 
            for (int i = 0; i < prices -1; i++){
                if (stockPrices.get(i).getValue() > stockPrices.get(i + 1).getValue()){
                    HashMap.Entry<String, Double> stockPrice = stockPrices.get(i);
                    stockPrices.set(i, stockPrices.get(i + 1));
                    stockPrices.set(i + 1, stockPrice);
                    swapped = false;
                }
            }

        HashMap<String, Double> sortedPrices = new HashMap<>();
    
        for (HashMap.Entry<String, Double> stockPrice: stockPrices){
            sortedPrices.put(stockPrice.getKey(), stockPrice.getValue());
        }

        return sortedPrices;
    }
}
