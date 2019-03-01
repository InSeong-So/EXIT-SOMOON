package kr.somoon.somoonshop.webservice.domain;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.exepction.UnAuthorizedException;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    private Account newAccount(String accountId){
        return newAccount(accountId, "password");
    }

    private Account newAccount(String accountId, String accountPassword){
        return new Account(accountId, accountPassword, "test");
    }

    @Test
    public void update_owner() throws Exception{
        Account origin = newAccount("test");
        Account loginAccount = origin;
        Account target = new Account("test", "password", "name2");
        origin.update(loginAccount, target);
        Assert.assertThat(origin, CoreMatchers.is(target));
    }

    @Test(expected = UnAuthorizedException.class)
    public void update_not_owner() throws Exception{
        Account origin = newAccount("test");
        Account loginAccount = newAccount("test2");
        Account target = new Account("test", "password", "name2");
        origin.update(loginAccount, target);
    }

    @Test
    public void update_match_password(){
        Account origin = newAccount("test");
        Account target = new Account("test", "password", "test2");
        origin.update(origin, target);
        Assert.assertThat(origin, CoreMatchers.is(target));
    }

    @Test
    public void update_mismatch_password(){
        Account origin = newAccount("test", "password");
        Account target = newAccount("test", "password2");
        origin.update(origin, target);
        Assert.assertFalse(origin.equals(target));
    }
}
