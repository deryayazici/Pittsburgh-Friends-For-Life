<template>
  <div><section v-for="adopter in adopters" v-bind:key="adopter_id" :adopter="adopter">
      
  </section></div>
</template>

<script>
import AdopterService from "../services/AdopterService.js";
export default {
    methods: {
        
    }
}
</script>

<style>

</style>