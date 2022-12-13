import axios from "axios";

export default {
    addQuestionnaire(questionnaire) {
        return axios.post("/adopter/questionnaire",questionnaire);
      },

    addAdopter(adopter) {
        return axios.post("/adopter", adopter);
      },

}