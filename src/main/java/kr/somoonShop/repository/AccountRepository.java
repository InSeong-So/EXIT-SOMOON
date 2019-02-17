package kr.somoonShop.repository;

import kr.somoonShop.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {

    public List<Account> findByAccountIdAndAccountPassword(String accountId, String accountPassword);
}
