package kr.somoonShop.webservice.repository;

import kr.somoonShop.webservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
