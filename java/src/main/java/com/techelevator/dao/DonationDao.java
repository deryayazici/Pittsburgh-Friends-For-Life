package com.techelevator.dao;

import com.techelevator.model.Donation;


import java.util.Date;
import java.util.List;

public interface DonationDao {

    List<Donation> findAllDonations();

    List<Donation> getAllDonationByUsersID(int userId);

    Donation AddDonation(Donation donation);
}
