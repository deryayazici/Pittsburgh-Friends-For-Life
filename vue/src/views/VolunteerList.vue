<template>
  <div id="volunteer" class="text-center">
      <form class="form-volunteer" @submit.prevent="volunteer">
          <h1 class="h3 mb-3 font-weight-normal">Become A Volunteer</h1>
          <section class="sec-volunteer">
           <label for="address" class="volunteer">Address</label>
           <input type="text">
           <label for="phone-number" class="volunteer">Phone Number</label>
           <input type="text">
           <label for="availabilityDate">Available Dates </label>
           <input type="date" id="date" name="date" class="volunteer">
           <select name="time" id="time" class="volunteer">
                <option value="morning">Morning</option>
                <option value="afternoon">Afternoon</option>
                <option value="Evening">Evening</option>
            </select>
           <div class="active">
           <label for="is-active" class="volunteer">Active</label>
           <input type="checkbox">
           </div>
           <button class="btn-volunteer" type="submit">Volunteer</button>
       </section>
      </form>
     
  </div>
</template>

<script>
// import volunteerService from '@/services/VolunteerService.js'
export default {

    data() {


    },

    method: {

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