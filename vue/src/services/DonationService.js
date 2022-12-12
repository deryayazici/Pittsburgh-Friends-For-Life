import axios from "axios";

export default {
    submitDonation(donation) {
        return axios.post("/donation/submit", donation);
    },

    listDonations() {
        return axios.get("/allDonations")
    },

    listDonationsById(userId) {
        return axios.get(`/allDonations/${userId}`, userId)
    }
}