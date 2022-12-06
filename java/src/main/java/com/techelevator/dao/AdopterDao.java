package com.techelevator.dao;

import com.techelevator.model.Adopter;

import java.util.List;

public interface AdopterDao {

    List<Adopter> findAll();

    Adopter getAdopterById(int adopterId);

    String adoptionStatus (int adopterId);

    boolean updateStatus (Adopter adopter);

    Adopter addAdopter(Adopter newAdopter);

}
