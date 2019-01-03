package kr.somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

//	void setMemberInfoById(String id);
}
