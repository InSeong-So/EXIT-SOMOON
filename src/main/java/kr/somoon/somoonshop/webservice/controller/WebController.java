package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.service.AccountServcie;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class WebController {

    @Autowired
    private AccountServcie accountServcie;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/resistration")
    public String resistration(){
        return "/account/resistration";
    }

}
