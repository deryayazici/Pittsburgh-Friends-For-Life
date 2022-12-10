<template>
<div>
  <section v-for="volunteer in pendingVolunteers" v-bind:key="volunteer.volunteerId" v-bind:volunteer="volunteer">
     <div>
        <h2>{{volunteer.firstName}}  {{volunteer.lastName}}</h2>
        <h3>{{volunteer.address}}</h3>
        <h3>{{volunteer.phoneNumber}}</h3>
        <button type="submit" v-on:click ="approve()">Approve</button>
        <button type="submit" @click = "reject" >Reject</button>
    </div>
  </section>
</div>
</template>

<script>
import volunteerService from "@/services/VolunteerService.js"

export default {
    data() {
        return {
        pendingVolunteers: [],
    }
    },
    methods: {
        getAllPendingVolunteers() {
        volunteerService.getPendingVolunteers()
        .then (response => {
            this.pendingVolunteers = response.data
        });
        },

        approve() {
       volunteerService.approveVolunteerStatus(this.volunteer.volunteerId)
    }
    },
    created(){
        this.getAllPendingVolunteers()
    }
}
</script>

<style>

</style>