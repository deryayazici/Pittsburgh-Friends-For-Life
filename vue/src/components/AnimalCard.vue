<template>
<section>
  <article class="picture" >
    <div class="pic-container">
      <router-link >
        <img src="../../catPic.jpg" alt="" />
      </router-link>

    </div>
  </article>
  </section>
</template>

<script>
import animalService from '@/services/AnimalService.js';
export default {

  data() {
    return {
      pics: ["../../catPic.jpg", "../../rabbit.jpg"],
    };
  },
  methods:{
    displayAnimals() {
    animalService.listAdoptableAnimals()
    .then (response => {
      this.$store.commit("SET_ANIMALS", response.data);
    });
    }
  },
  created() {
    this.displayAnimals()
  },
};
</script>

<style>
img {
  display: block;
  width: 100%;
}
.home {
  background-color: #fffffe;
  min-height: 100vh;
}
.picture {
  background-color: #fffffe;
  padding: 20px 25px;
  border: 2px solid #fffffe;
  width: 90vw;
  margin: 0 auto;
  max-width: 400px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border-radius: 4px;
}
</style>
