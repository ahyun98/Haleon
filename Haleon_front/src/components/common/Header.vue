<template>
  <div>
    <b-navbar toggleable="lg" type = "dark" style="background-color : #131513; height : 8vh;">
      <b-navbar-brand to="/" style="font-size : 30px; color :#7DE2D1; margin-top : 22px;">Haleon</b-navbar-brand>

      <b-navbar-toggle target="nav-collapse" ></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav style="margin-top : 30px;" >
          <b-nav-item to="/about">About</b-nav-item>
          <b-nav-item to="/videos">Videos</b-nav-item>
          <b-nav-item href="/ranking">Ranking</b-nav-item>
          <b-nav-item href="/board">Board</b-nav-item>
          <b-nav-item href="/map">GYM</b-nav-item>
          <b-nav-item href="/workout">Work-out</b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-navbar-nav style="margin-top : 30px">
            <div v-if="id==null && !LoginCheck">
              <b-nav-item href="/login">Log In</b-nav-item>
            </div>
            <div v-else style = "display:flex; justify-content:space-around;">
              <b-nav-item href="/workout">{{id}}님 반갑습니다.</b-nav-item>
              <b-nav-item @click = "logout">Log Out</b-nav-item>
            </div>

          </b-navbar-nav>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
  name: "HeaderView",
  data(){
    return{
      isclick:false,
      id:""
    }
  },
  computed:{
    ...mapState([
          "LoginCheck"
      ])
  },
  methods: {
    click(){
      this.isclick = !this.isclick
    },
    logout(){
      sessionStorage.removeItem("access-token");
      sessionStorage.removeItem("id");
      this.id=null;
      this.$router.go();
    }
  },
  created(){
    this.id=sessionStorage.getItem("id")
  },
  beforeUpdate(){
    this.id=sessionStorage.getItem("id")
  }
};
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz,wght@8..144&display=swap');
*{
  font-family: 'Roboto Flex', sans-serif;
}
hay{
  vertical-align: bottom;
  color: white;
}
.nav-link{
  color: white !important;
}

.nav-link:hover{
  color:#7DE2D1 !important; 
}

.click{
  color:#7DE2D1 !important;
}


</style>
