package kr.somoon.somoonshop.webservice.controller;

import kr.somoon.somoonshop.webservice.dto.AccountSaveRequestDto;
import kr.somoon.somoonshop.webservice.service.AccountServcie;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class WebRestController {

    private AccountServcie accountServcie;
    private Environment env;

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }

    @PostMapping("/restAccount")
    public Long saveAccount(@RequestBody AccountSaveRequestDto dto){
        return accountServcie.save(dto);
    }

    @GetMapping("/profile")
    public String getProfile(){
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
}
