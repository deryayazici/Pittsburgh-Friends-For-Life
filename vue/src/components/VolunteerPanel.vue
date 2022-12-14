<template>
  <div>
    <h1 class="volunteer-title">Our Volunteers</h1>
    <div
      v-for="volunteer in approvedVolunteer"
      v-bind:key="volunteer.volunteerId"
      v-bind:volunteer="volunteer"
    >
      <h2>{{ volunteer.firstName }} {{ volunteer.lastName }}</h2>
      <h3>{{ volunteer.address }}</h3>
      <h3>{{ volunteer.phoneNumber }}</h3>
    </div>
    <!-- <button class="add-pet-form" @click="showForm">Add Pet</button>
    <add-pet v-if="isFormExtended"></add-pet> -->
  </div>
</template>

<script>
import volunteerService from "@/services/VolunteerService.js";
//import AddPet from "../components/AddPet.vue";
export default {
  data() {
    return {
      approvedVolunteer: [],
    };
  },

  methods: {
    getAllAcceptedVolunteers() {
      volunteerService.getApprovedVolunteers().then((response) => {
        this.approvedVolunteer = response.data;
      });
    },

    // showForm() {
    //   this.isFormExtended = !this.isFormExtended;
    // },
  },
  components: {},

  created() {
    this.getAllAcceptedVolunteers();
  },
};
</script>

<style></style>
