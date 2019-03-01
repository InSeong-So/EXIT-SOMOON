package kr.somoon.somoonshop.webservice.security;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.service.AccountServcie;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Base64;

@RunWith(MockitoJUnitRunner.class)
public class OriginAuthInterceptorTest {

    @Mock
    private AccountServcie accountServcie;

    @InjectMocks
    private OriginAuthInterceptor originAuthInterceptor;

    @Test
    public void preHandle_loginSuccess() throws  Exception{
        String accountId = "accountId";
        String accountPassword = "accountPassword";
        MockHttpServletRequest request = originAuthHttpRequest(accountId, accountPassword);
        Account loginAccount = new Account(accountId, "password", "name");
        Mockito.when(accountServcie.login(accountId, accountPassword)).thenReturn(loginAccount);

        originAuthInterceptor.preHandle(request, null, null);
        Assert.assertThat(request.getSession().getAttribute(HttpSessionUtils.ACCOUNT_SESSION_KEY), CoreMatchers.is(loginAccount));
    }

    private MockHttpServletRequest originAuthHttpRequest(String accountId, String accountPassword){
        String encodedOriginAuth = Base64.getEncoder()
                .encodeToString(String.format("%s:%s", accountId, accountPassword).getBytes());
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addHeader("Authorization", "Origin " + encodedOriginAuth);

        return request;
    }
}
