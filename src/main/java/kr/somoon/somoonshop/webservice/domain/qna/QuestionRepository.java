package kr.somoon.somoonshop.webservice.domain.qna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface QuestionRepository extends JpaRepository<Question, Long> {

//    @Query("SELECT q " +
//            "FROM Question q " +
//            "ORDER BY q.no DESC")
//    Stream<Question> findAllDesc();
}
