package kr.somoon.somoonshop.webservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class WebController {

    @GetMapping("/")
    public String home(HttpSession session){
        return "home";
    }

}
