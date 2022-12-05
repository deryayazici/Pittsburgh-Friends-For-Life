package com.techelevator.dao;

import com.techelevator.model.Questionnaire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcQuestionnaireDao implements QuestionnaireDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcQuestionnaireDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private Questionnaire MapRowToQuestionnaire(SqlRowSet results){
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setQuestionnaire_id(results.getInt("questionnaire_id"));
        questionnaire.setFirst_name(results.getString("first_name"));
        questionnaire.setLast_name(results.getString("last_name"));
        questionnaire.setNumber_children(results.getInt("number_children"));
        questionnaire.setHousing_type(results.getString("housing_type"));
        questionnaire.setFenced_yard(results.getBoolean("fenced_yard"));
        questionnaire.setWalker(results.getString("walker"));
        questionnaire.setYears_of_pet_experience(results.getInt("years_of_pet_experience"));
        questionnaire.setRenting_or_owning(results.getString("renting_or_owning"));
        questionnaire.setVet(results.getString("vet"));
        questionnaire.setDisabled(results.getBoolean("disabled"));
        questionnaire.setAnimal_id(results.getInt("animal_id"));
        questionnaire.setAdopter_id(results.getInt("adopter_id"));
        questionnaire.setReference_one(results.getString("reference_one"));
        questionnaire.setReference_one_contact(results.getString("reference_one_contact"));
        questionnaire.setReference_two(results.getString("reference_two_contact"));
        questionnaire.setReference_two_contact(results.getString("reference_two_contact"));

        return questionnaire;
    }


    @Override
    public Questionnaire get(int id) {
        String sql = "SELECT * from questionnaire where questionnaire_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return MapRowToQuestionnaire(results);
        } else {
            return null;
        }
    }

    @Override
    public Questionnaire getByAdopter(int adopterId) {
        String sql = "select * from questionnaire\n" +
                "join adopter on adopter.adopter_id = questionnaire.adopter_id\n" +
                "where adopter.adopter_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, adopterId);
        if (results.next()) {
            return MapRowToQuestionnaire(results);
        } else {
            return null;
        }
    }

    @Override
    public Questionnaire getByAnimal(int animalId) {
        String sql = "select * from questionnaire\n" +
                "join animal on animal.animal_id = questionnaire.animal_id\n" +
                "where animal.animal_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, animalId);
        if (results.next()) {
            return MapRowToQuestionnaire(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Questionnaire> list() {
        List<Questionnaire> allQuestionnaires = new ArrayList<>();
        String sql = "select * from questionnaire;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            allQuestionnaires.add(MapRowToQuestionnaire(results));
        } return allQuestionnaires;
    }

    @Override
    public boolean save(Questionnaire questionnaireToSave) {
        String sql = "INSERT INTO questionnaire (questionnaire_id,first_name,last_name,number_children,housing_type,fenced_yard,walker,years_of_pet_experience,renting_or_owning,vet,disabled,animal_id,adopter_id,reference_one,reference_one_contact,reference_two,reference_two_contact)\n" +
                "VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
                return jdbcTemplate.update(sql,
                questionnaireToSave.getFirst_name(),
                questionnaireToSave.getLast_name(),
                questionnaireToSave.getNumber_children(),
                questionnaireToSave.getHousing_type(),
                questionnaireToSave.isFenced_yard(),
                questionnaireToSave.getWalker(),
                questionnaireToSave.getYears_of_pet_experience(),
                questionnaireToSave.getRenting_or_owning(),
                questionnaireToSave.getVet(),
                questionnaireToSave.isDisabled(),
                questionnaireToSave.getAnimal_id(),
                questionnaireToSave.getAdopter_id(),
                questionnaireToSave.getReference_one(),
                questionnaireToSave.getReference_one_contact(),
                questionnaireToSave.getReference_two(),
                questionnaireToSave.getReference_two_contact()) == 1;
    }
}
