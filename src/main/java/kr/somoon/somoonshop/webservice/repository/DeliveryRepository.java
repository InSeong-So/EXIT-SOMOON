package kr.somoon.somoonshop.webservice.repository;

import kr.somoon.somoonshop.webservice.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
