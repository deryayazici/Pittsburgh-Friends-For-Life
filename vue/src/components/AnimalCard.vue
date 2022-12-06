<template>
  <article class="picture">
    <div class="pic-container">
      <router-link to="/animals/${id}">
        <img src="../../catPic.jpg" alt="" />
      </router-link>
    </div>
  </article>
</template>

<script>
export default {};
</script>

<style>
.section-center {
  background-color: red;
  width: 90vw;
  margin: 0 auto;
}
li {
  list-style-type: none;
}
ul {
  display: flex;
  justify-content: space-around;
}
img {
  display: block;
  width: 100%;
}
.home {
  background-color: #faeee7;
  min-height: 100vh;
}
.picture {
  padding: 30px 35px;
  border: 2px solid #faeee7;
  width: 90vw;
  margin: 0 auto;
  max-width: 400px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border-radius: 4px;
}
</style>
