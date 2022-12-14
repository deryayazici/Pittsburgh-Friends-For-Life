<template>
  <div>
    <animal-info :animal="animal"> </animal-info>
    <router-link :to="{ name: 'register' }" v-if="!checkToken"
      >Please register before adopting</router-link
    >
    <div class="adopt-btn-div">
      <button class="showForm" @click="showForm" v-if="checkToken">
        {{ showQuestionnaire ? "Hide Form" : "Adopt" }}
      </button>
    </div>

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
      showQuestionnaire: false,
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
};
</script>

<style>
.animal-section-details {
  display: flex;
  background-color: #fbfbbb;
}
.adopt-btn-div {
  width: 90vw;
  margin: 2rem auto;
  text-align: center;
}
.showForm {
  background-color: #ff8ba7;
  padding: 0.25rem 0.75rem;
  width: 50%;
  border: 2px solid transparent;
  border-radius: 8px;
  font-family: inherit;
  color: #fffffe;
  cursor: pointer;
}
.showForm:hover {
  background-color: #ffc6c7;
}
</style>
