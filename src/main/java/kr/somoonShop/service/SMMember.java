package kr.somoonShop.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import kr.somoonShop.domain.Account;

public interface SMMember {

	/**
	 * 패스워드 리셋
	 */
	public void resetPassword(Integer memberNo);

	/**
	 * 패스워드 변경
	 */
	public void changePassword(Integer memberNo);

	/**
	 * no 인덱스로 계정정보 호출
	 */
	public Account getMemberInfo(Integer memberNo);
	
	/**
	 * 아이디로 계정정보 호출
	 */
	public Account getMemberInfo(String id);
	
	/**
	 * 마지막 로그인 시각 기록
	 */
	public Timestamp setLastLoginTime(Integer memberNo);
	
	/**
	 * 로그인 실패 시 횟수 기록
	 */
	public void incrementLoginFailCount(Integer memberNo);
	
	/**
	 * 로그인 실패 횟수 가져오기
	 */
	public Integer getLoginFailCount(Integer memberNo);
	
	/**
	 * 로그인 실패 횟수 초기화
	 */
	public void clearLoginFailCount(Integer memberNo);
	
	/**
	 * 인덱스로 현재 계정 리스트 호출
	 */
	public ArrayList<Account> getMemberList(Integer memberNo);
	
	/**
	 * 계정 정보 변경
	 */
	public void setMember(Account memberInfo);
	
	/**
	 * 새로운 계정 추가
	 */
	public void addMember(Account memberInfo);
	
	/**
	 * 중복된 계정 삭제
	 */
	public void delMember(ArrayList<Integer> memberNoList);
	
}
