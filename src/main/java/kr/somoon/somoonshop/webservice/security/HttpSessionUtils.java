package kr.somoon.somoonshop.webservice.security;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
    public static final String ACCOUNT_SESSION_KEY = "loginedAccount";

    public static boolean isLoginAccount(NativeWebRequest webRequest){
        Object logindAccount = webRequest.getAttribute(ACCOUNT_SESSION_KEY, webRequest.SCOPE_SESSION);
        return logindAccount != null;
    }

    public static Account getAccountFromSession(NativeWebRequest webRequest){
        if(!isLoginAccount(webRequest))
            return Account.GUEST_ACCOUNT;

        return (Account) webRequest.getAttribute(ACCOUNT_SESSION_KEY, webRequest.SCOPE_SESSION);
    }

    public static boolean isLoginAccount(HttpSession session){
        Object sessionedAccount = session.getAttribute(ACCOUNT_SESSION_KEY);

        if(sessionedAccount == null)
            return false;

        return true;
    }

    public static Account getAccountFromSession(HttpSession session){

        if(!isLoginAccount(session))
            return null;

        return (Account)session.getAttribute(ACCOUNT_SESSION_KEY);

    }
}
