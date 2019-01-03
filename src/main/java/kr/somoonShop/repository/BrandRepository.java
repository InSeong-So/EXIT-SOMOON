package kr.somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{

}
