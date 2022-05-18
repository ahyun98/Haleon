<template>
  <div class="home">
    <header-nav/>
  </div>
</template>

<script>
// @ is an alias to /src
import HeaderNav from '@/components/common/Header.vue'

export default {
  name: 'HomeView',
  components: {
    HeaderNav
  }
}
</script>
