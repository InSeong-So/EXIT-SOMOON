package kr.somoonShop.webservice.domain.account;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "account")
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_no")
    private Long accountNo;

    @Id
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_password")
    private String accountPassword;

    @Column(name = "account_name", nullable = true)
    private String accountName;

    @Column(name = "account_birthday", nullable = true)
    private String accountBirthday;

    @Column(name = "account_contact", nullable = true)
    private String accountContact;

    @Column(name = "account_address", nullable = true)
    private String accountAddress;

    @Column(name = "account_postal_code", nullable = true)
    private String accountPostalCode;

    @Column(name = "account_email")
    private String accountEmail;

    @Column(name = "account_agreement")
    private String accountAgreement;

    @Column(name = "account_body_size", nullable = true)
    private String accountAddFit;

    @Column(name = "account_add_Date")
    private Timestamp accountAddDate;

    @Column(name = "account_last_login")
    private Timestamp accountLastLogin;

    @Column(name = "account_count_login_failed")
    private int accountCountLoginFailed;

    @Column(name = "account_point")
    private int accountPoint;

}
