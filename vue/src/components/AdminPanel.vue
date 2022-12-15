<template>
  <div>
    <h1 class="pending-title">Pending Volunteers</h1>
    <section
      class="section-pending"
      v-for="volunteer in pendingVolunteers"
      v-bind:key="volunteer.volunteerId"
    >
      <div v-if="!isApproved" class="pending-card">
        <!-- <h2>{{volunteer.volunteerId}}</h2> -->
        <h2>{{ volunteer.firstName }} {{ volunteer.lastName }}</h2>
        <p>{{ volunteer.address }}</p>
        <p>{{ volunteer.phoneNumber }}</p>
        <button
          class="btn-admin"
          type="submit"
          @click="approve(volunteer.volunteerId)"
        >
          Approve
        </button>
        <!-- todo make approval change user authorities -->
        <button
          class="btn-admin"
          type="submit"
          @click="reject(volunteer.volunteerId)"
        >
          Reject
        </button>
      </div>
    </section>
  </div>
</template>

<script>
import volunteerService from "@/services/VolunteerService.js";

export default {
  data() {
    return {
      pendingVolunteers: [],
      isApproved: false,
    };
  },
  methods: {
    getAllPendingVolunteers() {
      volunteerService.getPendingVolunteers().then((response) => {
        this.pendingVolunteers = response.data;
      });
    },

    approve(id) {
      volunteerService.approveVolunteerStatus(id).then((response) => {
        if (response.status === 201) {
          this.$router.push("/settings");
        }
        this.isApproved = true;
      });
    },
    reject(id) {
      volunteerService.rejectVolunteerStatus(id).then((response) => {
        if (response.status === 201) {
          this.$router.push("/settings");
        }
      });
    },
  },
  created() {
    this.getAllPendingVolunteers();
  },
};
</script>

<style>
.pending-title,
.volunteer-title {
  color: var(--clr-2);
  width: 90vw;
  max-width: 30rem;
  text-align: center;
  margin: 1.5rem auto;
}
.section-pending {
  display: flex;
  justify-content: center;
}
.pending-card {
  background-color: #fffffe;
  padding: 30px 40px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.26);
  border-radius: 8px;
  margin: 1rem auto;
}
.pending-card h2 {
  letter-spacing: 4px;
  margin-bottom: 10px;
  text-transform: capitalize;
  text-align: center;
}
.pending-card p {
  margin-bottom: 10px;
}
.pending-card .btn-admin {
  display: inline-block;
  margin: 10px 25px;
  background-color: #ff8ba7;
  color: #fffffe;
  padding: 0.25rem 0.75rem;
  font-family: inherit;
  letter-spacing: 2px;
  border: 2px solid transparent;
  border-radius: 8px;
  margin-bottom: 5px;
}
.pending-card .btn-admin:hover,
.btn-admin:active {
  background-color: #ffc6c7;
}
</style>

// --clr-1: #ff8ba7; // --clr-2: #3cf157; // --clr-3: #fbfbbb; #ffc6c7
