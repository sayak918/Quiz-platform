package com.sayak.questionservice.Controller;


import com.sayak.questionservice.Entity.Question;
import com.sayak.questionservice.Entity.QuestionWrapper;
import com.sayak.questionservice.Entity.Response;
import com.sayak.questionservice.Service.QuestionService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    private QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }





    @GetMapping("/showAll")
    public List<Question>showAll(){
     return questionService.findAll();
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question q){

        q.setId(0);
      return   questionService.save(q);
    }
    //microservices
    //generate
    //getQuestions{question_id}
    //get score
    // to make it independent

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>>getQuestionForQuiz(@RequestParam String category,@RequestParam Integer noQ){
        return questionService.getQuestions(category,noQ);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>>getQuestionFromId(@RequestBody List<Integer>questionId){

        return questionService.getQuestionsFromId(questionId);
    }
    @PostMapping("/getScore")
    public ResponseEntity<Integer>getScore(@RequestBody List<Response>responses){
        return questionService.getScore(responses);
    }


}
