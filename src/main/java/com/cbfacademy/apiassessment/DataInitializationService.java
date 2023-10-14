package com.cbfacademy.apiassessment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class DataInitializationService {
    private List<Books> books;

    @Autowired
    public DataInitializationService(){
        Gson gson = new Gson();
        
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("/books.json"))){
            books = gson.fromJson(reader, new TypeToken<List<Books>>() {}.getType());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<Books> getBooks(){
        return books;
    }
}
