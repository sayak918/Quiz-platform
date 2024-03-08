package com.sayak.questionservice.Service;

import com.sayak.questionservice.Entity.Question;
import com.sayak.questionservice.Entity.QuestionWrapper;
import com.sayak.questionservice.Entity.Response;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface QuestionService {





    List<Question> findAll();
    Question save(Question question);

    ResponseEntity<List<Integer>> getQuestions(String category, Integer noQ);

    ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionId);
    ResponseEntity<Integer> getScore(List<Response> responses);
}
