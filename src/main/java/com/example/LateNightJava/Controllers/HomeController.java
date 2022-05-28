package com.example.LateNightJava.Controllers;

import com.example.LateNightJava.Models.BlogPost;
import com.example.LateNightJava.Paser.Scanner;
import com.example.LateNightJava.Paser.Token;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("blog-post/1")
    public String getFirstBlogPost(Model model){
        model.addAttribute("title","Creating an MVC. Part 1. Tomcat");
        return "blogPostOne";
    }

    @GetMapping("blog-post/2")
    public String getSecondBlogPost(Model model){
        model.addAttribute("title","Welcome to Late Night Java");
        return "blogPostTwo";
    }

    /**
     * TODO: WRITE HTML TO THE BLOGPOST.HTML FILE
     * currently the commented out code, overrides our html code. Like deletes it all
     * **/
//    @GetMapping("blog-post/")
//    public String getBlogPost(@RequestParam Long id, Model model) throws IOException {
//        BlogPost returnedBlogPost = new BlogPost("<Reverse Engineering part 1/>",1l);
//        String html = "<h1>THIS IS FROM THE THING</h1>";
//        model.addAttribute("title",returnedBlogPost.getTitle());
//
//
////        StringBuilder contentBuilder = new StringBuilder();
////        BufferedReader in = new BufferedReader(new FileReader(pathName));
////
////        String str;
////        while ((str = in.readLine()) != null) {
////            contentBuilder.append(str);
////        }
////        in.close();
////        BufferedWriter in = new BufferedWriter(new FileWriter(pathName));
////        in.append("<h1>MORE THAT WE THOUGHT AND THEN SOME AND STUFF</h1>");
////        in.close();
//       // System.out.println(contentBuilder.toString());
//
//
//        return "blogPost";
//    }

    /**
     * THIS IS ESSENTIALLY THE POSTING CONTROLLER
     * **/
//    @GetMapping("testing")
//    public String testParser(Model model) throws IOException {
//        String pathName = "C:\\Users\\14035\\Desktop\\JavaStuff\\LateNightJava\\LateNightJava\\src\\main\\resources\\templates\\testing.html";
//        String globalPath = "C:\\Users\\14035\\Desktop\\JavaStuff\\LateNightJava\\LateNightJava\\src\\main\\resources\\templates\\global.html";
//        File input = new File(pathName);
//        File globalStyles = new File(globalPath);
//        model.addAttribute("title","Reverse Engineering part 69");
//        Document doc = Jsoup.parse(input,"UTF-8");
//        Document globalDoc = Jsoup.parse(globalStyles,"UTF-8");
//
////        Element masthead = doc.select("div.masthead").first();
////        Element body = globalDoc.select("div.blogPostContainer").first();
////        masthead.clearAttributes();
////        System.out.println(globalDoc);
////        System.out.println(masthead);
////        masthead.prepend("<div><h1>another</h1></div>");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(input));
//        bw.write(globalDoc.toString());
//        bw.close();
//        return "testing";
//    }

//    @GetMapping("/testing/get")
//    public String testingGet(Model model){
//        model.addAttribute("title","<HTTP Servlet Basics/>");
//        Scanner scanner = new Scanner("12345 323432 432432 ");
//        List<Token> tokenList = scanner.scanTokens();
//        for(Token token : tokenList){
//            System.out.println(token.getLexeme());
//        }
//        return "testing";
//    }
}
