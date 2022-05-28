package com.example.LateNightJava.Models;

import javax.persistence.*;

@Entity(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String authority;

    public User() {
    }

    public User(String username, String password, String authority){
        this.username = username;
        this.authority = authority;
        this.password = password;
    }

    //GETTERS
    public String getUsername(){
        return this.username;
    }

    public String getAuthority() {
        return authority;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    //SETTERS
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
