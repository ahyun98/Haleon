<template>
<div class = "comp">
    <h2>Videos</h2>
  <div class = "movies">
      <div class = "movie">
          비디오가 들어갈 자리입니다
      </div>
      <div class = "movie">
          비디오가 들어갈 자리입니다
      </div><div class = "movie">
          비디오가 들어갈 자리입니다
      </div><div class = "movie">
          비디오가 들어갈 자리입니다
      </div><div class = "movie">
          비디오가 들어갈 자리입니다
      </div><div class = "movie">
          비디오가 들어갈 자리입니다
      </div>
  </div>
</div>
</template>

<script>
export default {
    name: "MainVideos"
}
</script>

<style scoped>
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
        margin: 10px 40px;
        flex: 1 1 25%;
        height : 40%;
        background-color: rgb(126, 138, 138);
        color: white;
    }
</style>