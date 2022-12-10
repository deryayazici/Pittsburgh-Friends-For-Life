<template>
  <h2>{{volunteer.name}}</h2>
</template>

<script>
import volunteerService from '@/services/VolunteerService.js';

export default {
    props: ['volunteer',]
    
}
</script>

<style>

</style>