package kr.somoon.somoonshop.webservice.repository;

import kr.somoon.somoonshop.webservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
