<template>
  <div>
    <animal-info :animal="animal"></animal-info>
    <!-- <h2>{{animal.name}}</h2> -->
<<<<<<< HEAD
     <animal-info />
   <adoption-questionnaire/>
=======

    <animal-info />
>>>>>>> 0642fa7189eba22524c73e7de24b463aed1a2c38
  </div>
</template>

<script>
import AnimalInfo from "@/components/AnimalInfo.vue";
import animalService from "@/services/AnimalService.js";
import AdoptionQuestionnaire from "@/components/AdoptionQuestionnaire.vue";

export default {
  data() {
    return {
      animal: {},
    };
  },

  methods: {
    displayAnimalsDetails() {
      animalService
        .getAnimalById(this.$route.params.animalId)
        .then((response) => {
          this.animal = response.data;
        });
    },
  },
  created() {
    this.displayAnimalsDetails();
  },
  components: {
    AnimalInfo,
<<<<<<< HEAD
    AdoptionQuestionnaire
  }
}
</script>

<style>
=======
  },
};
</script>

<style>
.animal-section-details {
  display: flex;
}
>>>>>>> 0642fa7189eba22524c73e7de24b463aed1a2c38
</style>
