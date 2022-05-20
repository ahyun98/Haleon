<template>
  <div class="home">
    <main-carousel></main-carousel>
    <main-about></main-about>
    <main-videos></main-videos>
  </div>
</template>

<script>
// @ is an alias to /src
import MainCarousel from '@/components/main/MainCarousel.vue'
import MainAbout from '@/components/main/MainAbout.vue'
import MainVideos from '../components/main/MainVideos.vue'


export default {
  name: 'HomeView',
  components: {
    MainCarousel,
    MainAbout,
    MainVideos,
  },

}

</script>

<style>

</style>
