<template>

  <div id="volunteer" class="text-center">
      <div class="show form" v-if="checkToken">
    <form class="form-volunteer" @submit.prevent="save"  >
          <h1 class="h3 mb-3 font-weight-normal">Become A Volunteer</h1>
          <section class="sec-volunteer">
           <label for="address" class="volunteer">Address</label>
           <input type="text" v-model="volunteer.address">
           <label for="phone-number" class="volunteer">Phone Number</label>
           <input type="text" v-model="volunteer.phoneNumber">
           <div class="active">
           <label for="is-active" class="volunteer">Active</label>
           <input type="checkbox" v-model="volunteer.isActive"> <!-- when checked, isActive will be true -->
           </div>
           <button class="btn-volunteer" type="submit" v-bind="save">Volunteer</button>
       </section>
      </form>
      </div>
      <div>
          <router-link :to="{name: 'register'}" v-if="!checkToken">Please Register Before Volunteering</router-link>
      </div>
         
  </div>
</template>

<script>
 import volunteerService from '@/services/VolunteerService.js'
export default {
    data(){
       return {
           volunteer:{
               volunteerId:this.getUserId,
               address:'',
               phoneNumber:'',
               isActive:false,
               status:'Pending'
           }
    }
    },

    methods: {
        save() {
            this.volunteer.volunteerId = this.getUserId;

            volunteerService.addVolunteer(this.volunteer)
            .then (response => {
                if(response.status === 201) {
               this.$router.push('/');
                
            } 
            })    
        },

    },
    
    computed:{
        checkToken() {
            return this.$store.state.user.username != null;
        },

        getUserId() {
         return this.$store.state.user.id;
        },

    }


}
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
.text-center {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: start;
  background-color: #fffffe;
}
.form-volunteer {
  padding: 30px 40px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border: 10px solid #fffffe;
  border-radius: 8px;
  background-color: #fffffe;
}

.sec-volunteer {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
}
.volunteer {
     display: block;
     margin-top: 10px;
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