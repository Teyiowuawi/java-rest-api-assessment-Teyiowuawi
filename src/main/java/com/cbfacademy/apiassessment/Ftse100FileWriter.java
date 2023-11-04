package com.cbfacademy.apiassessment;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.cbfacademy.apiassessment.datamodel.Ftse100;
import com.google.gson.Gson;

public class Ftse100FileWriter {

    public static void Ftse100WriteToJsonFile(List<Ftse100> companies){
        
        Gson gson = new Gson();
        String json = gson.toJson(companies);

                String jsonFile;
                try (FileWriter writer = new FileWriter(jsonFile)){
                    writer.write(json);
                } catch(IOException e) {
                    System.out.println("Fle not found. Please ensure this file is in the correct location");
                    e.printStackTrace();
                }
            }    
    
}
