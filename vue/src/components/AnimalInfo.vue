<template>
  <div>
    <section class="section">
      <article class="picture">
        <div class="pic-container">
          <img v-bind:src="animal.photo" alt=""/>
        </div>
      </article>

      <article class="information">
        <h2>Type: {{ animal.type }}</h2>
        <h2>Name: {{ animal.name }}</h2>
        <h2>Breed: {{ animal.breed }}</h2>
        <h2>Age: {{ animal.age }}</h2>
        <h2>Temperament: {{ animal.temperament }}</h2>
        <h2>Special Needs: {{ animal.specialNeeds }}</h2>
      </article>
    </section>
  </div>
</template>

<script>
export default {
  props: ["animal"],

  data() {
    return {};
  },
};
</script>

<style>
.section {
  display: flex;
}

</style>
