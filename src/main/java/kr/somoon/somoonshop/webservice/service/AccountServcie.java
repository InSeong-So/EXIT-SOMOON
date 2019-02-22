package kr.somoon.somoonshop.webservice.service;

import kr.somoon.somoonshop.webservice.domain.account.AccountRepository;
import kr.somoon.somoonshop.webservice.dto.AccountMainResponseDto;
import kr.somoon.somoonshop.webservice.dto.AccountSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountServcie {

    private AccountRepository accountRepository;

    @Transactional
    public Long save(AccountSaveRequestDto dto){
        return accountRepository.save(dto.toEntity()).getNo();
    }

    @Transactional
    public List<AccountMainResponseDto> findAllDesc(){
        return accountRepository.findAllDesc()
                .map(AccountMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
