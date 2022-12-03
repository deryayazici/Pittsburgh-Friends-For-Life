package com.techelevator.model;

public class Questionnaire {
    private int questionnaire_id;

    private String first_name;

    private String last_name;

    private int number_children;

    private String housing_type;

    private boolean fenced_yard;

    private String walker;

    private int years_of_pet_experience;

    private String renting_or_owning;

    private String vet;

    private boolean disabled;

    private int animal_id;

    private int adopter_id;

    public int getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(int questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getNumber_children() {
        return number_children;
    }

    public void setNumber_children(int number_children) {
        this.number_children = number_children;
    }

    public String getHousing_type() {
        return housing_type;
    }

    public void setHousing_type(String housing_type) {
        this.housing_type = housing_type;
    }

    public boolean isFenced_yard() {
        return fenced_yard;
    }

    public void setFenced_yard(boolean fenced_yard) {
        this.fenced_yard = fenced_yard;
    }

    public String getWalker() {
        return walker;
    }

    public void setWalker(String walker) {
        this.walker = walker;
    }

    public int getYears_of_pet_experience() {
        return years_of_pet_experience;
    }

    public void setYears_of_pet_experience(int years_of_pet_experience) {
        this.years_of_pet_experience = years_of_pet_experience;
    }

    public String getRenting_or_owning() {
        return renting_or_owning;
    }

    public void setRenting_or_owning(String renting_or_owning) {
        this.renting_or_owning = renting_or_owning;
    }

    public String getVet() {
        return vet;
    }

    public void setVet(String vet) {
        this.vet = vet;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public int getAdopter_id() {
        return adopter_id;
    }

    public void setAdopter_id(int adopter_id) {
        this.adopter_id = adopter_id;
    }

    
}
