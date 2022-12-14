<template>
<div>
    <admin-panel v-if="checkAuthorizationLevel === 'ROLE_ADMIN'"></admin-panel>
    <volunteer-panel v-if="checkAuthorizationLevel === 'ROLE_VOLUNTEER' || checkAuthorizationLevel === 'ROLE_ADMIN'"></volunteer-panel>
    <button class="displayForm" v-if="checkAuthorizationLevel === 'ROLE_VOLUNTEER' || checkAuthorizationLevel === 'ROLE_ADMIN'" @click ="showForm">Add Pet</button>
    <add-pet v-if="isFormExtended" ></add-pet>

</div>
  
</template>

<script>
import AdminPanel from '../components/AdminPanel.vue'
import VolunteerPanel from '../components/VolunteerPanel.vue'
 import AddPet from '../components/AddPet.vue'

export default {
       data() {
  return {
    
   
    isFormExtended: false,
  }
       },
    

  components: { AdminPanel, VolunteerPanel, AddPet },

  computed: {
    checkAuthorizationLevel() {
        return this.$store.state.user.authorities[0].name;
    },
},

methods:{
     showForm() {
      this.isFormExtended = !this.isFormExtended;
    },
}


}
</script>

<style>

</style>