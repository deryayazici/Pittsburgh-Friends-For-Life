<template>
  <div>
    <h2>{{ animal.name }}</h2>
    <div class="animal-section-details">
      <animal-info v-bind:animalDetail="animal"></animal-info>
      <div class="animal-section-info">
        <h2>name:</h2>
        <p>breed:</p>
        <p>size:</p>
        <p>age:</p>
        <p>temperament:</p>
        <p>special needs:</p>
        <p>available for adoption:</p>
      </div>
    </div>
  </div>
</template>

<script>
import AnimalInfo from "@/components/AnimalInfo.vue";
import animalService from "@/services/AnimalService.js";

export default {
  data() {
    return {
      animal: {},
    };
  },

  methods: {
    displayAnimalDetails() {
      animalService
        .getAnimalById(this.$route.params.animalId)
        .then((response) => {
          return response.data;
        });
    },
    created() {
      this.displayAnimalDetails;
    },
  },

  components: {
    AnimalInfo,
  },
};
</script>

<style>
.animal-section-details {
  display: flex;
}
</style>
