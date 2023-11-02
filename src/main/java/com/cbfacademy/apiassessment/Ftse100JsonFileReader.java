package com.cbfacademy.apiassessment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Ftse100JsonFileReader {
    
    public static List<Ftse100> readFtse100JsonFile(String jsonFile){
        Gson gson = new Gson();
			
		try (Reader reader = new InputStreamReader(Ftse100JsonFileReader.class.getResourceAsStream(jsonFile))){
			return gson.fromJson(reader, new TypeToken<List<Ftse100>>() {}.getType());
        } catch (IOException e){
        e.printStackTrace();
        return Collections.emptyList();
        }
    }
 
}
