<template>
  <div class = "JoinView">
      <user-join></user-join>
  </div>
</template>

<script>

import UserJoin from '@/components/User/UserJoin.vue'

export default {
    name : "JoinView",
    components: { 
        UserJoin 
    },

}
</script>

<style scoped>
    .JoinView{
        height: 82vh;
        background-color: #131515;
    }
</style>