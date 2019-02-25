package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.support.OriginAuthAcceptanceTest;
import kr.somoon.somoonshop.webservice.domain.account.AccountRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AccountControllerTest extends OriginAuthAcceptanceTest {
    private static final Logger log = LoggerFactory.getLogger(AccountControllerTest.class);

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void createResistration() throws Exception{
        ResponseEntity<String> response = template.getForEntity("/account/resistration", String.class);
        Assert.assertThat(response.getStatusCode(), CoreMatchers.is(HttpStatus.OK));
        log.debug("body : {}", response.getBody());
    }
}
