package com.proj.quizApp.service;

import com.proj.quizApp.model.Question;
import com.proj.quizApp.model.QuestionWrapper;
import com.proj.quizApp.model.Quiz;
import com.proj.quizApp.model.Response;
import com.proj.quizApp.dao.QuestionRepository;
import com.proj.quizApp.dao.QuizRepository;
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
    QuestionRepository questionRepository;
    @Autowired
    QuizRepository quizRepository;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questionList=questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questionList);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser=new ArrayList<>();
        for(Question q:questionsFromDB){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getCategory(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> submitQuiz(int id, List<Response> responses) {
        int i=0,right=0;
        Optional<Quiz> quiz=quizRepository.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestions();
        for(Response response:responses){
            if(response.getResponse().equals(questionsFromDB.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
