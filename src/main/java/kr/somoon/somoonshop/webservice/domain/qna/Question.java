package kr.somoon.somoonshop.webservice.domain.qna;

import kr.somoon.somoonshop.webservice.domain.BaseTimeEntity;
import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.exepction.UnAuthorizedException;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String contents;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    private Account writer;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    @OrderBy("no ASC")
    private List<Answer> answers = new ArrayList<>();

    public Question(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
        answer.setQuestion(this);
    }

    public boolean isOwner(Account loginAccount){
        return writer.equals(loginAccount);
    }

    public void update(Account loginAccount, Question upsdateQuestion){
        if(!isOwner(loginAccount)){
            throw new UnAuthorizedException();
        }

        this.title = title;
        this.contents = contents;
    }

}
