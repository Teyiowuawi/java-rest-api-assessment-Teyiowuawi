package com.cbfacademy.apiassessment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;


import com.cbfacademy.apiassessment.datamodel.Ftse100;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Ftse100JsonFileHandler{

    private String jsonFile;

    public Ftse100JsonFileHandler(String jsonFile){
        this.jsonFile = jsonFile;
    }
    
    public List<Ftse100> readFtse100JsonFile(String jsonFile){
        Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(Ftse100JsonFileHandler.class.getResourceAsStream(jsonFile))){
			return gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
        } catch (IOException e){
        e.printStackTrace();
        return Collections.emptyList();
        }
    }

    public void ftse100WriteToJsonFile(List<Ftse100> companies){
        Gson gson = new Gson();
        String json = gson.toJson(companies);

                try (FileWriter writer = new FileWriter(jsonFile)){
                    writer.write(json);
                } catch(IOException e) {
                    System.out.println("File not found. Please ensure this file is in the correct location");
                    e.printStackTrace();
                }
            } 
 
}
