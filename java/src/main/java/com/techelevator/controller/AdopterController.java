package com.techelevator.controller;

import com.techelevator.dao.AdopterDao;
import com.techelevator.dao.JdbcAdopterDao;
import com.techelevator.model.Adopter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class AdopterController {

    @Autowired
    private AdopterDao adopterDao;


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Adopter getAdopterById(@PathVariable int id) {
        Adopter adopter = adopterDao.getAdopterById(id);
        if (adopter == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Adopter Not Found");
        } else {
            return adopter;
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Adopter addAdopter(@Valid @RequestBody Adopter adopter) {
        return adopterDao.addAdopter(adopter);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public boolean updateStatus(@Valid @RequestBody Adopter adopter, @PathVariable int id) {
      return  adopterDao.updateStatus(adopter);

    }



}

