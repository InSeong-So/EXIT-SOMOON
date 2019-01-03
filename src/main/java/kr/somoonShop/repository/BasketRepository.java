package kr.somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long>{

}
