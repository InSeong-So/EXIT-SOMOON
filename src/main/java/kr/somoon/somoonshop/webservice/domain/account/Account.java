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

    @Column(unique = true, length = 20, nullable = false)
    private String accountId;

    @Column(nullable = false, length = 16)
    private String accountPassword;

    @Column(nullable = false, length = 10)
    private String accountName;

    @Builder
    public Account(String accountId, String accountPassword, String accountName){
        this.accountId = accountId;
        this.accountPassword = accountPassword;
        this.accountName = accountName;
    }

    public void update(Account target){

        if(!matchPassword(accountPassword))
            return;

        this.accountName = target.accountName;
    }

    public boolean matchPassword(String accountPassword){
        return this.accountPassword.equals(accountPassword);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (no ^ (no >>> 32));
        result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
        result = prime * result + ((accountPassword == null) ? 0 : accountPassword.hashCode());
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (no != other.no)
            return false;
        if (accountName == null) {
            if (other.accountName != null)
                return false;
        } else if (!accountName.equals(other.accountName))
            return false;
        if (accountPassword == null) {
            if (other.accountPassword != null)
                return false;
        } else if (!accountPassword.equals(other.accountPassword))
            return false;
        if (accountId == null) {
            if (other.accountId != null)
                return false;
        } else if (!accountId.equals(other.accountId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Account{" +
                "no=" + no +
                ", accountId='" + accountId + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}
