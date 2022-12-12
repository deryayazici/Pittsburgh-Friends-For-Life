<template>
  <section class="section">
    <article class="detail-picture">
      <div class="pic-container">
        <img v-bind:src="animal.photo" alt="" />
      </div>
    </article>

    <article class="information">
      <div class="name-title">
        <h2>Name: {{ animal.name }}</h2>
      </div>
      <div class="desc">
        <p>Type: {{ animal.type }}</p>
        <p>Breed: {{ animal.breed }}</p>
        <p>Age: {{ animal.age }}</p>
        <p>Temperament: {{ animal.temperament }}</p>
        <p>Special Needs: {{ animal.specialNeeds ? "Yes" : "No" }}</p>
      </div>
    </article>
  </section>
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
:root {
  --clr-1: #ff8ba7;
  --clr-2: #3cf157;
  --clr-3: #fbfbbb;
}
.section {
  display: flex;
  justify-content: center;
  gap: 2rem;
}

.information {
  padding: 2rem;
}

.name-title {
  letter-spacing: 4px;
  color: var(--clr-2);
  padding: 0.5rem 0;
  text-align: center;
}
.desc p {
  padding: 0.5rem 10px;
  color: #fffffe;
  background-color: var(--clr-1);
  margin: 10px 0;
  border-radius: 4px;
  text-transform: capitalize;
}
</style>
