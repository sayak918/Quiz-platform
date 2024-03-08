package com.sayak.quizservice.Controller;



import com.sayak.quizservice.Entity.QuestionWrapper;
import com.sayak.quizservice.Entity.QuizDto;
import com.sayak.quizservice.Entity.Response;
import com.sayak.quizservice.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String>createQuiz(@RequestBody QuizDto quizDto){
        return quizService.creatQuiz(quizDto.getCategory(),quizDto.getNoQ());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>>getQuizQuestions(@PathVariable Integer id){

        return quizService.getQuestions(id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer>submitQuery(@PathVariable Integer id,@RequestBody List<Response> respose){
       return quizService.calculateResult(id,respose);
    }

}
