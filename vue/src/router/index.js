import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Logout from "../views/Logout.vue";
import Register from "../views/Register.vue";
import store from "../store/index";
import AnimalDetails from "../views/AnimalDetails.vue";
import VolunteerList from "../views/VolunteerList.vue";
import AnimalAdopter from "../views/AnimalAdopter.vue";
import ShelterDonation from "../views/ShelterDonation.vue";
import UserPage from "../views/UserPage.vue";
import RandomCat from "../components/RandomCat.vue";

Vue.use(Router);

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/cat",
      name: "random-cat",
      component: RandomCat,
    },
    {
      path: "/donate",
      name: "donation",
      component: ShelterDonation,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/adopt",
      name: "adopt",
      component: AnimalAdopter,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/settings",
      name: "settings",
      component: UserPage,
    },
    {
      path: "/volunteer",
      name: "volunteer",
      component: VolunteerList,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/animals/:animalId",
      name: "animal-details",
      component: AnimalDetails,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/",
      name: "home",
      component: Home,

      meta: {
        requiresAuth: false, // set initially as true
      },
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false,
      },
    },
  ],
});

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some((x) => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === "") {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
