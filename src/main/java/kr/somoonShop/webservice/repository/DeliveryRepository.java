package kr.somoonShop.webservice.repository;

import kr.somoonShop.webservice.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
