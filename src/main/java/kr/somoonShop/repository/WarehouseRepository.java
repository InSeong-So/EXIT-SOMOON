package kr.somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
