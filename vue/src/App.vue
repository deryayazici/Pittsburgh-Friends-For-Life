<template>
  <div id="app">
    <div class="section-title">
      <i class="fa-solid fa-paw left"></i>
      <h1 class="title">Pittsburgh Friends For Life</h1>
      <i class="fa-solid fa-paw right"></i>
    </div>

    <div id="nav">
      <base-button>
        <router-link v-bind:to="{ name: 'home' }"
          >Home</router-link
        ></base-button
      >&nbsp;|&nbsp;
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''"
        >Login</router-link
      >&nbsp;|&nbsp;
      <router-link :to="{ name: 'volunteer' }">Volunteer</router-link
      >&nbsp;|&nbsp;
      <router-link :to="{ name: 'settings' }">My Account</router-link
      >&nbsp;|&nbsp;
      <router-link :to="{ name: 'donation' }">Donate</router-link>
    </div>
    <random-cat></random-cat>

    <router-view />
  </div>
</template>
<script>
import RandomCat from "@/components/RandomCat.vue";
export default {
  components: {
    RandomCat,
  },
};
</script>

<style>
body {
  /* background-color: #fbfbbb; */
  background-color: #545454;
}

#nav {
  padding: 1rem 0 2.5rem 1rem;
  display: flex;
  justify-content: space-around;
  font-size: 1.5rem;
}
#nav a {
  background-color: #ff8ba7;
  color: #fffffe;
  padding: 0.25rem 0.75rem;
  border-radius: 8px;
  letter-spacing: 2px;
}
#nav a:hover,
a:active {
  background-color: #ffc6c7;
}

.section-title {
  position: relative;
  display: flex;
  justify-content: space-between;
  padding: 4rem 0 1rem;
  width: 90vw;
  max-width: 600px;
  margin: 0 auto;
}
.left {
  position: absolute;
  top: 58px;
  left: -100px;
  font-size: 4rem;
  color: var(--clr-2);
}
.right {
  position: absolute;
  top: 58px;
  right: -100px;
  font-size: 4rem;
  color: var(--clr-2);
}
.title {
  text-align: center;
  letter-spacing: 4px;
  color: #fffffe;
  /* border: 5px solid #ff8ba7; */
  padding: 10px 20px;
  background-color: var(--clr-1);
  border-radius: 8px;
}
</style>
