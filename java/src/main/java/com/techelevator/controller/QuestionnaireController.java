package com.techelevator.controller;

import com.techelevator.dao.QuestionnaireDao;
import com.techelevator.model.Questionnaire;
import com.techelevator.model.QuestionnaireDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class QuestionnaireController {
    private QuestionnaireDao questionnaireDao;

    public QuestionnaireController(QuestionnaireDao questionnaireDao) {
        this.questionnaireDao = questionnaireDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/adopter/questionnaire", method = RequestMethod.POST)
    public void submitQuestionnaire(@Valid @RequestBody QuestionnaireDto questionnaire) {
        try {
            questionnaireDao.save(questionnaire);
        } catch (ResponseStatusException e) {
            e.printStackTrace();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/adopt/list", method = RequestMethod.GET)
    public void listQuestionnaires() {
        try {
            questionnaireDao.list();
        } catch (ResponseStatusException e) {
            e.printStackTrace();
        }
    }
}
