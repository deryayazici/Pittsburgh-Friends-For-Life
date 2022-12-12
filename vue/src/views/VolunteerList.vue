<template>
  <div id="volunteer" class="text-center">
    <!-- <label for="username">Username</label>
      <input type="text"> -->
    <div class="show form" v-if="checkToken">
      <form class="form-volunteer" @submit.prevent="save">
        <h1 class="h3 mb-3 font-weight-normal vol-title">Become A Volunteer</h1>
        <section class="sec-volunteer">
          <div class="form-row">
            <label for="first-name" class="firstName">First Name</label>
            <input
              class="form-control"
              type="text"
              v-model="volunteer.firstName"
            />
          </div>
          <div class="form-row">
            <label for="last-name" class="lastName">Last Name</label>
            <input
              class="form-control"
              type="text"
              v-model="volunteer.lastName"
            />
          </div>
          <div class="form-row">
            <label for="address" class="volunteer">Address</label>
            <input
              class="form-control"
              type="text"
              v-model="volunteer.address"
            />
          </div>
          <div class="form-row">
            <label for="phone-number" class="volunteer">Phone Number</label>
            <input
              class="form-control"
              type="text"
              v-model="volunteer.phoneNumber"
            />
          </div>

          <!-- <label for="availabilityDate">Available Dates </label>
           <input type="date" id="date" name="date" class="volunteer" v-> -->
          <!-- <select name="time" id="time" class="volunteer">
                <option value="morning">Morning</option>
                <option value="afternoon">Afternoon</option>
                <option value="Evening">Evening</option>
            </select> -->
          <div class="active">
            <div class="form-row">
              <label for="is-active" class="volunteer">Active</label>
              <input type="checkbox" v-model="volunteer.isActive" />
            </div>

            <!-- when checked, isActive will be true -->
          </div>
          <button class="btn-volunteer" type="submit" v-bind="save">
            Volunteer
          </button>
        </section>
      </form>
    </div>
    <div class="register-before">
      <router-link :to="{ name: 'register' }" v-if="!checkToken"
        >Please Register Before Volunteering</router-link
      >
    </div>
  </div>
</template>

<script>
import volunteerService from "@/services/VolunteerService.js";
export default {
  data() {
    return {
      volunteer: {
        volunteerId: this.getUserId,
        firstName: "",
        lastName: "",
        address: "",
        phoneNumber: "",
        isActive: false,
        status: "Pending",
      },
    };
  },

  methods: {
    save() {
      this.volunteer.volunteerId = this.getUserId;

      volunteerService.addVolunteer(this.volunteer).then((response) => {
        if (response.status === 201) {
          this.$router.push("/");
        }
      });
    },
  },

  computed: {
    checkToken() {
      return this.$store.state.user.username != null;
    },

    getUserId() {
      return this.$store.state.user.id;
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Limelight&display=swap");
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

:root {
  --clr-1: #ff8ba7;
  --clr-2: #3cf157;
}

html {
  font-family: "Limelight", cursive;
  min-height: 100vh;
}
.register-before {
  font-size: 1.5rem;
  padding: 0.5rem;
}

.text-center {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: start;
  background-color: #fbfbbb;
}
.form-volunteer {
  padding: 30px 40px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border: 10px solid #fffffe;
  border-radius: 8px;
  background-color: #fffffe;
}

.vol-title {
  margin-bottom: 30px;
}

.sec-volunteer {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}
.volunteer {
  display: block;
  margin-top: 10px;
  margin-bottom: 10px;
}

.btn-volunteer {
  margin-top: 1rem;
  display: block;
  width: 100%;
  border: 2px solid transparent;
  border-radius: 8px;
  padding: 5px;
  background-color: var(--clr-1);
  color: #fffffe;
  font-weight: bold;
  cursor: pointer;
}
</style>
