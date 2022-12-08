<template>
  <section class="picture">
    <div class="pic-container">
      <router-link to="/animals/${id}">
        <img src="../../catPic.jpg" alt="" />
      </router-link>
      <h3>Fiddles</h3>
      <p>4 years old</p>
      <p>cute cuddly cat</p>
      <span><i class="fa-solid fa-cat"></i></span>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style></style>
