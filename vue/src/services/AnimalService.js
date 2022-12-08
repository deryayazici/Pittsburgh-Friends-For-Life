import axios from "axios";

export default {
  listAdoptableAnimals() {
    return axios.get('/');
  },
};
