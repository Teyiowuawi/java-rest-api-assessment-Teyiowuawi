package com.cbfacademy.apiassessment;

public class Books {

    private int id;
    private String title; 
    private String author;

    public Books(int id, String title, String author){
        this.id = id; 
        this.title = title;
        this.author = author; 
    }

        public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
