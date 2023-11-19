package com.cbfacademy.apiassessment.bubblesortalgo;

import java.util.ArrayList;
import java.util.List;

import com.cbfacademy.apiassessment.datamodel.Ftse100;

public class BubbleSortAlgo {

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
