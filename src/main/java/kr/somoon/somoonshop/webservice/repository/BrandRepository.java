package kr.somoonShop.webservice.repository;

import kr.somoonShop.webservice.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
