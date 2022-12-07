package com.techelevator.controller;

import com.techelevator.dao.AnimalDao;
import com.techelevator.model.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AnimalController {

    private final AnimalDao dao;

    public AnimalController(AnimalDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "/animals", method = RequestMethod.GET)
    public List<Animal> listAnimals(){
        return dao.findAll();
    }

    @RequestMapping(path = "/animals/{id}", method = RequestMethod.GET)
    public Animal getAnimalById(@PathVariable int id){
       return dao.getAnimalById(id);
    }

    @RequestMapping(path = "/animals", method = RequestMethod.POST)
    public void addAnimal(Animal animal){
        dao.addAnimal(animal);
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public void listAdoptableAnimals(){

        dao.listAdoptableAnimals();
    }

}
