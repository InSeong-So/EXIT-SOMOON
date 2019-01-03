package kr.somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
