package com.example.LateNightJava.Controllers;

import com.example.LateNightJava.Models.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

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
        model.addAttribute("title","<h1>TESTING</h1>");

        return "home";
    }
    @GetMapping("blog-post/")
    public String getBlogPost(@RequestParam Long id, Model model){
        model.addAttribute("title",id);
        return "blogPost";
    }
}
