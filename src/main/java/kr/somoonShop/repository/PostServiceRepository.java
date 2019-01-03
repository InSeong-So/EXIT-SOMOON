package kr.somoonShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.somoonShop.domain.PostService;

public interface PostServiceRepository extends JpaRepository<PostService, Long>{

}
