import axios from "axios";

export default {
  listAdoptableAnimals() {
    return axios.get('/');
  },

  getAnimalById(animalId) {
    return axios.get(`/animals/${animalId}`)
  }
};
