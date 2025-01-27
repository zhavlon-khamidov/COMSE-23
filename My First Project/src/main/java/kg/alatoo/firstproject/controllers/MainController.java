package kg.alatoo.firstproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller

//@RestController
public class MainController {

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello world";
    }


    @GetMapping("t1")
    public String test(Model model) {
        String text = "My First project is great";
        model.addAttribute("dark", false);
        model.addAttribute("myText", text);
        return "test";
    }



}
