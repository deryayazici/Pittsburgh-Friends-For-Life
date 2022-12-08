<template>
  <div>
    <h2>{{animal.name}}</h2>
    <animal-info v-bind:animalDetail="animal"></animal-info>
  </div>
</template>

<script>
import AnimalInfo from "@/components/AnimalInfo.vue";
import animalService from "@/services/AnimalService.js";
export default {
  
  methods: {
    displayAnimalDetails() {
      animalService.getAnimalById(this.animalId) .then(response => {
        return response.data
      })
    }
  },

  components: {
    AnimalInfo,
  },
};
</script>

<style></style>
