package kr.somoon.somoonshop.webservice.repository;

import kr.somoon.somoonshop.webservice.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

}
