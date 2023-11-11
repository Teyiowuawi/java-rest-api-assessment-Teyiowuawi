package com.cbfacademy.apiassessment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.List;


import com.cbfacademy.apiassessment.datamodel.Ftse100;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Ftse100JsonFileHandler{
    private String file;

    public Ftse100JsonFileHandler(String file){
        this.file = file;
    }
    

    public List<Ftse100> readFtse100JsonFile(String file){
        Gson gson = new Gson();
			
		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
			return gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
        } catch (IOException e){
            System.out.println("File not found. Please ensure this file is in the correct location and it exists");
        e.printStackTrace();
        return Collections.emptyList();
        }
    }


    public void ftse100WriteToJsonFile(String file, List<Ftse100> companies){
        Gson gson = new Gson();

                try (Writer writer = new FileWriter(file)){
                    gson.toJson(companies, writer);
                } catch(IOException e) {
                    System.out.println("File not found. Please ensure this file is in the correct location and it exists");
                    e.printStackTrace();
                }
            } 
 
}
