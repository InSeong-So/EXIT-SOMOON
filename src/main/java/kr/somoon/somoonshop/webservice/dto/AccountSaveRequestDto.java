package kr.somoon.somoonshop.webservice.dto;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class AccountSaveRequestDto {

//    private String accountId;
//    private String accountPassword;
//    private String accountName;
//    private String accountBirthday;
//    private String accountContact;
//    private String accountAddress;
//    private String accountPostalCode;
//    private String accountEmail;
//    private String accountAgreement;
//    private String accountAddFit;
//    private Timestamp accountAddDate;
//    private Timestamp accountLastLogin;
//    private int accountCountLoginFailed;
//    private int accountPoint;


    private String id;
    private String password;
    private String birthday;
    private String contact;
    private String address;
    private String postalCode;
    private String email;
    private String agreement;
    private String fit;
    private int loginFailed;
    private int point;


    // 회원가입

    // 정보변경

    // 로그인 시도
    @Builder
    public AccountSaveRequestDto(String id, String password){
        this.id = id;
        this.password = password;
    }
}
