package com.techelevator.dao;

//import com.techelevator.model.Availability;
import com.techelevator.model.Volunteer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcVolunteerDao implements volunteerDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcVolunteerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Volunteer MapRowToVolunteer(SqlRowSet results){
        Volunteer volunteer = new Volunteer();
        volunteer.setAddress(results.getString("address"));
        volunteer.setPhoneNumber(results.getString("phone_number"));
        volunteer.setVolunteerId(results.getInt("volunteer_id"));

        return volunteer;
    }
    @Override
    public List<Volunteer> findAll() {
        List<Volunteer> volunteers = new ArrayList<>();
        String sql ="select * from volunteer";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            Volunteer volunteer = MapRowToVolunteer(result);
            volunteers.add(volunteer);
        }
        return volunteers;
    }

    @Override
    public Volunteer getVolunteerById(int volunteerID) {
        String sql = "select * from volunteer where volunteer_id=?";
       SqlRowSet results = jdbcTemplate.queryForRowSet(sql,volunteerID);
       if(results.next()){
           return MapRowToVolunteer(results);
       }else {
           return null;
       }
    }

    @Override
    public boolean save(Volunteer volunteer) {
       String sql = "Insert into Volunteer(volunteer_id,phone_number,address)"+
               "values(?,?,?,?)";
       return jdbcTemplate.update(sql,
               volunteer.getAddress(),
               volunteer.getPhoneNumber(),
               volunteer.getPhoneNumber())==1;
    }

    @Override
    public boolean update(Volunteer volunteer) {
        String sql = "update Volunteer "+
                "set Phone_number = ?, address = ?" +
                "where volunteer_id = ?;";
        return jdbcTemplate.update(sql,volunteer.getAddress(),volunteer.getPhoneNumber(),volunteer.getVolunteerId())==1;
    }

    @Override
    public boolean setVolunteerInactive(int volunteerId) {
        return false;
    }

    @Override
    public boolean setVolunteerActive(int volunteerId) {
        return false;
    }
}
