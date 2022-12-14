<template>
  <div>
    <animal-info :animal="animal">
      
    </animal-info>
    <router-link :to="{name:'register'}" v-if="!checkToken" >Please register before adopting</router-link>
    <button class="showForm" @click ="showForm" v-if="checkToken">Adopt</button>
    <adoption-questionnaire v-if="showQuestionnaire"></adoption-questionnaire>
 
  </div>
</template>

<script>
import AnimalInfo from "@/components/AnimalInfo.vue";
import animalService from "@/services/AnimalService.js";
import AdoptionQuestionnaire from "@/components/AdoptionQuestionnaire.vue";


export default {
   
  data() {
    return {
      showQuestionnaire:false,
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
    showForm() {
      this.showQuestionnaire = !this.showQuestionnaire;   
    }
  },
   
  created() {
    this.displayAnimalsDetails();
  },
  components: {
    AnimalInfo,
    AdoptionQuestionnaire,
  },
  computed: {
    checkToken() {
      return this.$store.state.user.username != null;
    },

 
},
}

</script>

<style>
.animal-section-details {
  display: flex;
}
</style>
