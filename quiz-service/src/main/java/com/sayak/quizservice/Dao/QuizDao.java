package com.sayak.quizservice.Dao;

import com.sayak.quizservice.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {


}
