<template>
  <div>
    <animal-info :animal="animal"></animal-info>
    <!-- <h2>{{animal.name}}</h2> -->
    
     <animal-info />
   
  </div>
</template>

<script>
import AnimalInfo from "@/components/AnimalInfo.vue";
import animalService from "@/services/AnimalService.js";

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
  }
}
</script>

<style></style>
