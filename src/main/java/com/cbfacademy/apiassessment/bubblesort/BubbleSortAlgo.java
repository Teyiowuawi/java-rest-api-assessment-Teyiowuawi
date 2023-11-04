package com.cbfacademy.apiassessment.bubblesort;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class BubbleSortAlgo {
    
        public HashMap<String, Double> bubbleSortHashMapByStockPrice(HashMap<String, Double> unsortedPricesHashMap){
            List<HashMap.Entry<String, Double>> stockPricesUnsorted = new ArrayList<>(unsortedPricesHashMap.entrySet());
            boolean swapped; 
            int prices = stockPricesUnsorted.size(); 

            do{
                swapped = false; 
                for (int i = 0; i < prices -1; i++){
                    if (stockPricesUnsorted.get(i).getValue() > stockPricesUnsorted.get(i + 1).getValue()){
                        HashMap.Entry<String, Double> temp = stockPricesUnsorted.get(i);
                        stockPricesUnsorted.set(i, stockPricesUnsorted.get(i +1));
                        stockPricesUnsorted.set(i + 1, temp);
                        swapped = true;
                    }
                }
                prices --;
            } while (swapped);

            HashMap<String, Double> stockPricesSortedHashMap = new HashMap<>();
            for (HashMap.Entry<String, Double> stockPrice: stockPricesUnsorted){
                stockPricesSortedHashMap.put(stockPrice.getKey(), stockPrice.getValue());
            }

            return stockPricesSortedHashMap;
        }
    }

        

        
        

