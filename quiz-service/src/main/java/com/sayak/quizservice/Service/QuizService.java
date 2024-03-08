package com.sayak.quizservice.Service;


import com.sayak.quizservice.Dao.QuizDao;
import com.sayak.quizservice.Entity.QuestionWrapper;
import com.sayak.quizservice.Entity.Quiz;
import com.sayak.quizservice.Entity.Response;
import com.sayak.quizservice.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;
    @Autowired
    QuizInterface quizInterface;


    public ResponseEntity<String> creatQuiz(String category, int noQ) {
       List<Integer>questions=quizInterface.getQuestionForQuiz(category,noQ).getBody();
       Quiz quiz=new Quiz();
       quiz.setQuestionsIds(questions);
       quizdao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id) {
      Quiz quiz= quizdao.findById(id).get();
     List<Integer>questionsIds=quiz.getQuestionsIds();


        ResponseEntity<List<QuestionWrapper>>questions= quizInterface.getQuestionFromId(questionsIds);
      return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> respose) {
        ResponseEntity<Integer>score= quizInterface.getScore(respose);

        return score;
    }
}
