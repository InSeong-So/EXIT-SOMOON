package kr.somoonShop.webservice.repository;

import kr.somoonShop.webservice.domain.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
