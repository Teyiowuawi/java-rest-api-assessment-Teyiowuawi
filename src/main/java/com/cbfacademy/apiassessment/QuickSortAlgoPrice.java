package com.cbfacademy.apiassessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.cbfacademy.apiassessment.datamodel.Ftse100;

public class QuickSortAlgoPrice {
    
    // think about the comparator
    // array - hashmap two items name and value of price
    // company name and company price
    // give sort algo this array
    // start and end index (1ist object and last object)
    // pivot point - value of the price for the item at the end index
    //pivot = array 9  = .getPrice() will be compared to all the other

    String jsonfile = "/ftse100.json";
    
    private List<Ftse100> companies = Ftse100JsonFileReader.readFtse100JsonFile(jsonfile);

    public HashMap<String, Double> convertFromListOfCompanyObjectsToCompanyAndStockPriceHashMap(){
    HashMap<String, Double> companyStockPrice = new HashMap<String, Double>();
        for (Ftse100 company: companies){
            companyStockPrice.put(company.getCompanyName(), company.getStockPrice());
            }
            return companyStockPrice;
        }
    
    public void sortCompanyStockPrices(){
    QuickSortAlgoPrice sortingStockPrice = new QuickSortAlgoPrice();
    List<Double> extractedPriceValues = new ArrayList<>(convertFromListOfCompanyObjectsToCompanyAndStockPriceHashMap().values());
    quickSort(extractedPriceValues, 0, extractedPriceValues.size() - 1);
    }

    // create new hashmap to store values inside!

    public static void quicksort(List<Double> list, int low, int high){
        
        if (low < high){
           int pivotIndex = partition(list, low, high);
           quickSort(list, low, pivotIndex -1);
           quickSort(list, pivotIndex + 1, high);
        }
    }

    public static int partition(List<Double> list, int low, int high){
        double pivot = list.get(high);
        int i = low -1; 

        for (int j = low; j < high; j++){
            if (list.get(j) < pivot){
                i++;
                Collections.swap(list, i,j);
            }    
        }

        Collections.swap(list, i + 1, high);
        return i + 1;
        }

    // public static void swap(List<Double> extractedPriceValues, int i, int j){
    //     double temp = extractedPriceValues.get(i);
    //     extractedPriceValues.set(i, extractedPriceValues.get(j));
    //     extractedPriceValues.set(j, temp);  
    // }  
    

    


//     }
//     // call quicksort on this hashmap 
//     // cant be directly done 
//     // extract the values from the hashmap 
//     // then call quicksort on it 
//     // then convert back into my data structure 

//     // alternatively sort list of objects and then place these specific valueus into a hashmap
    


