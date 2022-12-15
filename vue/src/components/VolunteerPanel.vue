<template>
  <div>
    <h1 class="volunteer-title">Our Volunteers</h1>
    <div class="volunteer-card-container">
      <div
        class="volunteer-card"
        v-for="volunteer in approvedVolunteer"
        v-bind:key="volunteer.volunteerId"
        v-bind:volunteer="volunteer"
      >
        <h2>{{ volunteer.firstName }} {{ volunteer.lastName }}</h2>
        <p>{{ volunteer.address }}</p>
        <p>{{ volunteer.phoneNumber }}</p>
      </div>
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

<style>
.volunteer-card-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
.volunteer-card {
  background-color: #fffffe;
  padding: 30px 40px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  border-radius: 8px;
  width: 90vw;
  max-width: 25rem;
  margin: 1rem auto;
  background-color: #fffffe;
}
.volunteer-card h2 {
  letter-spacing: 4px;
  margin-bottom: 10px;
  text-transform: capitalize;
  text-align: center;
}
.volunteer-card p {
  margin-bottom: 10px;
}
</style>
