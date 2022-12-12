<template>
  <div>
    <div id="grossVanillaJS">
      <!--<img :src="cat" alt="" />-->
      {{ cat }}
    </div>
  </div>
</template>

<script>
import catService from "@/services/catService.js";
export default {
  name: "random-cat",
  data() {
    return {
      cats: [],
      cat: "",
    };
  },
  methods: {},
  created() {
    catService.getCat().then((resp) => {
      console.log(resp.data);
      this.cat = new Image(resp.data);

      //this.cat = resp.data;
    });
  },
};
</script>

<style></style>
