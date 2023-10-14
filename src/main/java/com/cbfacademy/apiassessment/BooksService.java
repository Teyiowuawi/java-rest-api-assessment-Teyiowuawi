package com.cbfacademy.apiassessment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BooksService {

    private List<Books> books = new ArrayList<>();

    public List<Books> getAllBooks(){
        return books;
    }
    
 

}
