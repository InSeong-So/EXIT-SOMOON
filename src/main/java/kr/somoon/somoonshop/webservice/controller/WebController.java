package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.service.AccountServcie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
public class WebController {

    private AccountServcie accountServcie;

    @GetMapping("/")
    public String accountList(Model model){
        model.addAttribute("account", accountServcie.findAllDesc());
        return "/account/accountList";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/resistration")
    public String resistration(){
        return "/account/resistration";
    }

    @PostMapping("/login")
    public String login(String accountId, String accountPassword, HttpSession session){
        try {
            Account account = accountServcie.login(accountId, accountPassword);
            session.setAttribute("connectAccount", account);
            return "redirect:/";
        }catch(IllegalStateException e){
            return "/account/login_failed";
        }

    }
}
