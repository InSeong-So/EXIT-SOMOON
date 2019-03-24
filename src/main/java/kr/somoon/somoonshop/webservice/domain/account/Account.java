package kr.somoon.somoonshop.webservice.domain.account;

import kr.somoon.somoonshop.webservice.domain.ParentEntity;
import kr.somoon.somoonshop.webservice.exepction.UnAuthorizedException;
import lombok.*;

import javax.persistence.*;

@Data
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
//@ToString
@Builder
public class Account extends ParentEntity {
    public static final GuestAccount GUEST_ACCOUNT = new GuestAccount();

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long no;

    @Column(unique = true, length = 20, nullable = false)
    private String accountId;

    @Column(nullable = false, length = 16)
    private String accountPassword;

    @Column(nullable = false, length = 10)
    private String accountName;

    @Column(length = 50)
    private String accountEmail;

    public Account(){

    }

    public Account(String accountId, String accountPassword, String accountName, String accountEmail){
        this(0L, accountId, accountPassword, accountName, accountEmail);
    }

    public Account(long no, String accountId, String accountPassword, String accountName, String accountEmail){
        super(no);
        this.accountId = accountId;
        this.accountPassword = accountPassword;
        this.accountName = accountName;
        this.accountEmail = accountEmail;
    }

    public void update(Account loginAccount, Account target){

        if(!matchId(loginAccount.getAccountId()))
            throw new UnAuthorizedException();

        if(!matchPassword(target.getAccountPassword()))
            return;

        this.accountName = target.accountName;
        this.accountEmail = this.accountEmail;
    }

    public boolean matchId(String accountId){
        return this.accountId.equals(accountId);
    }

    public boolean matchPassword(String accountPassword){
        return this.accountPassword.equals(accountPassword);
    }

    public boolean isGuestAccount(){
        return false;
    }

    private static class GuestAccount extends Account{
        @Override
        public boolean isGuestAccount() {
            return true;
        }
    }

//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + (int) (no ^ (no >>> 32));
//        result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
//        result = prime * result + ((accountPassword == null) ? 0 : accountPassword.hashCode());
//        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
//        return result;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null)
//            return false;
//        if (getClass() != obj.getClass())
//            return false;
//        Account other = (Account) obj;
//        if (no != other.no)
//            return false;
//        if (accountName == null) {
//            if (other.accountName != null)
//                return false;
//        } else if (!accountName.equals(other.accountName))
//            return false;
//        if (accountPassword == null) {
//            if (other.accountPassword != null)
//                return false;
//        } else if (!accountPassword.equals(other.accountPassword))
//            return false;
//        if (accountId == null) {
//            if (other.accountId != null)
//                return false;
//        } else if (!accountId.equals(other.accountId))
//            return false;
//        return true;
//    }

}
