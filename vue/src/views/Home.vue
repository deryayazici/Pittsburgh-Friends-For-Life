<template>
  <div class="home">
    
    <animal-card v-for="animal in $store.state.animals" v-bind:key="animal.id" v-bind:animal="animal" ></animal-card>

    <!-- <h1>Home</h1>
    <p>You must be authenticated to see this</p> -->
  </div>
</template>

<script>
import AnimalCard from "@/components/AnimalCard.vue";
import animalService from '@/services/AnimalService.js';

export default {

  components: {
    AnimalCard,
  },
  name: "home",

  data() {
    return {};
  },
  methods:{
    displayAnimals() {
    animalService.listAdoptableAnimals()
    .then ((response) => { 
      this.$store.commit('SET_ANIMAL', response.data);
      });
    }
  },
  created() {
    this.displayAnimals()
  },
};
</script>
<style></style>
