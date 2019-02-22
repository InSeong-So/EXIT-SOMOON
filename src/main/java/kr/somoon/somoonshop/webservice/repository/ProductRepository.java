package kr.somoonShop.webservice.repository;

import kr.somoonShop.webservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
