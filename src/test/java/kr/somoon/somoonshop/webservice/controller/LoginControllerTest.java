package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.support.HtmlFormDataBuilder;
import kr.somoon.somoonshop.support.OriginAuthAcceptanceTest;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class LoginControllerTest extends OriginAuthAcceptanceTest {

    @Test
    public void login_success() throws Exception {
        ResponseEntity<String> response = login(loginAccount.getAccountId(), loginAccount.getAccountPassword());
        Assert.assertThat(response.getStatusCode(), CoreMatchers.is(HttpStatus.FOUND));
        Assert.assertTrue(response.getHeaders().getLocation().getPath().startsWith("/;jsessionid="));
    }

    @Test
    public void login_not_found_user() throws Exception {
        ResponseEntity<String> response = login(loginAccount.getAccountId() + "1", loginAccount.getAccountPassword());
        Assert.assertThat(response.getStatusCode(), CoreMatchers.is(HttpStatus.OK));
        Assert.assertThat(response.getBody().contains("아이디 또는 비밀번호가 틀립니다. 다시 로그인 해주세요."), CoreMatchers.is(true));
    }

    @Test
    public void login_mismatch_password() throws Exception {
        ResponseEntity<String> response = login(loginAccount.getAccountId(), loginAccount.getAccountPassword() + "1");
        Assert.assertThat(response.getStatusCode(), CoreMatchers.is(HttpStatus.OK));
        Assert.assertThat(response.getBody().contains("아이디 또는 비밀번호가 틀립니다. 다시 로그인 해주세요."), CoreMatchers.is(true));
    }

    private ResponseEntity<String> login(String userId, String password) {
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("userId", userId).addParameter("password", password).build();
        ResponseEntity<String> response = template.postForEntity("/login", request, String.class);
        return response;
    }
}
