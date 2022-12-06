<template>
  <div id="app">
          <h1>Pittsburgh Friends For Life</h1>

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
      <router-link :to="{name:'volunteer'}" >Volunteer</router-link>&nbsp;|&nbsp;
      <router-link :to="{name:'adopt'}">Adopter</router-link>&nbsp;|&nbsp;
      <router-link :to="{name:'donation'}" >Donate</router-link>
     
    </div>
    <router-view />
  </div>
</template>

<style>


#nav {
  background-color: #faeee7;
  padding: 1rem 0 1rem 1rem;
}
h1 {
  text-align: center; 
  border:5px solid #ff8ba7 ;
  padding:5px;
  background-color:#faeee7;
}

</style>
