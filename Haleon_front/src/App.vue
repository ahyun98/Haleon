<template>
  <div id="app">
    <header-nav></header-nav>
    <router-view/>
    <footer-comp></footer-comp>
  </div>
</template>

<script>
import HeaderNav from '@/components/common/Header.vue'
import FooterComp from '@/components/common/Footer.vue'
import { mapState } from 'vuex'
export default {
  components: {
    HeaderNav,
    FooterComp,
    
  },
  computed:{
    ...mapState([
          "LoginCheck",
          "isLogin"
      ])
  },
}
</script>

<style>

</style>
