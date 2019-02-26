package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.domain.support.Question;
import kr.somoon.somoonshop.webservice.domain.support.QuestionRepository;
import kr.somoon.somoonshop.webservice.security.LoginAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/support")
public class SupportController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/question")
    public String question(@LoginAccount Account loginAccount){
        return "/support/question";
    }

    @PostMapping("")
    public String create(@LoginAccount Account loginAccount, Question question){
        question.setWriter(loginAccount);
        log.debug("Question : {}", question);
        questionRepository.save(question);
        return "redirect:/";
    }
}
