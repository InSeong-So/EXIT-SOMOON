package kr.somoon.somoonshop.webservice.dto.Account;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class AccountMainResponseDto {
    private Long no;
    private String id;
    private String password;
    private String name;
    private String createdDate;
    private String modifiedDate;

    public AccountMainResponseDto(Account entry){
        this.no = entry.getNo();
        this.id = entry.getAccountId();
        this.password = entry.getAccountPassword();
        this.name = entry.getAccountName();
        this.createdDate = toStringDateTime(entry.getCreatedDate());
        this.modifiedDate = toStringDateTime(entry.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
