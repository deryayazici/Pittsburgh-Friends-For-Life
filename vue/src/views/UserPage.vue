<template>
  <div>
    <admin-panel v-if="checkAuthorizationLevel === 'ROLE_ADMIN'"></admin-panel>
    <volunteer-panel
      v-if="
        checkAuthorizationLevel === 'ROLE_VOLUNTEER' ||
        checkAuthorizationLevel === 'ROLE_ADMIN'
      "
    ></volunteer-panel>
    <button
      class="displayForm"
      v-if="
        checkAuthorizationLevel === 'ROLE_VOLUNTEER' ||
        checkAuthorizationLevel === 'ROLE_ADMIN'
      "
      @click="showForm"
    >
      {{ isFormExtended ? "Hide Form" : "Add Pet" }}
    </button>
    <add-pet v-if="isFormExtended"></add-pet>
  </div>
</template>

<script>
import AdminPanel from "../components/AdminPanel.vue";
import VolunteerPanel from "../components/VolunteerPanel.vue";
import AddPet from "../components/AddPet.vue";

export default {
  data() {
    return {
      isFormExtended: false,
    };
  },

  components: { AdminPanel, VolunteerPanel, AddPet },

  computed: {
    checkAuthorizationLevel() {
      return this.$store.state.user.authorities[0].name;
    },
  },

  methods: {
    showForm() {
      this.isFormExtended = !this.isFormExtended;
    },
  },
};
</script>

<style>
.displayForm {
  display: block;
  background-color: #ff8ba7;
  border: 2px solid transparent;
  width: 50%;
  margin: 2rem auto;
  color: #fffffe;
  font-family: inherit;
  padding: 0.35rem 0.75rem;
  border-radius: 8px;
  letter-spacing: 4px;
  cursor: pointer;
}
.displayForm:hover {
  background-color: #ffc6c7;
}
</style>