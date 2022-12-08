<template>
  <section>
    <ul>
      <li v-for="pic in pics" :key="pic">
        <article class="picture">
          <div class="pic-container">
            <router-link to="/animals/${id}">
              <img :src="require(`@/assets/${pic}`)" alt="" />
            </router-link>
          </div>
        </article>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  data() {
    return {
      pics: [
        "catPic.jpg",
        "rabbit.jpg",
        "dog.jpg",
        "ferret.jpg",
        "indy.jpg",
        "ferret2.jpg",
      ],
    };
  },
};
</script>

<style>
.home {
  background-color: #fffffe;

  min-height: 100vh;
}
li {
  list-style-type: none;
}
img {
  display: block;
  width: 100%;
  margin: 10px 0 20px;
}
.picture {
  margin: 20px;
}
.pic-container {
  margin: 20px 0;
  background-color: #fffffe;
  padding: 20px 25px;
  border: 2px solid #fffffe;
  width: 90vw;
  margin: 20px auto;
  max-width: 300px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border-radius: 4px;
}

@media screen and (min-width: 500px) {
  ul {
    display: grid;
    grid-template-columns: 1fr 1fr;
    min-width: 90vw;
    row-gap: 20px;
    column-gap: 20px;
  }
  img {
    object-fit: cover;
    height: 300px;
  }
  @media screen and (min-width: 768px) {
    ul {
      grid-template-columns: 1fr 1fr 1fr;
    }
  }
}
</style>
