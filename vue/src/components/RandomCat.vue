<template>
  <div>
    <p class="cat-fact">{{ cat }}</p>
  </div>
</template>

<script>
import catService from "@/services/catService.js";
export default {
  name: "random-cat",
  data() {
    return {
      cat: "",
    };
  },
  methods: {},
  created() {
    catService.getCat().then((resp) => {
      console.log(resp.data);
      this.cat = resp.data.data[0];

      //this.cat = resp.data;
    });
  },
};
</script>

<style>
.cat-fact {
  text-align: center;
  font-size: 12px;
  color: #3cf157;
  margin-bottom: 2rem;
}
</style>
