package com.portfolio.financial_ledger.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login/login";
    }

    @GetMapping( "/test")
    public String test() {
        return "index";
    }

//    @GetMapping("/test")
//    public String index() {
//        return "index";
//    }

}
