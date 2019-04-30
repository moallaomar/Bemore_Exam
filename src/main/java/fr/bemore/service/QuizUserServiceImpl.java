package fr.bemore.service;


import fr.bemore.dao.QuizUserRepository;
import fr.bemore.entities.QuizUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizUserServiceImpl implements  QuizUserService {

    @Autowired
    private QuizUserRepository quizUserRepository;

    @Override
    public List<QuizUser> findAll() throws NullPointerException{
        try {
            List<QuizUser> quizUser = quizUserRepository.findAll();
            return quizUser;
        }catch (NullPointerException e){
                e.printStackTrace();
        }
        List<QuizUser> quizUser = new ArrayList<>(0);
        return quizUser;

    }
}
