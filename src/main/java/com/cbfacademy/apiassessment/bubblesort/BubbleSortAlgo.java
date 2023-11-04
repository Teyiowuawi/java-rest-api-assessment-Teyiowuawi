package com.cbfacademy.apiassessment.bubblesort;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


import com.cbfacademy.apiassessment.Ftse100JsonFileReader;
import com.cbfacademy.apiassessment.datamodel.Ftse100;

public class BubbleSortAlgo {
    String jsonfile = "/ftse100.json";
    
    private List<Ftse100> companies = Ftse100JsonFileReader.readFtse100JsonFile(jsonfile);
    
    public HashMap<String, Double> extractCompanyAndStockPriceFromFtse100List(){
        HashMap<String, Double> companyStockPrice = new HashMap<String, Double>();
            for (Ftse100 company: companies){
                companyStockPrice.put(company.getCompanyName(), company.getStockPrice());
            }
                return companyStockPrice;
        }

        public HashMap<String, Double> bubbleSortHashMapByStockPrice(HashMap<String, Double> unsortedHashMap){
            List<HashMap.Entry<String, Double>> stockPricesUnsorted = new ArrayList<>(extractCompanyAndStockPriceFromFtse100List().entrySet());
            boolean swapped; 
            int n = stockPricesUnsorted.size(); 

            do{
                swapped = false; 
                for (int i = 0; i < n -1; i++){
                    if (stockPricesUnsorted.get(i).getValue() > stockPricesUnsorted.get(i + 1).getValue()){
                        HashMap.Entry<String, Double> temp = stockPricesUnsorted.get(i);
                        stockPricesUnsorted.set(i, stockPricesUnsorted.get(i +1));
                        stockPricesUnsorted.set(i + 1, temp);
                        swapped = true;
                    }
                }
                n--;
            } while (swapped);

            HashMap<String, Double> stockPricesSortedHashMap = new HashMap<>();
            for (HashMap.Entry<String, Double> stockPrice: stockPricesUnsorted){
                stockPricesSortedHashMap.put(stockPrice.getKey(), stockPrice.getValue());
            }

            return stockPricesSortedHashMap;
        }
}
