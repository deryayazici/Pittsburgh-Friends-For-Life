<template>
  <div class="home">
    <animal-card
      v-for="animal in $store.state.animals"
      v-bind:key="animal.id"
      v-bind:animal="animal"
    ></animal-card>
    <!-- <random-cat></random-cat> -->
    <!-- <h1>Home</h1>
    <p>You must be authenticated to see this</p> -->
  </div>
</template>

<script>
import AnimalCard from "@/components/AnimalCard.vue";
import animalService from "@/services/AnimalService.js";
// import RandomCat from "@/components/RandomCat.vue";

export default {
  components: {
    AnimalCard,
    // RandomCat,
  },
  name: "home",

  data() {
    return {};
  },
  methods: {
    displayAnimals() {
      animalService.listAdoptableAnimals().then((response) => {
        this.$store.commit("SET_ANIMAL", response.data);
      });
    },
  },
  created() {
    this.displayAnimals();
  },
};
</script>
<style></style>
