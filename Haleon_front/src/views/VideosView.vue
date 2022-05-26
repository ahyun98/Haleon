<template>
    <div class = "boardcomp">
        <div class = "title">Video</div>
        <hr style="background-color : #7DE2D1; height:1px; margin: 3% 10%;">
        <div class = "btncontainer">
            <button class = "boardbtn" @click="changeboard('전체')" >전체</button>
            <button class = "boardbtn" @click="changeboard('상체 운동')" >상체 운동</button>
            <button class = "boardbtn" @click="changeboard('하체 운동')">하체 운동</button>
            <button class = "boardbtn" @click="changeboard('유산소 운동')" >유산소 운동</button>
            <button class = "boardbtn" @click="changeboard('필라테스')" >필라테스</button>
            <button class = "boardbtn" @click="changeboard('요가')" >요가</button>
            <button class = "boardbtn" @click="changeboard('Playlist')" >Playlist</button>
        </div>
        <h2>{{title}}</h2>
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
    name: "VideoList",
    data(){
        return{
            title : "전체",
        }
    },
    computed:{
    ...mapState([
      "videos"
    ])
    },
    created(){
        console.log(this.title)
      this.$store.dispatch('getVideos',this.title)
    },
    watch: {
          title: function(){
              this.$store.dispatch('getVideos',this.title)
          }
      },
      methods:{
          changeboard(title){
              this.title = title
              console.log(this.title)
          }
      }
}
</script>

<style scoped>
    .boardcomp{
        background-color: #131515;
        padding-top: 120px;
    }
    .btncontainer{
        display: flex;
        margin: 3% 10%;
    }
    .boardbtn{
        flex-grow : 1;
        background-color: #212323;
        color: white;
        padding: 20px 0px 20px 0px;
        border:0;
    }
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
        margin: 0% 10%;
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
    .link{
        text-decoration-color: #7DE2D1;
        color: white;
    }
</style>