<template>
<div>
    <h1>Pending Volunteers</h1>
  <section v-for="volunteer in pendingVolunteers" v-bind:key="volunteer.volunteerId">
     <div>
         <!-- <h2>{{volunteer.volunteerId}}</h2> -->
        <h2>{{volunteer.firstName}}  {{volunteer.lastName}}</h2>
        <h3>{{volunteer.address}}</h3>
        <h3>{{volunteer.phoneNumber}}</h3>
        <button type="submit" @click ="approve(volunteer.volunteerId)">Approve</button> 
        <!-- todo make approval change user authorities -->
        <button type="submit" @click = "reject(volunteer.volunteerId)" >Reject</button>
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

        approve(id) {
       volunteerService.approveVolunteerStatus(id).then((response) => {
           if(response.status === 201) {
               this.$router.push("/settings");
           }
       })
    },
        reject(id) {
        volunteerService.rejectVolunteerStatus(id).then((response) => {
            if(response.status === 201) {
                this.$router.push("/settings");
            }
        })
    },

    },
    created(){
        this.getAllPendingVolunteers()
    }
}
</script>

<style>

</style>