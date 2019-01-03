package kr.somoonShop.worker;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.somoonShop.domain.Account;
import kr.somoonShop.repository.AccountRepository;

@Component
public class runner implements ApplicationRunner {

	@Autowired
	private AccountRepository ar;

	Timestamp time = new Timestamp(System.currentTimeMillis());
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Account ac = Account.builder().accountId("test2").accountPassword("1234").accountName("테스터")
				.accountBirthday("99999").accountContact("연락처").accountAddress("주소").accountPostalCode("두산")
				.accountAgreement("y").accountAddDate(time).accountLastLogin(time).accountEmail("goflvhxj").accountCountLoginFailed(0).accountPoint(0).build();
		ar.save(ac);
	}
}
