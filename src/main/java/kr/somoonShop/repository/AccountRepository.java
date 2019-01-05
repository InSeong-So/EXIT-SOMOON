package kr.somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

//	void setMemberInfoById(String id);
}
