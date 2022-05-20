<template>
  <div class = "LoginView">

      <user-login></user-login>
  </div>
</template>

<script>

import UserLogin from '../components/User/UserLogin.vue'

export default {
    name : "LoginView",
    components: { 
        UserLogin 
    },

}
</script>

<style scoped>
    .LoginView{
        height: 82vh;
        background-color: #131515;
    }
</style>