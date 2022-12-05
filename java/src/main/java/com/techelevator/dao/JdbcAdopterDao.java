package com.techelevator.dao;

import com.techelevator.model.Adopter;
import com.techelevator.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcAdopterDao implements AdopterDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcAdopterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Adopter> findAll() {
        List<Adopter> adopters = new ArrayList<>();
        String sql = "select * from adopter";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Adopter adopter = mapRowToAdopter(results);
            adopters.add(adopter);
        }

        return adopters;
    }

    @Override
    public Adopter getAdopterById(int adopterId) {
        String sql = "SELECT * FROM adopter WHERE adopter_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, adopterId);
        if (results.next()) {
            return mapRowToAdopter(results);
        } else {
            return null;
        }
    }

    @Override
    public String adoptionStatus(int adopterId) {
        String adoptionStatus = "";

            String sql = "Select approved_to_adopt From adopter Where adopter_id =?; ";

            adoptionStatus = jdbcTemplate.queryForObject(sql, String.class, adopterId);
        return adoptionStatus;
    }

    @Override
    public void updateStatus(Adopter adopter) {
        String sql = "" +
                "UPDATE adopter " +
                "SET approved_to_adopt = ?," +
                "    animal_id = ?,"+
                "WHERE adopter_id = ?;";

        jdbcTemplate.update(sql, adopter.getApprovedToAdopt(),
                adopter.getAnimalId(),
                adopter.getAdopterId());
    }

    @Override
    public Adopter addAdopter(Adopter newAdopter) {
        String sql = "" +
                "INSERT INTO adopter (approved_to_adopt,animal_id) " +
                "VALUES (?, ?) " +
                "RETURNING adopter_id;";

        Integer adopterId = jdbcTemplate.queryForObject(sql, Integer.class,
                newAdopter.getAnimalId(),
                newAdopter.getApprovedToAdopt());



        Adopter theAdopter = getAdopterById(adopterId);

        return theAdopter;
    }

    private Adopter mapRowToAdopter(SqlRowSet rs) {
        Adopter adopter = new Adopter();
        adopter.setAdopterId(rs.getInt("adopter_id"));
        adopter.setAnimalId(rs.getInt("animal_id"));
        adopter.setApprovedToAdopt(rs.getString("approved_to_adopt"));

        return adopter;
    }
}
