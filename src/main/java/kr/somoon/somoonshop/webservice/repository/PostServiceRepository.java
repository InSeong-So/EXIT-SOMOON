package kr.somoon.somoonshop.webservice.repository;

import kr.somoon.somoonshop.webservice.domain.PostService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostServiceRepository extends JpaRepository<PostService, Long> {

}
