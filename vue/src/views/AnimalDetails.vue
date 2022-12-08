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
    data() {
    return {
        animal: {}   
    };
  },
  
  methods: {
    displayAnimalDetails() {
      animalService.getAnimalById(this.$route.params.animalId) .then(response => {
        return response.data
      });
    },
     created() {
          this.displayAnimalDetails
      }
  },

  components: {
    AnimalInfo,
  },
};
</script>

<style></style>
