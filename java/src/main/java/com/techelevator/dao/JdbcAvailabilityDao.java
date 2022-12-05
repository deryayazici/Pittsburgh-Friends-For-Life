package com.techelevator.dao;

import com.techelevator.model.Availability;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JdbcAvailabilityDao implements AvailabilityDao{
    private final JdbcTemplate jdbcTemplate;


    public JdbcAvailabilityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Availability> findAll() {
   List<Availability> availabilities = new ArrayList<>();
   String sql = "select * from Availability";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Availability availability =(MapRowToAvailability(results));
            availabilities.add(availability);
        }
        return availabilities;
    }

    private Availability MapRowToAvailability(SqlRowSet results) {
    Availability availability = new Availability();
    availability.setAvailabilityId(results.getInt("Availability_id"));
    availability.setAvailableDate(results.getDate("Available_date"));
    availability.setAvailableTime(results.getString("Available_time"));
    availability.setVolunteerId(results.getInt("Volunteer_id"));

    return availability;
    }


    @Override
    public List<Availability> getAvailabilityByDate(Date date) {
        List<Availability> availabilities = new ArrayList<>();
        String sql = "select * from availability where available_date = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,date);
         if(results.next()){
           Availability availability = (MapRowToAvailability(results));
           availabilities.add(availability);
        }
         return availabilities;
    }

    @Override
    public List<Availability> getAvailablilityByTime(String time) {
        List<Availability> availabilities = new ArrayList<>();
        String sql = "select * from availability where available_time = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,time);
        if(results.next()){
            Availability availability = (MapRowToAvailability(results));
            availabilities.add(availability);
        }
        return availabilities;
    }

    @Override
    public List<Availability> getAvailabilityByDateAndTime(Date date, String time) {
        List<Availability> availabilities =new ArrayList<>();
        getAvailabilityByDate(date);
        getAvailablilityByTime(time);
       return availabilities;
    }

    @Override
    public boolean save(Availability availability) {
        String sql = "insert into Availability(Availability_id,Available_date,Available_time,Volunteer_id)" +
                "Values(?,?,?,?)";
        return jdbcTemplate.update(sql,
                availability.getAvailabilityId(),
                availability.getAvailableDate(),
                availability.getAvailableTime(),
                availability.getVolunteerId())==1;
    }

    @Override
    public List<Availability> getAvailabilityByVolunteerId(int id) {
        List<Availability> availabilities = new ArrayList<>();
        String sql = "select * from availability where volunteer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        if(results.next()){
            Availability availability = (MapRowToAvailability(results));
            availabilities.add(availability);
        }
        return availabilities;
    }

    @Override
    public boolean update(Availability availability) {
       String sql = "update Availability " +
               "set Available_date = ?,Available_time = ?,volunteer_id = ?)"+
               "where Availability_id = ?;";
      return jdbcTemplate.update(sql,availability.getAvailabilityId(),availability.getVolunteerId(),
               availability.getAvailableTime(),availability.getAvailableDate())==1;
    }
}
