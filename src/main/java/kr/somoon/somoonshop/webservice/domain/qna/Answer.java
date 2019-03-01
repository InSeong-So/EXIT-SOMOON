package kr.somoon.somoonshop.webservice.domain.qna;

import kr.somoon.somoonshop.webservice.domain.BaseTimeEntity;
import kr.somoon.somoonshop.webservice.domain.account.Account;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
    private Account writer;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_to_writer"))
    private Question question;

    @Lob
    private String contents;

    public Answer(Account writer, String contents) {
        this.writer = writer;
        this.contents = contents;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((no == null) ? 0:no.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Answer other = (Answer)obj;
        if(no == null){
            if(other.no != null)
                return false;
        } else if(!no.equals(other.no))
            return false;
        return true;
    }
}
