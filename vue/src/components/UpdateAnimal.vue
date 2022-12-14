<template>
  <div>
      <form class="update-pet" @submit.prevent="save">
      <h1 class="h3 mb-3 font-weight-normal">Update this animal</h1>
      <section class="sec-pet">
        <label for="type" class="pet">Type</label>
        <input type="text" v-model="updateAnimal.type" />
        <label for="breed" class="pet">Breed</label>

        <input type="text" v-model="updateAnimal.breed" />
        <label for="age" class="pet">Age</label >

        <input type="number" v-model="updateAnimal.age" />
        <label for="size" class="pet">Size</label>

        <input type="text" v-model="updateAnimal.size" />
        <label for="temperament" class="pet">Temperament</label>

        <input type="text" v-model="updateAnimal.temperament" />
        <label for="name" class="pet"> Name</label>

        <input type="text" v-model="updateAnimal.specialNeeds" />
        <label for="special-needs" class="pet">Special Needs</label>

        <input type="checkbox" v-model="updateAnimal.photo" />
        <label for="photo">Add photo</label>

        <input type="text" v-model="updateAnimal.photo">
        <button class="btn-pet" type="submit" >Submit</button>
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

            }
        }
    },

    methods: {
        
    }

}
</script>

<style>

</style>