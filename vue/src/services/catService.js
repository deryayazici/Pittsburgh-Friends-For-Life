import axios from "axios";

// const http = axios.create({
//   baseURL: "https://cataas.com",
// });

export default {
  getCat() {
    return axios.get("https://cataas.com/cat");
  },
};
