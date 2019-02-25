package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.exepction.UnAuthenticationException;
import kr.somoon.somoonshop.webservice.security.HttpSessionUtils;
import kr.somoon.somoonshop.webservice.service.AccountServcie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@AllArgsConstructor
public class LoginController {

    @Autowired
    private AccountServcie accountServcie;

    @GetMapping("/login")
    public String page(){
        return "/account/login";
    }

    @PostMapping("/login")
    public String login(String accountId, String accountPassword, HttpSession session){
        try {
            Account account = accountServcie.login(accountId, accountPassword);
            session.setAttribute(HttpSessionUtils.ACCOUNT_SESSION_KEY, account);
            return "redirect:/";
        } catch(UnAuthenticationException e){
            return "/account/login_failed";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(HttpSessionUtils.ACCOUNT_SESSION_KEY);
        return "redirect:/";
    }

}
