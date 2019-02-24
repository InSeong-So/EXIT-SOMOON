package kr.somoon.somoonshop.webservice.security;

import kr.somoon.somoonshop.webservice.domain.account.Account;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
    public static final String ACCOUNT_SESSION_KEY = "loginedAccount";

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
