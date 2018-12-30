package somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import somoonShop.domain.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long>{

}
