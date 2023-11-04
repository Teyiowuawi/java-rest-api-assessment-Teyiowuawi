package com.cbfacademy.apiassessment.bubblesort;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BubbleSortAlgo {
    
        public String bubbleSortHashMapByStockPrice(HashMap<String, Double> unsortedPricesHashMap){
            List<HashMap.Entry<String, Double>> stockPrices = new ArrayList<>(unsortedPricesHashMap.entrySet());
            
            String temp;
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
        
            for (HashMap.Entry<String, Double> stockPrice: stockPrices){
                return String.join("\n", stockPrices.put(stockPrice.getKey(), stockPrice.getValue());
            }

            return stockPricesSortedHashMap;
        }
    }

        

        
        

