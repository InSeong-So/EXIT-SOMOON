package kr.somoon.somoonshop.webservice.domain.qna;

import kr.somoon.somoonshop.webservice.domain.ParentEntity;
import kr.somoon.somoonshop.webservice.domain.UrlGeneratable;
import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.exepction.UnAuthorizedException;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
//@Getter
//@Setter
@Data
@ToString
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends ParentEntity implements UrlGeneratable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long no;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String contents;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    private Account writer;

//    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
//    @OrderBy("no ASC")
//    private List<Answer> answers = new ArrayList<>();

    @Embedded
    private Answers answers = new Answers();

    public Question(){

    }

    public Question(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public Answer addAnswer(Answer answer){
        answer.toQuestion(this);
        answers.add(answer);
        return answer;
    }

    public void writeBy(Account loginAccount){
        this.writer = loginAccount;
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

    @Override
    public String generateUrl() {
        return String.format("/question/%d", getId());
    }
}
