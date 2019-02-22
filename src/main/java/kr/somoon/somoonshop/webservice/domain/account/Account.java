package kr.somoon.somoonshop.webservice.domain.account;

import kr.somoon.somoonshop.webservice.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String accountId;

    @Column(nullable = false)
    private String accountPassword;

    @Column(nullable = false)
    private String accountName;

    @Builder
    public Account(String accountId, String accountPassword, String accountName){
        this.accountId = accountId;
        this.accountPassword = accountPassword;
        this.accountName = accountName;
    }

}
