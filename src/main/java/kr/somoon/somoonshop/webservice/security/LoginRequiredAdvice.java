package kr.somoon.somoonshop.webservice.security;

import kr.somoon.somoonshop.webservice.exepction.UnAuthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
public class LoginRequiredAdvice {

    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public void unAuthorized(){
        log.debug("UnAuthorizedException is Happened");
    }
}
