package kr.somoonShop.webservice.repository;

import kr.somoonShop.webservice.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

}
