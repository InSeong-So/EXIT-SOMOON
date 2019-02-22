package kr.somoon.somoonshop.webservice.repository;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    public List<Account> findByAccountIdAndAccountPassword(String accountId, String accountPassword);
}
