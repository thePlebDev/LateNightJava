package com.example.LateNightJava.Controllers;

import com.example.LateNightJava.Models.BlogPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/calf")
public class CalfController {

    @GetMapping("/book")
    public String getAllCalves(Model model){
        model.addAttribute("posts", Arrays.asList(
                new BlogPost("Creating a Java HTML parser. Part 1. Where to start?",1l),
                new BlogPost("Creating a Java HTML parser. Part 2. Parsing?",2l),
                new BlogPost("Creating a Java HTML parser. Part 2. Parsing?",3l)
        ));
        return "calvingBook";
    }
}
