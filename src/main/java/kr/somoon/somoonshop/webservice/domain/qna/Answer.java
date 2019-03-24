package kr.somoon.somoonshop.webservice.domain.qna;

import kr.somoon.somoonshop.webservice.domain.ParentEntity;
import kr.somoon.somoonshop.webservice.domain.UrlGeneratable;
import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.exepction.UnAuthorizedException;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends ParentEntity implements UrlGeneratable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long no;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
    private Account writer;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_question"))
    private Question question;

    @Lob
    private String contents;

    public Answer(Account writer, String contents) {
        this.writer = writer;
        this.contents = contents;
    }

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((no == null) ? 0:no.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj)
//            return true;
//        if(obj == null)
//            return false;
//        if(getClass() != obj.getClass())
//            return false;
//        Answer other = (Answer)obj;
//        if(no == null){
//            if(other.no != null)
//                return false;
//        } else if(!no.equals(other.no))
//            return false;
//        return true;
//    }

    public void toQuestion(Question question){
        this.question = question;
    }

    public boolean isOwner(Account loginAccount){
        return writer.equals(loginAccount);
    }

    @Override
    public String generateUrl() {
        return String.format("%s/answers/%d", question.generateUrl(), getId());
    }

    public void deleteBy(Account loginAccount){
        if(!isOwner(loginAccount)) throw new UnAuthorizedException();
    }

}
