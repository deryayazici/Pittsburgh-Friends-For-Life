package com.techelevator.dao;

import com.techelevator.model.Questionnaire;

import java.util.List;

public interface QuestionnaireDao {

    Questionnaire get(int id);

    Questionnaire getByAdopter(int adopterId);

    Questionnaire getByAnimal(int animalId);

    List<Questionnaire> list();

    boolean save(Questionnaire questionnaireToSave);


}
