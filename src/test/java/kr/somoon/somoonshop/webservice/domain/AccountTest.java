package kr.somoon.somoonshop.webservice.domain;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void update_match_password(){
        Account origin = new Account("test", "password", "test");
        Account target = new Account("test", "password", "test2");
        origin.update(target);
        Assert.assertThat(origin, CoreMatchers.is(target));
    }

    @Test
    public void update_mismatch_password(){
        Account origin = new Account("test", "password", "test");
        Account target = new Account("test", "password2", "test2");
        origin.update(target);
        Assert.assertFalse(origin.equals(target));
    }
}
