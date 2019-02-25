package kr.somoon.somoonshop.support;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.domain.account.AccountRepository;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

public class OriginAuthAcceptanceTest extends AcceptanceTest {
    protected TestRestTemplate template;

    @Autowired
    private AccountRepository accountRepository;

    protected Account loginAccount;

    @Before
    public void setup(){
        loginAccount = accountRepository.save(new Account("test", "1234", "tester"));
        template = template.withBasicAuth(loginAccount.getAccountId(), loginAccount.getAccountPassword());
    }

    @After
    public void tearDown(){
        accountRepository.delete(loginAccount);
    }
}
