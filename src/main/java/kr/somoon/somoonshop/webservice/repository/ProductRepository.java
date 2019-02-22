package kr.somoon.somoonshop.webservice.repository;

import kr.somoon.somoonshop.webservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
