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
      AdoptionQuestionnaire: {
        questionnaire_id: 0,
        first_name: "",
        last_name: "",
        number_children: 0,
        housing_type: "",
        fenced_yard: false,
        walker: "",
        years_of_pet_experience: 0,
        renting_or_owning: "",
        vet: "",
        disabled: false,
        animal_id: this.$router.animalId,
        adopter_id: this.$store.state.user.id,
        reference_one: "",
        reference_one_contact: "",
        reference_two: "",
        reference_two_contact: "",
      },
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
