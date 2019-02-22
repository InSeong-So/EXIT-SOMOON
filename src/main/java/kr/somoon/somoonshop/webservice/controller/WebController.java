package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.webservice.service.AccountServcie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private AccountServcie accountServcie;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("account", accountServcie.findAllDesc());
        return "accountList";
    }
}
