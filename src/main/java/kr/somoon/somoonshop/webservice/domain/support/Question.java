package kr.somoon.somoonshop.webservice.domain.support;

import kr.somoon.somoonshop.webservice.domain.BaseTimeEntity;
import kr.somoon.somoonshop.webservice.domain.account.Account;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 250)
    private String contents;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    private Account writer;

}
