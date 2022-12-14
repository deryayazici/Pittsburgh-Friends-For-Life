<template>
  <div class="quote">
    <p class="cat-fact">{{ cat }}</p>
  </div>
</template>

<script>
import catService from "@/services/catService.js";
export default {
  name: "random-cat",
  data() {
    return {
      cat: "",
    };
  },
  methods: {},
  created() {
    catService.getCat().then((resp) => {
      console.log(resp.data);
      this.cat = resp.data.data[0];

      //this.cat = resp.data;
    });
  },
};
</script>

<style>
.cat-fact {
  font-size: 12px;
  color: #fffffe;
  margin-bottom: 2rem;
  background-color: #ff8ba7;
  max-width: 30em;
  margin: auto;
  text-align: center;
  padding: 0.5rem 1rem;
  border-radius: 8px;
  margin-bottom: 1rem;
}
</style>
