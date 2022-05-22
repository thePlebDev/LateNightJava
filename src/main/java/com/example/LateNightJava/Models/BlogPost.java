package com.example.LateNightJava.Models;


public class BlogPost {

    private String title;
    private Long id;


    public BlogPost(String title, Long id){
        this.title = title;
        this.id = id;
    }

    //GETTERS
    public String getTitle() {
        return title;
    }
    public Long getId() {
        return id;
    }

    //SETTERS
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
