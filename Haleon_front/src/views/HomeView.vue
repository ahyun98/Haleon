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
  }
}


      const saTriggerMargin = 300;
      const saElementList = document.querySelectorAll('.sa');

      const saFunc = function() {
        for (const element of saElementList) {
          if (!element.classList.contains('show')) {
            if (window.innerHeight > element.getBoundingClientRect().top + saTriggerMargin) {
              element.classList.add('show');
            }
          }
        }
      }

      window.addEventListener('load', saFunc);
      window.addEventListener('scroll', saFunc);
</script>

<style>
      .sa {
        opacity: 0;
        transition: all .5s ease;
      }

      /* 아래에서 위로 페이드 인 */
      .sa-up {
        transform: translate(0, 100px);
      }

    .sa.show {
        opacity: 1;
        transform: none;
      }
</style>
