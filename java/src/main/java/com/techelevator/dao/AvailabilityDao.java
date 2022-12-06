package com.techelevator.dao;

import com.techelevator.model.Availability;

import java.util.Date;
import java.util.List;

public interface AvailabilityDao {

    List<Availability> findAll();

    List<Availability> getAvailabilityByDate(Date date);

    List<Availability> getAvailabilityByTime(String time);

    List<Availability> getAvailabilityByDateAndTime(Date date,String time);

    boolean save(Availability availability);

    List<Availability> getAvailabilityByVolunteerId(int id);

    boolean update(Availability availability);

}
