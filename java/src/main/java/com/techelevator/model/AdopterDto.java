package com.techelevator.model;

public class AdopterDto {

    private int adopterId;
    private String approvedToAdopt;
    private int animalId;

    public int getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(int adopterId) {
        this.adopterId = adopterId;
    }

    public String getApprovedToAdopt() {
        return approvedToAdopt;
    }

    public void setApprovedToAdopt(String approvedToAdopt) {
        this.approvedToAdopt = approvedToAdopt;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }
}
