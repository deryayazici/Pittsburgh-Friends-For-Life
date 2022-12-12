import axios from "axios";

export default {
    addQuestionnaire(adopterId) {
        return axios.post(`/adopter/${adopterId}`, adopterId);
      },

    addAdopter(adopter) {
        return axios.post("/adopter", adopter);
      },

}