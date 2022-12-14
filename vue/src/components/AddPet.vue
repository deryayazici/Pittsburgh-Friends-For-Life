<template>
  
       <div id="add-pet" class="text-center">
           <!-- <button class="add-pet-form" @click="showForm" >Add Pet</button> -->
          <!-- <add-pet v-if="isFormExtended"></add-pet> -->
    <form class="form-pet" @submit.prevent="save">
      <h1 class="h3 mb-3 font-weight-normal">Fill the Questionnaire</h1>
      <section class="sec-pet">
        <label for="type" class="pet">Type</label>
        <input type="text" v-model="animal.type" />
        <label for="breed" class="pet">Breed</label>
        <input type="text" v-model="animal.breed" />
        <label for="age" class="pet">Age
          </label >
        <input type="number" v-model="animal.age" />
        <label for="size" class="pet">Size</label>
        <input type="text" v-model="animal.size" />
        <label for="temperament" class="pet">Temperament</label>
        <input type="text" v-model="animal.temperament" />
        <label for="name" class="pet"> Name</label>
        <input type="text" v-model="animal.name" />
        <label for="special-needs" class="pet"
          >Special Needs</label
        >
        <input type="checkbox" v-model="animal.specialNeeds" />
        <label for="photo">Add photo</label>
        <input type="text" v-model="animal.vet" />
        <label for="vet">Vet</label>
        <input type="text" v-model="animal.photo">
        <button class="btn-pet" type="submit" >Submit</button>
      </section>    
    </form>
    
 
  </div>
 
</template>

<script>

import animalService from '@/services/AnimalService.js';
export default {
    data() {
  return {
    
   
    isFormExtended: false,
    // approvedVolunteer:[],
    animal: {
        type: "",
        breed: "",
        age: 0,
        size: "",
        temperament: "",
        name: "",
        specialNeeds: false,
        photo: "",
        vet: "",
        disabled: false,
        isAdopted:false

      },
       }
},
methods: {
    save() {
     animalService.addAdoptableAnimal(this.animal)
      .then (response => {
       if(response.status === 201) {
      this.$router.push('/');
                  
      } 
     }) 

    },
  },
   showForm() {
      this.isFormExtended = !this.isFormExtended;
    },


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
.form-pet {
  padding: 30px 40px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border: 10px solid #fffffe;
  border-radius: 8px;
  background-color: #fffffe;
}

.sec-pet {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}
.pet {
  display: block;
  margin-top: 10px;
}

.btn-pet {
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