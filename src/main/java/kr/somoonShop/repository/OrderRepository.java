package kr.somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
