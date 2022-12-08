<template>
  <div id="app">
    <div class="section-title">
      <h1 class="title">Pittsburgh Friends For Life</h1>
    </div>

    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
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
      <router-link :to="{ name: 'adopt' }">Adopt</router-link>&nbsp;|&nbsp;
      <router-link :to="{ name: 'donation' }">Donate</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
body {
  background-color: #fbfbbb;
}
#nav {
  padding: 1rem 0 2.5rem 1rem;
  display: flex;
  justify-content: space-around;
}
.section-title {
  padding: 4rem 0 1rem;
  width: 90vw;
  max-width: 600px;
  margin: 0 auto;
}
.title {
  text-align: center;
  letter-spacing: 4px;
  color: #fffffe;
  /* border: 5px solid #ff8ba7; */
  padding: 10px 0;
  background-color: var(--clr-1);
  border-radius: 4px;
}
</style>
