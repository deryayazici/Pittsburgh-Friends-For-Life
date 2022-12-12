<template>
  <div id="questionnaire" class="text-center">
    <h2>Hello</h2>
    <form class="form-questionnaire" @submit.prevent="save">
      <h1 class="h3 mb-3 font-weight-normal">Fill the Questionnaire</h1>
      <section class="sec-questionnaire">
        <label for="first-name" class="questionnaire">First Name</label>
        <input type="text" v-model="questionnaire.firstName" />
        <label for="last-name" class="questionnaire">Last Name</label>
        <input type="text" v-model="questionnaire.lastName" />
        <label for="children-number" class="questionnaire"
          >Number of Children</label
        >
        <input type="number" v-model="questionnaire.numberChildren" />
        <label for="housing-type" class="questionnaire">Housing Type</label>
        <input type="text" v-model="questionnaire.housingType" />
        <label for="fenced-yard" class="questionnaire">Fenced Yard</label>
        <input type="checkbox" v-model="questionnaire.fencedYard" />
        <label for="walker" class="questionnaire"> Walker</label>
        <input type="text" v-model="questionnaire.walker" />
        <label for="pet-experience" class="questionnaire"
          >Years of Pet Experience</label
        >
        <input type="number" v-model="questionnaire.yearsOfPetExperience" />
        <label for="renting-or-owning">Are renting or owning</label>
        <select
          id="option"
          name="adopt"
          v-model="questionnaire.rentingOrOwning"
        >
          <option value="owning">Owning</option>
          <option value="renting">Renting</option>
        </select>
        <label for="vet" class="questionnaire">Your vet</label>
        <input type="text" v-model="questionnaire.vet" />
        <label for="disabled" class="questionnaire">Disabled</label>
        <input type="checkbox" v-model="questionnaire.disabled" />
        <label for="reference" class="questionnaire">First reference</label>
        <input type="text" v-model="questionnaire.referenceOne" />
        <label for="reference-contact" class="questionnaire"
          >First reference contact</label
        >
        <input type="text" v-model="questionnaire.referenceOneContact" />
        <label for="reference" class="questionnaire">Second reference</label>
        <input type="text" v-model="questionnaire.referenceTwo" />
        <label for="reference-contact" class="questionnaire"
          >Second reference contact</label
        >
        <input type="text" v-model="questionnaire.referenceOneContact" />
        <label for="phone-number" class="volunteer">Phone Number</label>
        <input type="text" v-model="questionnaire.phoneNumber" />
        <button class="btn-adopt" type="submit" @click.prevent="save">Submit</button>
      </section>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
     questionnaire: {
        questionnaire_id:0,
        firstName: "",
        lastName: "",
        numberChildren: 0,
        housingType: "",
        fencedYard: false,
        walker: "",
        yearsOfPetExperience: 0,
        rentingOrOwning: "",
        vet: "",
        disabled: false,
        animal_id: this.$router.animalId,
        adopter_id: this.$store.state.user.id,
        referenceOne: "",
        referenceOneContact: "",
        referenceTwo: "",
        referenceTwoContact: "",
        phoneNumber: "",
      },
    };
  },
  name: "adoption-questionnaire",
  methods: {
    save() {
      
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
.form-questionnaire {
  padding: 30px 40px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border: 10px solid #fffffe;
  border-radius: 8px;
  background-color: #fffffe;
}

.sec-questionnaire {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
}
.questionnaire {
  display: block;
  margin-top: 10px;
}

.btn-adopt {
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
