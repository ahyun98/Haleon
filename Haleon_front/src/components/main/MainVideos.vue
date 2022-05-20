<template>
<div class = "comp">
    <h2>Videos</h2>
  <div class = "movies">  
      <div class = "movie" v-for="(video,index) in videos" :key = index>
          <iframe style = "width : 80%; height: 80%" :src = "`https://www.youtube.com/embed/${video.id.videoId}`" frameborder=0></iframe>
            <div class = "movieinfo">
                {{video.snippet.title}}
            </div>
      </div>
  </div>
</div>
</template>

<script>
import {mapState} from 'vuex';
export default {
    name: "MainVideos",
    computed:{
    ...mapState([
      "videos"
    ])
  },
  created(){
    this.$store.dispatch('getVideos')
  },
}
</script>

<style scoped>
    @import url('https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz,wght@8..144&display=swap');
    *{
        font-family: 'Roboto Flex', sans-serif;
    }
    .comp{
        background-color: #131515;
        margin-bottom: 30px;
    }
    h2{
        padding-top:50px;
        text-align: center;
        color: white;
    }
    .movies{
        height: 800px;
        display: flex;
        justify-content: space-around;
        flex-wrap: wrap;
        align-content: space-evenly;
    }
    .movie{
        display: flex;
        margin: 10px 40px;
        flex: 1 1 25%;
        height : 40%;
        background-color: #131515;
        color: white;
        text-align: center;
        flex-direction: column;
        align-items: center;
    }
    .movieinfo{
        margin-top: 1%;
        width: 70%;
    }
</style>