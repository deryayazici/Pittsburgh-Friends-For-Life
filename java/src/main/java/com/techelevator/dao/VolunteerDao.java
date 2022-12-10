package com.techelevator.dao;

import com.techelevator.model.Volunteer;
import java.util.List;
public interface VolunteerDao {

    List<Volunteer> findAll();

    Volunteer getVolunteerById(int volunteerID);

    boolean save(Volunteer volunteer);

    boolean update(Volunteer volunteer);

    boolean setVolunteerInactive(int volunteerId);

    boolean setVolunteerActive(int volunteerId);

    boolean setVolunteerApproved(int volunteerId);

    boolean setVolunteerRejected(int volunteerId);

    List<Volunteer> getPending();

}
