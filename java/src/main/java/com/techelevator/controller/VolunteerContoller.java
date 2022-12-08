package com.techelevator.controller;

import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.Adopter;
import com.techelevator.model.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;


@RestController
@CrossOrigin
public class VolunteerContoller {

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
}
