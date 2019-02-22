package kr.somoon.somoonshop.webservice.dto;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountSaveRequestDto {

    private String id;
    private String name;
    private String password;

    @Builder
    public AccountSaveRequestDto(String id, String password, String name){
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public Account toEntity(){
        return Account.builder()
                .accountId(id)
                .accountName(name)
                .accountPassword(password)
                .build();
    }
}
