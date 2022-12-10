<template>
<div>
    <h2>
      Hello
    </h2>
    <admin-panel v-if="checkAuthorizationLevel === 'ROLE_ADMIN'"></admin-panel>
    <volunteer-panel v-if="checkAuthorizationLevel === 'ROLE_VOLUNTEER' || checkAuthorizationLevel === 'ROLE_ADMIN'"></volunteer-panel>
     
</div>
  
</template>

<script>
import AdminPanel from '../components/AdminPanel.vue'
import VolunteerPanel from '../components/VolunteerPanel.vue'
export default {

  components: { AdminPanel, VolunteerPanel },

  computed: {
    checkAuthorizationLevel() {
        return this.$store.state.user.authorities[0].name;
    },
}}
</script>

<style>

</style>