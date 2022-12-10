package com.techelevator.dao;

//import com.techelevator.model.Availability;
import com.techelevator.model.Volunteer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVolunteerDao implements VolunteerDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcVolunteerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Volunteer MapRowToVolunteer(SqlRowSet results){
        Volunteer volunteer = new Volunteer();
        volunteer.setFirstName(results.getString("first_name"));
        volunteer.setLastName(results.getString("last_name"));
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
    public List<Volunteer> getPending() {
        List<Volunteer> volunteers = new ArrayList<>();
        String sql = "select * from volunteer Where status = 'Pending'";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

     while (results.next()) {
      volunteers.add(MapRowToVolunteer(results));
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
       String sql = "Insert into volunteer(volunteer_id,first_name, last_name,phone_number,address, is_Active, status)"+
               "values(?,?,?,?,?,?,?)" +
               "Returning volunteer_id;";

       Integer volunteerId = jdbcTemplate.queryForObject(sql, Integer.class,
               volunteer.getVolunteerId(),
               volunteer.getFirstName(),
               volunteer.getLastName(),
               volunteer.getPhoneNumber(),
               volunteer.getAddress(),
               volunteer.isActive(),"Pending");

       return volunteerId > 0;
    }

    @Override
    public boolean update(Volunteer volunteer) {
        String sql = "update Volunteer "+
                "set first_name=?, last_name=?, Phone_number = ?, address = ?" +
                "where volunteer_id = ?;";
        return jdbcTemplate.update(sql,volunteer.getFirstName(), volunteer.getLastName(), volunteer.getPhoneNumber(),volunteer.getAddress(),volunteer.getVolunteerId())==1;
    }

    @Override
    public boolean setVolunteerInactive(int volunteerId) {
        String sql = "update volunteer set is_active = ? where volunteer_id = ?;";
        return jdbcTemplate.update(sql, false, volunteerId) == 1;
    }

    @Override
    public boolean setVolunteerActive(int volunteerId) {
        String sql = "update volunteer set is_active = ? where volunteer_id = ?;";
        return jdbcTemplate.update(sql, true, volunteerId) == 1;
    }

    @Override
    public boolean setVolunteerApproved(int volunteerId) {
        String sql = "update volunteer set status = 'Approved' where volunteer_id = ?;";
        return jdbcTemplate.update(sql, volunteerId) == 1;
    }

    @Override
    public boolean setVolunteerRejected(int volunteerId) {
        String sql = "update volunteer set is_active = 'Rejected' where volunteer_id = ?;";
        return jdbcTemplate.update(sql, volunteerId) == 1;
    }
}
