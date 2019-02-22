package kr.somoon.somoonshop.webservice.service;

import kr.somoon.somoonshop.webservice.domain.account.Account;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

public interface SMAccount {

    /**
     * 패스워드 리셋
     */
    public void resetPassword(String accountId);

    /**
     * 패스워드 변경
     */
    public void changePassword(String accountId);

    /**
     * no 인덱스로 계정정보 호출
     */
    public Account getAccountInfo(Integer accountNo);

    /**
     * 아이디로 계정정보 호출
     */
    public Optional<Account> getAccountInfo(String accountId);

    /**
     * 로그인 : 아이디 / 비밀번호
     */
    public Account accessLogin(String accountId, String accountPassword);

    /**
     * 마지막 로그인 시각 기록
     */
    public Timestamp setLastLoginTime(String accountId);

    /**
     * 로그인 실패 시 횟수 기록
     */
    public void incrementLoginFailCount(String accountId);

    /**
     * 로그인 실패 횟수 가져오기
     */
    public Integer getLoginFailCount(String accountId);

    /**
     * 로그인 실패 횟수 초기화
     */
    public void clearLoginFailCount(String accountId);

    /**
     * 인덱스로 현재 계정정보 리스트 호출
     */
    public ArrayList<Account> getAccountList(String accountId);

    /**
     * 계정 정보 변경
     */
    public void setAccount(String[] accountModify);

    /**
     * 새로운 계정 추가
     */
    public void addAccount(String[] accountBasicAdd);

    /**
     * 중복된 계정 삭제
     */
    public void delAccount(ArrayList<Integer> accountNoList);

}
