package kr.somoon.somoonshop.webservice.service;

import kr.somoonShop.webservice.domain.account.Account;
import kr.somoonShop.webservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Slf4j
public class SMAccountImplements implements kr.somoonShop.webservice.service.SMAccount {

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
    public void addAccount(String[] accountBasicAdd) {
        account = Account.builder()
                .accountId(accountBasicAdd[0])
                .accountEmail(accountBasicAdd[1])
                .accountPassword(accountBasicAdd[2])
                .accountAddDate(nowTime)
                .accountName(accountBasicAdd[0])
                .build();
        accountRepository.save(account);
        log.info("기본정보로 회원가입 완료");
    }

    @Override
    public void setAccount(String[] accountModify) {
        account = Account.builder()
                .accountName(accountModify[0])
                .accountContact(accountModify[1])
                .accountBirthday(accountModify[2])
                .accountAddress(accountModify[3])
                .accountPostalCode(accountModify[4])
                .accountPassword(accountModify[5])
                .build();
        accountRepository.save(account);
        log.info("계정정보 변경 완료");
    }

    @Override
    public void delAccount(ArrayList<Integer> accountNoList) {

    }
}
