package com.jaybe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String getLoginForm() {
        // return "plain-login";
        return "fancy-login";
    }

    @GetMapping("/access-denied")
    public String showUnauthorizedPage() {
        // return "plain-login";
        return "access-denied";
    }

}
