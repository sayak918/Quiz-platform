package com.sayak.questionservice.Dao;


import com.sayak.questionservice.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question>findByCategory(String category);


    //@Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :noQ",nativeQuery = true)
    @Query(value = "SELECT q.id FROM question q Where q.category=:category ORDER BY RAND() LIMIT :noQ", nativeQuery = true)
    List<Integer> finAllByCategory(String category, int noQ);
}
