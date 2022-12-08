package com.techelevator.controller;

import com.techelevator.dao.AvailabilityDao;
import com.techelevator.model.Adopter;
import com.techelevator.model.Availability;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
public class AvailabilityController {

    private AvailabilityDao availabilityDao;

    @RequestMapping(path="/availability", method = RequestMethod.GET )
    public List<Availability> findAll(){
        return  availabilityDao.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/availability", method = RequestMethod.POST)
    public boolean save(@Valid @RequestBody Availability availability) {
        return availabilityDao.save(availability);
    }

    @RequestMapping(path = "/availability/{id}", method = RequestMethod.PUT)
    public boolean update(@Valid @RequestBody Availability availability, @PathVariable int id) {
        return  availabilityDao.update(availability);

    }


//    @RequestMapping (path ="/availability", method = RequestMethod.GET)
//    public List<Availability> listAvailableDates(@RequestParam Date date) {
//      return  availabilityDao.getAvailabilityByDate(date);
//    }






}
