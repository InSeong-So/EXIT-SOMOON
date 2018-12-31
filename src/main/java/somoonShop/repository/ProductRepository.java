package somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import somoonShop.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
