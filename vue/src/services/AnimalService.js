import axios from "axios";

export default {
  listAdoptableAnimals() {
    return axios.get('/');
  },

  getAnimalById(animalId) {
    return axios.get(`/animals/${animalId}`)
  },

  addAdoptableAnimal(animal){
    return axios.post("/animals",animal)
  },
  updateAnimal(animalId, animal) {
    return axios.put(`/animals/${animalId}`, animal)
  }
};
