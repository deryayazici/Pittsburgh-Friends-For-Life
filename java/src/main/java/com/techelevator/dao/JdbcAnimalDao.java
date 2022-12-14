package com.techelevator.dao;

import com.techelevator.model.Adopter;
import com.techelevator.model.Animal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAnimalDao implements AnimalDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAnimalDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Animal> findAll() {

        List<Animal> animals = new ArrayList<>();
        String sql = "SELECT * FROM animal";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public Animal getAnimalById(int animalId) {

        String sql = "SELECT * FROM animal WHERE animal_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, animalId);
        if(results.next()){
            return mapRowToAnimal(results);
        }else{
            return null;
        }

    }

    @Override
    public boolean addAnimal(Animal animal) {

        String sql = "INSERT INTO animal (animal_id,type, breed, age, size, temperament, name, " +
                "special_needs, photo, is_adopted) VALUES (default,?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING animal_id;";

        Integer animalId = jdbcTemplate.queryForObject(sql, Integer.class,
                animal.getType(),
                animal.getBreed(),
                animal.getAge(),
                animal.getSize(),
                animal.getTemperament(),
                animal.getName(),
                animal.isSpecialNeeds(),
                animal.getPhoto(),
                true);

        return animalId > 0;
    }
    @Override
    public boolean updateAnimal(int animalId,Animal animal) {
        String sql = "update animal set type =?, breed=?, size=?, temperament=?, name=?, special_needs=?, photo=?, is_adopted=? where animal_id=?;";

        return jdbcTemplate.update(sql,animal.getType(),
                animal.getBreed(),animal.getSize(),animal.getTemperament(),
                animal.getName(),animal.isSpecialNeeds(),animal.getPhoto(),animal.isAdopted(),animalId) ==1;
    }

    @Override
    public Animal getAnimalByName(String name){

        String sql = "SELECT * FROM animal WHERE name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name.toLowerCase());
        if(results.next()){
            return mapRowToAnimal(results);
        }else{
            return null;
        }
    }

    @Override
    public List<Animal> listAdoptableAnimals() {

        List<Animal> displayAnimal = new ArrayList<>();
        String sql = "SELECT * FROM animal WHERE is_adopted = true";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            displayAnimal.add(mapRowToAnimal(results));
        }
        return displayAnimal;
    }

    private Animal mapRowToAnimal(SqlRowSet rs){
        
        Animal animal = new Animal();
        animal.setAnimalId(rs.getInt("animal_id"));
        animal.setType(rs.getString("type"));
        animal.setBreed(rs.getString("breed"));
        animal.setAge(rs.getInt("age"));
        animal.setSize(rs.getString("size"));
        animal.setTemperament(rs.getString("temperament"));
        animal.setName(rs.getString("name"));
        animal.setSpecialNeeds(rs.getBoolean("special_needs"));
        animal.setPhoto(rs.getString("photo"));
        animal.setIsAdopted(rs.getBoolean("is_adopted"));
        return animal;
    }
}

