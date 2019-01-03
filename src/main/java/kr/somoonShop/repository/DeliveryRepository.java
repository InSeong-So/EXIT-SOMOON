package kr.somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
