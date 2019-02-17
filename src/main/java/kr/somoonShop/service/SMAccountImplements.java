package kr.somoonShop.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import kr.somoonShop.domain.Account;
import kr.somoonShop.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SMAccountImplements implements SMAccount {

	@Autowired
	private AccountRepository accountRepository;

	private Account account;
	private Timestamp nowTime = new Timestamp(System.currentTimeMillis());

	@Modifying
	@Query("update Account u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
	@Override
	public void resetPassword(String accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account getAccountInfo(Integer accountNo) {
		Account account = new Account();
//		accountRepository.findById(id);

		return null;
	}

	@Override
	public Optional<Account> getAccountInfo(String accountId) {
		return accountRepository.findById(accountId);
	}

	@Override
	public Account accessLogin(String accountId, String accountPassword) {
		Account account = new Account();
		if (accountRepository.findByAccountIdAndAccountPassword(accountId, accountPassword) != null) {
			return accountRepository.findByAccountIdAndAccountPassword(accountId, accountPassword).get(0);
		} else {
			return null;
		}
	}

	@Override
	public Timestamp setLastLoginTime(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incrementLoginFailCount(String accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer getLoginFailCount(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearLoginFailCount(String accountId) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Account> getAccountList(String accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAccount(Account accountInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAccount(String[] accountBasicAdd) {
		account = Account.builder().accountId(accountBasicAdd[0]).accountEmail(accountBasicAdd[1])
				.accountPassword(accountBasicAdd[2]).accountAddDate(nowTime).build();
		accountRepository.save(account);
		log.info("기본정보로 회원가입 완료");
	}

	@Override
	public void delAccount(ArrayList<Integer> accountNoList) {
		// TODO Auto-generated method stub

	}

}
