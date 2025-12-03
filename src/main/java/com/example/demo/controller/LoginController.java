package com.example.demo.controller;

import java.util.Locale;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class LoginController {

    private final LocaleResolver localeResolver;

    @Autowired
    public LoginController(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    @GetMapping("/")
    public String rootRedirect(HttpServletRequest request, HttpServletResponse response) {
        // default to Vietnamese login (path-based locale resolver will use "vi")
        return "redirect:/vi/login";
    }

    @GetMapping("/en/login")
    public String loginEn(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }

    @GetMapping("/vi/login")
    public String loginVi(HttpServletRequest request, HttpServletResponse response) {
        return "login";
    }
}

