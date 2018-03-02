package com.gaponec.rest;

import com.gaponec.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/auth")
    public void auth(@RequestParam(value = "inputEmail") String login, @RequestParam(value = "inputPassword") String password){
        System.out.println(login+" "+password);
    }
}
