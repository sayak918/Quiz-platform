package com.sayak.quizservice.feign;

import com.sayak.quizservice.Entity.QuestionWrapper;
import com.sayak.quizservice.Entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE") /// eureka site
public interface QuizInterface {
    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer noQ);


    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>>getQuestionFromId(@RequestBody List<Integer>questionId);
    @PostMapping("/getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response>responses);
}
