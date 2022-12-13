package com.techelevator.dao;

import com.techelevator.model.Donation;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcDonationDao implements DonationDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcDonationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Donation> findAllDonations() {
        List<Donation> donations = new ArrayList<>();
        String sql = "Select * from donation";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            Donation donation = mapRowToDonation(result);
            donations.add(donation);
        }
        return donations;
    }

    @Override
    public List<Donation> getAllDonationByUsersID(int userId) {
        List<Donation> donations = new ArrayList<>();
        String sql = "Select * from donation where user_id=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            Donation donation = mapRowToDonation(result);
            donations.add(donation);
        }
        return donations;
    }

    @Override
    public Donation AddDonation(Donation donation) {
       String sql = "insert into donation(donator_id,first_name,last_name,donation_date,description)" +
               " values(?,?,?,?,?)" +   " RETURNING donation_id";
       Integer donationId = jdbcTemplate.queryForObject(sql,Integer.class,
                donation.getDonator_id(),
                donation.getFirst_name(),
                donation.getLast_name(),
               donation.getDonation_date(),
                donation.getDescription());
       return donation;
    }

    private Donation mapRowToDonation(SqlRowSet result) {
        Donation donation = new Donation();
        donation.setDonator_id(result.getInt("donator_id"));
        donation.setFirst_name(result.getString("First_name"));
        donation.setLast_name(result.getString("last_name"));
        donation.setDescription(result.getString("description"));
        donation.setDonation_date((result.getDate("donation_date")).toLocalDate());

        return donation;
    }
}
