package kr.somoonShop.webservice.repository;

import kr.somoonShop.webservice.domain.PostService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostServiceRepository extends JpaRepository<PostService, Long> {

}
