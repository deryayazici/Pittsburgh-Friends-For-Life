package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Donation {

    private int donation_id;
    @JsonProperty("donatorId")
    private int donator_id;

    @JsonProperty("firstName")
    private String first_name;

    @JsonProperty("lastName")
    private String last_name;
    private String description;

    @JsonProperty("date")
    private LocalDate donation_date;

    public LocalDate getDonation_date() {
        return donation_date;
    }

    public void setDonation_date(LocalDate donation_date) {
        this.donation_date = donation_date;
    }

    public int getDonation_id() {
        return donation_id;
    }

    public int getDonator_id() {
        return donator_id;
    }

    public void setDonator_id(int donator_id) {
        this.donator_id = donator_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
