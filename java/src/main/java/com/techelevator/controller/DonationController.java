package com.techelevator.controller;

import com.techelevator.dao.DonationDao;
import com.techelevator.model.Donation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DonationController {
    private DonationDao donationDao;

    public DonationController(DonationDao donationDao) {
        this.donationDao = donationDao;
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/allDonations",method = RequestMethod.GET)
    public List<Donation> listDonation(){
        return donationDao.findAllDonations();
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "allDonations/{id}",method = RequestMethod.GET)
    public List<Donation> listAllDonationByUserId(@PathVariable int id){
        return donationDao.getAllDonationByUsersID(id);
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/donation/submit",method = RequestMethod.POST)
    public void addDonation(@RequestBody Donation donation){
         donationDao.AddDonation(donation);
    }


}
