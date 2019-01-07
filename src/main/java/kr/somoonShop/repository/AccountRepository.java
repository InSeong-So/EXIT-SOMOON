package kr.somoonShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	public List<Account> findByAccountIdAndAccountPassword(String accountId, String accountPassword);
}
