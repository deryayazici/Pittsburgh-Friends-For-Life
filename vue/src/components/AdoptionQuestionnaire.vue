<template>
  <div id="questionnaire" class="text-center">
    <form class="form-questionnaire" @submit.prevent="save">
      <h1 class="h3 mb-3 font-weight-normal">Fill the Questionnaire</h1>
      <section class="sec-questionnaire">
        <label for="first-name" class="questionnaire">First Name</label>
        <input type="text" v-model="questionnaire.firstName" />
        <label for="last-name" class="questionnaire">Last Name</label>
        <input type="text" v-model="questionnaire.lastName" />
        <label for="phone-number" class="volunteer">Phone Number</label>
        <input type="text" v-model="questionnaire.phoneNumber" />
        <label for="children-number" class="questionnaire"
          >Number of Children</label
        >
        <input type="number" v-model="questionnaire.numberChildren" />
        <label for="housing-type" class="questionnaire">Housing Type</label>
        <input type="text" v-model="questionnaire.housingType" />
        <label for="fenced-yard" class="questionnaire">Please click the box if you have a fenced yard ?</label>
        <input type="checkbox" v-model="questionnaire.fencedYard" />
        <label for="walker" class="questionnaire"> Who is a Walker ?</label>
        <input type="text" v-model="questionnaire.walker" />
        <label for="pet-experience" class="questionnaire"
          >How many years of Pet Experience do you have?</label
        >
        <input type="number" v-model="questionnaire.yearsOfPetExperience" />
        <label for="renting-or-owning">Is your house renting or owning</label>
        <select
          id="option"
          name="adopt"
          v-model="questionnaire.rentingOrOwning"
        >
          <option value="owning">Owning</option>
          <option value="renting">Renting</option>
        </select>
        <label for="vet" class="questionnaire">Who is your vet?</label>
        <input type="text" v-model="questionnaire.vet" />
        <label for="disabled" class="questionnaire">Please click the box if you love disabled animal?</label>
        <input type="checkbox" v-model="questionnaire.disabled" />
        <h2>Please provide two reference</h2>
        <label for="referenceOne" class="questionnaire">Reference name</label>
        <input type="text" v-model="questionnaire.referenceOne" />
        <label for="reference-one-contact" class="questionnaire"
          >Reference contact</label
        >
        <input type="text" v-model="questionnaire.referenceOneContact" />
        <label for="referenceTwo" class="questionnaire">Reference name</label>
        <input type="text" v-model="questionnaire.referenceTwo" />
        <label for="reference-two-contact" class="questionnaire"
          >Reference contact</label
        >
        <input type="text" v-model="questionnaire.referenceTwoContact" />
        <label for="phone-number" class="volunteer">Phone Number</label>
        <input type="text" v-model="questionnaire.phoneNumber" />
        <button class="btn-adopt" type="submit">Submit</button>
      </section>
    </form>
  </div>
</template>

<script>
import adopterService from "@/services/AdopterService.js";
export default {
  data() {
    return {
      questionnaire: {
        questionnaire_id: 0,
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
        animal_id: this.$route.params.animalId,
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
      this.questionnaire.animal_id = this.$route.params.animalId;
      this.questionnaire.adopter_id = this.$store.state.user.id;
      adopterService.addQuestionnaire(this.questionnaire).then((response) => {
        if (response.status === 201) {
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
#questionnaire {
  background-color: #fbfbbb;
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
