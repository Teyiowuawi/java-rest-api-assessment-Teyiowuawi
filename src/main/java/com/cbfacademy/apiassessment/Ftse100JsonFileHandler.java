package com.cbfacademy.apiassessment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
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
			
		try (Reader reader = new InputStreamReader(Ftse100JsonFileHandler.class.getResourceAsStream(file))){
			return gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
        } catch (IOException e){
        e.printStackTrace();
        return Collections.emptyList();
        }
    }

    public void ftse100WriteToJsonFile(List<Ftse100>companies){

        try {
        
            OutputStream outputStream  = new FileOutputStream(new File(Ftse100JsonFileHandler.class.getResource("/ftse101.json").getFile()));
            Writer writer = new OutputStreamWriter(outputStream);
            Gson gson = new Gson();
            writer.write(gson.toJson(companies));
            writer.close();
                } catch(IOException e) {
                    System.out.println("File not found. Please ensure this file is in the correct location and it exists");
                    e.printStackTrace();
                }
            } 

            // currently store in resources folder 
            // is that the reason why i can edit it? because it is read only? 
            // create temporary file to write to and then overwrite it?

    // public void ftse100WriteToJsonFile(String file, List<Ftse100> companies){
    //     Gson gson = new Gson();

    //             try (Writer writer = new FileWriter(file)){
    //                 gson.toJson(companies, writer);
    //             } catch(IOException e) {
    //                 System.out.println("File not found. Please ensure this file is in the correct location and it exists");
    //                 e.printStackTrace();
    //             }
    //         } 
 
}
