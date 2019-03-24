package kr.somoon.somoonshop.webservice.security;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.exepction.UnAuthenticationException;
import kr.somoon.somoonshop.webservice.service.AccountServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.Base64;

@Slf4j
public class OriginAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private AccountServcie accountServcie;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        log.debug("Authorization : {}", authorization);
        if(authorization == null || !authorization.startsWith("Basic"))
            return true;

        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
        final String[] values = credentials.split(":", 2);
        log.debug("account name : {}", values[0]);
        log.debug("account password : {}", values[1]);

        try{
            Account account = accountServcie.login(values[0], values[1]);
            log.debug("Login Success : {}", account);
            request.getSession().setAttribute(HttpSessionUtils.ACCOUNT_SESSION_KEY, account);
            return true;
        }catch (UnAuthenticationException e){
            return true;
        }
    }
}
