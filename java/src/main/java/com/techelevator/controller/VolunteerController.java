package com.techelevator.controller;

import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
public class VolunteerController {

    @Autowired
    private VolunteerDao volunteerDao;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Volunteer getVolunteerById(@PathVariable int id) {
        Volunteer volunteer = volunteerDao.getVolunteerById(id);
        if (volunteer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Volunteer Not Found");
        } else {
            return volunteer;
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/volunteer", method = RequestMethod.POST)
    public boolean addVolunteer(@Valid @RequestBody Volunteer volunteer) {

        return volunteerDao.save(volunteer);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public boolean updateVolunteer(@Valid @RequestBody Volunteer volunteer, @PathVariable int id) {
        return  volunteerDao.update(volunteer);

    }

    @RequestMapping(path="/pendingVolunteers", method=RequestMethod.GET)
        public List<Volunteer> getPendingVolunteers() {
       return this.volunteerDao.getPending();
    }

    @RequestMapping (path ="/approveVolunteer/{id}", method = RequestMethod.PUT)
    public boolean approveVolunteer (@PathVariable int id) {
       return volunteerDao.setVolunteerApproved(id);
    }

    @RequestMapping (path="/approvedVolunteers",method = RequestMethod.GET)
    public List<Volunteer> getApprovedVolunteers() {
        return this.volunteerDao.getApproved();
    }


}
