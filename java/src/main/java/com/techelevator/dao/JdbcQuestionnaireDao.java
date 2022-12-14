package com.techelevator.dao;

import com.techelevator.model.Questionnaire;
import com.techelevator.model.QuestionnaireDto;
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


    private Questionnaire mapRowToQuestionnaire(SqlRowSet results) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setQuestionnaire_id(results.getInt("questionnaire_id"));
        questionnaire.setFirst_name(results.getString("first_name"));
        questionnaire.setLast_name(results.getString("last_name"));
        questionnaire.setPhone_number(results.getString("phone_number"));
        questionnaire.setNumber_children(results.getInt("number_children"));
        questionnaire.setHousing_type(results.getString("housing_type"));
        questionnaire.setIsFenced_yard(results.getBoolean("fenced_yard"));
        questionnaire.setWalker(results.getString("walker"));
        questionnaire.setYears_of_pet_experience(results.getInt("years_of_pet_experience"));
        questionnaire.setRenting_or_owning(results.getString("renting_or_owning"));
        questionnaire.setVet(results.getString("vet"));
        questionnaire.setIsDisabled(results.getBoolean("disabled"));
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
            return mapRowToQuestionnaire(results);
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
            return mapRowToQuestionnaire(results);
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
            return mapRowToQuestionnaire(results);
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
            allQuestionnaires.add(mapRowToQuestionnaire(results));
        }
        return allQuestionnaires;
    }

    @Override
    public boolean save(QuestionnaireDto questionnaireDto) {
        String sql = "Insert into adopter (adopter_id,approved_to_adopt,animal_id)" +
                "Values (?,'Pending',?); "+
                "INSERT INTO questionnaire (questionnaire_id,first_name,last_name,phone_number,number_children,housing_type,fenced_yard,walker,years_of_pet_experience,renting_or_owning,vet,disabled,animal_id,adopter_id,reference_one,reference_one_contact,reference_two,reference_two_contact)\n" +
                "VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        return jdbcTemplate.update(sql,questionnaireDto.getAdopter_id(),questionnaireDto.getAnimal_id(),
                questionnaireDto.getFirst_name(),
                questionnaireDto.getLast_name(),
                questionnaireDto.getPhone_number(),
                questionnaireDto.getNumber_children(),
                questionnaireDto.getHousing_type(),
                questionnaireDto.isFenced_yard(),
                questionnaireDto.getWalker(),
                questionnaireDto.getYears_of_pet_experience(),
                questionnaireDto.getRenting_or_owning(),
                questionnaireDto.getVet(),
                questionnaireDto.isDisabled(),
                questionnaireDto.getAnimal_id(),
                questionnaireDto.getAdopter_id(),
                questionnaireDto.getReference_one(),
                questionnaireDto.getReference_one_contact(),
                questionnaireDto.getReference_two(),
                questionnaireDto.getReference_two_contact()) == 1;
    }
}
