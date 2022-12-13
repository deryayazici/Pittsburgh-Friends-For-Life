package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class QuestionnaireDto {

    @NotEmpty
    @JsonProperty("firstName")
    private String first_name;
    @NotEmpty
    @JsonProperty("lastName")
    private String last_name;
    @NotEmpty
    @JsonProperty("phoneNumber")
    private String phone_number;
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    @JsonProperty("numberChildren")
    private int number_children;
    @NotEmpty
    @JsonProperty("housingType")
    private String housing_type;
    @JsonProperty("fencedYard")
    private boolean fenced_yard;
    @NotEmpty
    private String walker;
    @JsonProperty("yearsOfPetExperience")
    private int years_of_pet_experience;
    @NotEmpty
    @JsonProperty("rentingOrOwning")
    private String renting_or_owning;
    @NotEmpty
    private String vet;
    private boolean disabled;
    private int animal_id;
    private int adopter_id;
    @NotEmpty
    @JsonProperty("referenceOne")
    private String reference_one;
    @NotEmpty
    @JsonProperty("referenceOneContact")
    private String reference_one_contact;
    @NotEmpty
    @JsonProperty("referenceTwo")
    private String reference_two;
    @NotEmpty
    @JsonProperty("referenceTwoContact")
    private String reference_two_contact;

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

    public String getReference_one() {
        return reference_one;
    }

    public void setReference_one(String reference_one) {
        this.reference_one = reference_one;
    }

    public String getReference_one_contact() {
        return reference_one_contact;
    }

    public void setReference_one_contact(String reference_one_contact) {
        this.reference_one_contact = reference_one_contact;
    }

    public String getReference_two() {
        return reference_two;
    }

    public void setReference_two(String reference_two) {
        this.reference_two = reference_two;
    }

    public String getReference_two_contact() {
        return reference_two_contact;
    }

    public void setReference_two_contact(String reference_two_contact) {
        this.reference_two_contact = reference_two_contact;
    }
}
