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
export default {
  components: {
    HeaderNav,
    FooterComp,
    
  }
}
</script>

<style>

</style>
