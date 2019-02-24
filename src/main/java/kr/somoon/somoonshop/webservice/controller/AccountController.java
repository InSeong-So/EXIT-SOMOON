package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.domain.account.AccountRepository;
import kr.somoon.somoonshop.webservice.service.AccountServcie;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountServcie accountServcie;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/resistration")
    public String resistration(){
        return "/account/resistration";
    }

    @GetMapping("/profile")
    public String profile(){
        return "/account/profile";
    }

    @PostMapping("")
    public String create(Account account){
        log.debug("Account Create : {}", account);
        accountRepository.save(account);
        return "redirect:/account";
    }

    @GetMapping("")
    public String accountList(Model model){
        log.debug("Account Size : {}", accountServcie.findAllDesc());
        model.addAttribute("account", accountServcie.findAllDesc());
        return "/account/accountList";
    }
}
