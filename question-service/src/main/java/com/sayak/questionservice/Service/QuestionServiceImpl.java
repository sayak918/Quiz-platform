package com.sayak.questionservice.Service;


import com.sayak.questionservice.Dao.QuestionDao;
import com.sayak.questionservice.Entity.Question;
import com.sayak.questionservice.Entity.QuestionWrapper;
import com.sayak.questionservice.Entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public ResponseEntity<Integer> getScore(List<Response> responses) {

        int c=0;
        int i=0;
        for(Response response:responses){
            Question question=questionDao.findById(response.getId()).get();
            if(response.getResponse().equals(question.getAnswer())){

                c++;
            }
            i++;
        }

        return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }


    @Override
    public Question save(Question question) {
        return questionDao.save(question);
    }

    @Override
    public ResponseEntity<List<Integer>> getQuestions(String category, Integer noQ) {
        List<Integer>questions=questionDao.finAllByCategory(category,noQ);


        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionId) {
      List<QuestionWrapper>wrappers=new ArrayList<>();
      List<Question>questions=new ArrayList<>();
      for(Integer id:questionId){
          questions.add(questionDao.findById(id).get());
      }
      for(Question question:questions){
          QuestionWrapper wrapper=new QuestionWrapper(question.getId(), question.getQuestion(), question.getOption1(), question.getOption2(), question.getOption3());
      wrappers.add(wrapper);
      }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }
}
