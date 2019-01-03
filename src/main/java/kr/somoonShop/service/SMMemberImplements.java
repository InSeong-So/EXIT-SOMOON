package kr.somoonShop.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kr.somoonShop.domain.Account;
import kr.somoonShop.repository.AccountRepository;

public class SMMemberImplements implements SMMember {

//	@Autowired
//	private AccountRepository accountRepository;
	
	@Override
	@Modifying
	@Query("update Member u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
	public void resetPassword(Integer memberNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(Integer memberNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getMemberInfo(Integer memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getMemberInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timestamp setLastLoginTime(Integer memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incrementLoginFailCount(Integer memberNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getLoginFailCount(Integer memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearLoginFailCount(Integer memberNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Account> getMemberList(Integer memberNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMember(Account memberInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addMember(Account memberInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delMember(ArrayList<Integer> memberNoList) {
		// TODO Auto-generated method stub
		
	}

	
}
