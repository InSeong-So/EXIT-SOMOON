package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.domain.qna.Question;
import kr.somoon.somoonshop.webservice.domain.qna.QuestionRepository;
import kr.somoon.somoonshop.webservice.security.LoginAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/qna")
public class QnaController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/list")
    public String questionList(){
        return "/qna/list";
    }

    @GetMapping("/question")
    public String question(@LoginAccount Account loginAccount){
        return "/qna/question";
    }

    @PostMapping("")
    public String create(@LoginAccount Account loginAccount, Question question){
        question.setWriter(loginAccount);
        log.debug("Question : {}", question);
        questionRepository.save(question);
        return "redirect:/";
    }
}
