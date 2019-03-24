package kr.somoon.somoonshop.webservice.service;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.domain.qna.Answer;
import kr.somoon.somoonshop.webservice.domain.qna.AnswerRepository;
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

    @Resource(name = "answerRepository")
    private AnswerRepository answerRepository;

    public void create(Account loginAccount, Question question){
        question.writeBy(loginAccount);
        log.debug("Question : {}", question);
        questionRepository.save(question);
    }

    public Question findById(long id){
        return questionRepository.findOne(id);
    }

    public Question update(Account loginAccount, long id, Question updateQuestion){
        Question question = questionRepository.findOne(id);
        question.update(loginAccount, updateQuestion);
        return questionRepository.save(question);
    }

    public List<Question> findAll(){
        return questionRepository.findAll();
    }

    public Question addAnwer(Account loginAccount, long questionId, String contents){
        Question question = questionRepository.findOne(questionId);
        Answer answer = new Answer(loginAccount, contents);
        question.addAnswer(answer);
        return questionRepository.save(question);
    }

    public Answer deleteAnswer(Account loginAccount, long id){
        Answer answer = answerRepository.findOne(id);
        answer.deleteBy(loginAccount);
        answerRepository.delete(answer);
        return answer;
    }

}
