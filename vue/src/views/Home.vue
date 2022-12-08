<template>
  <div class="home">
    
    <animal-card v-for="animal in $store.state.animals" v-bind:key="animal.id" ></animal-card>


    <!-- <h1>Home</h1>
    <p>You must be authenticated to see this</p> -->
  </div>
</template>

<script>
import AnimalCard from "@/components/AnimalCard.vue";

export default {

  components: {
    AnimalCard,
  },
  name: "home",

  data() {
    return {};
  },
};
</script>
<style></style>
