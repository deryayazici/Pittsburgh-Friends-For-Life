<template>
<section>
  <h1>Our Volunteers</h1>
  <div v-for="volunteer in approvedVolunteer" v-bind:key="volunteer.volunteerId" v-bind:volunteer="volunteer">
        <h2>{{volunteer.firstName}}  {{volunteer.lastName}}</h2>
        <h3>{{volunteer.address}}</h3>
        <h3>{{volunteer.phoneNumber}}</h3>
 </div>
</section>
 
</template>

<script>
import volunteerService from '@/services/VolunteerService.js';
export default {

data() {
  return {approvedVolunteer:[], }
},
 

  methods: {
    getAllAcceptedVolunteers() {
        volunteerService.getApprovedVolunteers()
        .then (response => {
            this.approvedVolunteer = response.data
        });
        }
  },

  created() {
    this.getAllAcceptedVolunteers()
  }

}
</script>

<style>

</style>