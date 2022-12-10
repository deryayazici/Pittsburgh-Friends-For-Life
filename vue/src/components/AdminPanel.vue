<template>
<div>
  <section v-for="volunteer in pendingVolunteers" v-bind:key="volunteer.volunteerId" v-bind:volunteer="volunteer">
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
            this.pendingVolunteers = volunteerService.get
        }
    }
}
</script>

<style>

</style>