package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.support.OriginAuthAcceptanceTest;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WebControllerTest extends OriginAuthAcceptanceTest {

    @Test
    public void home_logout(){
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        Assert.assertThat(response.getStatusCode(), CoreMatchers.is(HttpStatus.OK));
        String body = response.getBody();
        Assert.assertTrue(body.contains("회원가입") && body.contains("로그인"));
        Assert.assertFalse(body.contains("개인정보수정") && body.contains("로그아웃"));
    }

    @Test
    public void home_login(){
        ResponseEntity<String> response = template.getForEntity("/", String.class);
        Assert.assertThat(response.getStatusCode(), CoreMatchers.is(HttpStatus.OK));
        String body = response.getBody();
        Assert.assertTrue(body.contains("회원가입") && body.contains("로그인"));
        Assert.assertFalse(body.contains("개인정보수정") && body.contains("로그아웃"));
    }
}
