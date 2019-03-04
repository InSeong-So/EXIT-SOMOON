package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.domain.qna.Question;
import kr.somoon.somoonshop.webservice.security.LoginAccount;
import kr.somoon.somoonshop.webservice.service.QnaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/questions/{questionAccount}/answers")
public class AnswerController {
    @Resource(name = "qnaService")
    private QnaService qnaService;

    @PostMapping("")
    public String create(@LoginAccount Account loginAccount, @PathVariable long questionAccount, String contents){
        Question question = qnaService.addAnswer(loginAccount, questionAccount, contents);
        return "redirect:" + question;
    }
}
