package com.techelevator.dao;

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
    public Animal addAnimal(Animal animal) {

        String sql = "INSERT INTO animal (type, breed, age, size, temperament, name, " +
                "special_needs, photo, is_adopted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)" +
                " RETURNING animal_id";
        Integer animalId = jdbcTemplate.queryForObject(sql, Integer.class,
                animal.getType(),
                animal.getBreed(),
                animal.getAge(),
                animal.getSize(),
                animal.getTemperament(),
                animal.getName(),
                animal.isSpecialNeeds(),
                animal.getPhoto(),
                animal.isAdopted());

        animal.setAnimalId(animalId);
        return animal;
    }

    private Animal mapRowToAnimal(SqlRowSet rs){
        Animal animal = new Animal();
        animal.setAnimalId(rs.getInt("animal_id"));
        animal.setType(rs.getString("type"));
        animal.setBreed(rs.getNString("breed"));
        animal.setAge(rs.getInt("age"));
        animal.setSize(rs.getString("size"));
        animal.setTemperament(rs.getString("temperament"));
        animal.setName(rs.getString("name"));
        animal.setSpecialNeeds(rs.getBoolean("special_needs"));
        animal.setPhoto(rs.getString("photo"));
        animal.setAdopted(rs.getBoolean("is_adopted"));
        return animal;
    }
}

