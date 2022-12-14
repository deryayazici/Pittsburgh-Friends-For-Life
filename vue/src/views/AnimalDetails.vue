<template>
  <div>
    <animal-info :animal="animal">
    </animal-info>

    <router-link :to="{name:'register'}" v-if="!checkToken" >Please register before adopting</router-link>
    <button class="showForm" @click ="showForm" v-if="checkToken">Adopt</button>
    <adoption-questionnaire v-if="showQuestionnaire"></adoption-questionnaire>

    <button class="showForm" @click ="showUpdateForm" v-if="checkAuthorizationLevel === true">Edit this Animal</button>
    <update-animal :animal="animal" v-if="showUpdate"></update-animal>
 
  </div>
</template>

<script>
import AnimalInfo from "@/components/AnimalInfo.vue";
import animalService from "@/services/AnimalService.js";
import AdoptionQuestionnaire from "@/components/AdoptionQuestionnaire.vue";
import UpdateAnimal from '../components/UpdateAnimal.vue';


export default {
   
  data() {
    return {
      showQuestionnaire:false,
      showUpdate: false,
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
        
    },
    showUpdateForm(){
      this.showUpdate = !this.showUpdate; 
    },
  },
   
  created() {
    this.displayAnimalsDetails();
  },
  components: {
    AnimalInfo,
    AdoptionQuestionnaire,
    UpdateAnimal,
  },
  computed: {
    checkToken() {
      return this.$store.state.token != null && this.$store.state.token != '';
    },

    checkAuthorizationLevel() {
      if(this.checkToken){
        if(this.$store.state.user.authorities[0].name === 'ROLE_ADMIN' || this.$store.state.user.authorities[0].name === 'ROLE_VOLUNTEER') {
          return true;
        } return false;

        } else {
          return false
          }
    },

 
},
}

</script>

<style>
.animal-section-details {
  display: flex;
}
</style>
