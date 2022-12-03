package com.techelevator.dao;

import com.techelevator.model.Volunteer;
import java.util.List;
public interface volunteerDao {

    List<Volunteer> findAll();

    Volunteer getVolunteerById(int volunteerID);

    boolean save(Volunteer volunteer);

    boolean update(Volunteer volunteer);

    boolean setInactive(int id);

    boolean setActive(int id);
}
