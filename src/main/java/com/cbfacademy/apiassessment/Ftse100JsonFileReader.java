package com.cbfacademy.apiassessment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Ftse100JsonFileReader {
    
    public JsonFileReader(){}

    List<Ftse100> companies = new ArrayList<>();

    public List<Ftse100> convertJsonToPojo(){
       
        Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("ftse100.json"))){
			companies = gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
        } catch (IOException e){
        e.printStackTrace();
    }    return companies;
}
// does this need to be a static method? 

// could real the file then set the company as an instance of a class 
// creating objects of that class with my list of FTse100 then I can carry out these methods on them? i think?
}
