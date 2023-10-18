package com.cbfacademy.apiassessment;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class BooksService {

    private List<Books> books = new ArrayList<>();

    public List<Books> getAllBooks(){
        Gson gson = new Gson();
        
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("books.json"))){
            books = gson.fromJson(reader, new TypeToken<List<Books>>() {}.getType());
        } catch (IOException e){
            e.printStackTrace();
        }
        return books;
    }

    public void getBookById(long id){
        Gson gson = new Gson();
        
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream("books.json"))){
            books = gson.fromJson(reader, new TypeToken<List<Books>>() {}.getType());
            for (Books book : books){
                if (book.getId().equals(id)){
                    System.out.println(book);
                }}}
                catch (IOException e){
            e.printStackTrace();
        }
    }
}               
                
        // example code from rest-api-exercise
        // @GetMapping(value = "/{id}", produces = "application/json")
        // public ResponseEntity<IOU> getIOUByID(@PathVariable UUID id){
        //     for (IOU iou : ious){
        //      if  (iou.getId().equals(id)){
        //         return ResponseEntity.ok(iou);
