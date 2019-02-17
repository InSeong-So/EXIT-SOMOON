package kr.somoonShop.repository;

import kr.somoonShop.domain.PostService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostServiceRepository extends JpaRepository<PostService, Long> {

}
