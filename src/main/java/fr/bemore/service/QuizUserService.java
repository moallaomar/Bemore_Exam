package fr.bemore.service;

import fr.bemore.entities.QuizUser;

import java.util.List;

public interface QuizUserService {

    public List<QuizUser> findAll() throws NullPointerException;

}
