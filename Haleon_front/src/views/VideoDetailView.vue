<template>
<div style = "background-color:#131515;  height: auto; width: 100%; min-height:85vh;">
        <h2>Videos</h2>
  <div style = "display: flex; justify-content:center; align-items: center;">
        <iframe style = "min-width:854px; min-height:480px; " :src = "`https://www.youtube.com/embed/${videoId}`" frameborder=0></iframe>
  </div>
</div>
</template>

<script>
export default {
    name: "VideoDetail",
    data(){
        return{
            videoId:"",

        }
    },
    created(){
        const path = this.$route.path
        const pathsplit = path.split('/')
        const videoid = pathsplit[pathsplit.length-1]
        this.videoId = videoid

        const payload = {
            id : sessionStorage.getItem("id"),
            videoId : this.videoId,
        }
        this.$store.dispatch("addVideolog",payload)
    }
}
</script>

<style scoped>
*{
        font-family: 'Roboto Flex', sans-serif;
    }
h2{
        padding-top:50px;
        text-align: center;
        color: white;
    }
</style>