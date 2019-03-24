package kr.somoon.somoonshop.webservice.service;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.domain.qna.Answer;
import kr.somoon.somoonshop.webservice.domain.qna.Question;
import kr.somoon.somoonshop.webservice.domain.qna.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("qnaService")
@Slf4j
public class QnaService {

    @Resource(name = "questionRepository")
    private QuestionRepository questionRepository;

    public void create(Account loginAccount, Question question){
        question.setWriter(loginAccount);
        log.debug("Question : {}", question);
        questionRepository.save(question);
    }

    public Question findByNo(long no){
        return questionRepository.findOne(no);
    }

    public Question update(Account loginAccount, long no, Question updateQuestion){
        Question question = questionRepository.findOne(no);
        question.update(loginAccount, updateQuestion);
        return questionRepository.save(question);
    }

    public List<Question> findAll(){
        return questionRepository.findAll();
    }

    public Question addAnwer(Account loginAccount, long questionNo, String contents){
        Question question = questionRepository.findOne(questionNo);
        Answer answer = new Answer(loginAccount, contents);
        question.addAnswer(answer);
        return questionRepository.save(question);
    }
}
