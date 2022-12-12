<template>
<div>
    <h1>Pending Volunteers</h1>
  <section v-for="volunteer in pendingVolunteers" v-bind:key="volunteer.volunteerId" v-bind:volunteer="volunteer">
     <div>
        <h2>{{volunteer.firstName}}  {{volunteer.lastName}}</h2>
        <h3>{{volunteer.address}}</h3>
        <h3>{{volunteer.phoneNumber}}</h3>
        <button type="submit" @click ="approve">Approve</button> 
        <!-- todo make approval change user authorities -->
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
    },
    reject() {
        volunteerService.rejectVolunteerStatus(this.volunteer.volunteerId)
    },

    },
    created(){
        this.getAllPendingVolunteers()
    }
}
</script>

<style>

</style>