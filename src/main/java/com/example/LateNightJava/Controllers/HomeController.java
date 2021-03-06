package com.example.LateNightJava.Controllers;

import com.example.LateNightJava.Models.BlogPost;
import com.example.LateNightJava.Paser.Scanner;
import com.example.LateNightJava.Paser.Token;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {


    @GetMapping
    public String getAllPosts(Model model){
        model.addAttribute("posts", Arrays.asList(
                new BlogPost("Creating a Java HTML parser. Part 1. Where to start?",1l),
                new BlogPost("Creating a Java HTML parser. Part 2. Parsing?",2l),
                new BlogPost("Creating a Java HTML parser. Part 2. Parsing?",3l)
        ));
        model.addAttribute("title","Creating an MVC framework. Part 1. Tomcat");

        return "home";
    }

}
