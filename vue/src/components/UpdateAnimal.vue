<template>
  <div>
      <form class="update-pet" @submit.prevent="update">
      <h1 class="h3 mb-3 font-weight-normal">Update {{this.animal.name}}</h1>
      <section class="sec-pet">
        <label for="type" class="pet">Type</label>
        <input type="text" v-model="updateAnimal.type" />

        <label for="breed" class="pet">Breed</label>
        <input type="text" v-model="updateAnimal.breed" />

        <label for="age" class="pet">Age</label>
        <input type="number" v-model="updateAnimal.age" />

        <label for="size" class="pet">Size</label>
        <input type="text" v-model="updateAnimal.size" />

        <label for="temperament" class="pet">Temperament</label>
        <input type="text" v-model="updateAnimal.temperament" />

        <label for="name" class="pet"> Name</label>
        <input type="text" v-model="updateAnimal.name" />

        <label for="special-needs" class="pet">Special Needs</label>
        <input type="checkbox" v-model="updateAnimal.specialNeeds" />

        <label for="photo">Add photo</label>
        <input type="text" v-model="updateAnimal.photo" />

        <label for="is-adopted" class="pet">Adopted?</label>
        <input type="checkbox" v-model="updateAnimal.isAdopted"/>

        <button class="btn-pet" type="submit">Submit</button>
      </section>
    </form>
  </div>
</template>

<script>
import animalService from "@/services/AnimalService.js";
export default {
  props: ["animal"],

  data() {
    return {
      updateAnimal: {
        animalId: this.$route.params.animalId,
        name: this.animal.name,
        type: this.animal.type,
        breed: this.animal.breed,
        age: this.animal.age,
        size: this.animal.size,
        temperament: this.animal.temperament,
        specialNeeds: this.animal.specialNeeds,
        photo: this.animal.photo,
        isAdopted: this.animal.isAdopted,
      },
    };
  },

  methods: {
    update() {
      animalService
        .updateAnimal(this.updateAnimal.animalId, this.updateAnimal)
        .then((response) => {
          if (response.status === 200) {
            this.$router.push("/");
          }
        });
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
.text-center {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: start;
  background-color: #fffffe;
}
.update-pet {
  padding: 30px 40px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border: 10px solid #fffffe;
  border-radius: 8px;
  background-color: #fffffe;
  width: 90vw;
  max-width: 600px;
  margin: 1rem auto;
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
  font-family: inherit;
  letter-spacing: 4px;
}
.btn-pet:hover {
  background-color: #ffc6c7;
}
</style>
