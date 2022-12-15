<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>

      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-row">
        <label for="username" class="sr-only">Username</label>
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
      </div>
      <div class="form-row">
        <label for="password" class="sr-only">Password</label>
        <input
          type="password"
          id="password"
          class="form-control"
          placeholder="Password"
          v-model="user.password"
          required
        />
      </div>
      <div class="form-row">
        <input
          type="password"
          id="confirmPassword"
          class="form-control"
          placeholder="Confirm Password"
          v-model="user.confirmPassword"
          required
        />
      </div>
      <router-link :to="{ name: 'login' }">Have an account?</router-link>

      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: "/login",
                query: { registration: "success" },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = "Bad Request: Validation Errors";
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
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
  --clr-3: #fbfbbb;
}

html {
  font-family: "Limelight", cursive;
  min-height: 100vh;
}
#register {
  /* background-color: #fbfbbb; */
  background-color: #545454;
}

.text-center {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: start;
}
.form-register,
.form-signin {
  padding: 30px 40px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.4);
  border: 2px solid #fffffe;
  border-radius: 8px;
  background-color: #fffffe;
}
.h3 {
  font-weight: 900;
  margin-bottom: 10px;
  letter-spacing: 4px;
  border-bottom: 2px solid var(--clr-1);
}

.sr-only,
.form-control {
  display: block;
  margin-bottom: 5px;
}

.form-control {
  width: 100%;
  margin-bottom: 20px;
  padding: 5px;
  border: 2px solid #ccc;
  border-radius: 8px;
}
input::placeholder {
  font-family: inherit;
}

.form-control:focus {
  outline: 0;
  border-color: var(--clr-1);
}

.btn,
.btn-signin {
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
.btn:hover,
.btn-signin:hover {
  background-color: #ffc6c7;
}

a {
  text-decoration: none;
  color: var(--clr-1);
}
a:visited {
  color: var(--clr-2);
}
</style>
