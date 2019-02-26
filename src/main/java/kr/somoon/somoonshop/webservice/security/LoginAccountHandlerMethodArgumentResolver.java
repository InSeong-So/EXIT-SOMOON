package kr.somoon.somoonshop.webservice.security;

import kr.somoon.somoonshop.webservice.domain.account.Account;
import kr.somoon.somoonshop.webservice.exepction.UnAuthorizedException;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginAccountHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginAccount.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Account account = HttpSessionUtils.getAccountFromSession(webRequest);
        if(!account.isGuestAccount())
            return account;

        LoginAccount loginAccount = parameter.getParameterAnnotation(LoginAccount.class);

        if(loginAccount.required())
            throw new UnAuthorizedException("로그인이 필요합니다.");

        return account;
    }
}
