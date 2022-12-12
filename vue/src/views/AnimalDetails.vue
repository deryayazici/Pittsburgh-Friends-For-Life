<template>
  <div>
    <animal-info :animal="animal"></animal-info>
    <!-- <h2>{{animal.name}}</h2> -->
     <animal-info />
   <adoption-questionnaire/>
  </div>
</template>

<script>
import AnimalInfo from "@/components/AnimalInfo.vue";
import animalService from "@/services/AnimalService.js";
import AdoptionQuestionnaire from "@/components/AdoptionQuestionnaire.vue";

export default {
    data() {
    return {
        animal:{}
  
    };
  },
  
   methods:{
    displayAnimalsDetails() {
    animalService.getAnimalById(this.$route.params.animalId)
    .then ((response) => { 
      this.animal=response.data
      });
    },
  },
 created() {
  this.displayAnimalsDetails()
 },
  components: {
    AnimalInfo,
    AdoptionQuestionnaire
  }
}
</script>

<style>
</style>
