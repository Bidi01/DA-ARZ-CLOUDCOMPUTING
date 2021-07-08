package at.cloudcomputing.backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeController {



    @RequestMapping(value = "login")
    public String login(){return "login";}

    @RequestMapping(value = "register")
    public String register(){
        return "register";}




}
