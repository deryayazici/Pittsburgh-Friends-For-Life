import axios from "axios";

// const http = axios.create({
//   baseURL: "https://meowfacts.herokuapp.com/",
// });

export default {
  getCat() {
    return axios.get("https://meowfacts.herokuapp.com/");
  },
};
