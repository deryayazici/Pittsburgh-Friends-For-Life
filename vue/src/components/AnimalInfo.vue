<template>
  <div>
    <article class="picture">
      <div class="pic-container">
        <router-link to="/animals/${id}">
          <img src="../../catPic.jpg" alt="" />
        </router-link>
      </div>
    </article>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
};
</script>

<style></style>
