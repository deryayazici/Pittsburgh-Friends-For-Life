package com.techelevator.dao;

import com.techelevator.model.Animal;

import java.util.List;

public interface AnimalDao {

    List<Animal> findAll();

    Animal getAnimalById(int userId);

    boolean addAnimal (Animal animal);

    List<Animal> listAdoptableAnimals();



}
