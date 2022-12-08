<template>
  <div>
    <article class="picture">
      <div class="pic-container">
        <h1>it works</h1>
        
          <img v-bind:src="animalDetail.photo" alt="" />
        
      </div>
    </article>
  </div>
</template>

<script>
export default {
  props: ['animalDetail'],

  data() {
    return {
    };
  },
};
</script>

<style></style>
