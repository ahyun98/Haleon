<template>
<div class = "comp">
    <h2>Videos</h2>
  <div class = "movies">  
      <div class = "movie" v-for="(video,index) in videos" :key = index>
          <iframe style = "width : 80%; height: 80%" :src = "`https://www.youtube.com/embed/${video.id.videoId}`" frameborder=0></iframe>
            <div class = "movieinfo">
                <div style = "height: 45px; overflow:hidden; margin-top: 8px;">
                    <router-link :to="`/videoDetail/${video.id.videoId}`" class = "link">
                        {{video.snippet.title}}
                    </router-link>
                </div>
                <div style = "margin-top:5px; font-size:13px;">
                {{video.snippet.channelTitle}}

                </div>
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
  methods:{
  }
}
</script>

<style scoped>
    
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
        flex-direction: column;
        align-items: center;
    }
    .movieinfo{
        margin-top: 1%;
        width: 70%;
    }
    .link{
        text-decoration-color: #7DE2D1;
        color: white;
    }
</style>