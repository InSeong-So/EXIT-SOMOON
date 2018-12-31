package somoonShop.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import somoonShop.domain.Brand;
import somoonShop.repository.BrandRepository;

@Component
@Slf4j
public class SomoonShopingWorker implements ApplicationRunner {

	@Autowired
	private BrandRepository br;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
//        Brand brand = Brand.builder().accountNumber("!111").bankCode(112).brandAddress("1111").brandContact("1111").brandName("test").brandNumber("!11111").brandPostalCode("111111111111").depositor("aaaa").build();
//        br.save(brand);
		
	}
}
