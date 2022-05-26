<template>
<div>
  <b-carousel
    id="carousel-fade"
    style="text-shadow: 0px 0px 2px #000"
    fade
    indicators
    min-height="200px"
    max-height = "504px"
  >
    <b-carousel-slide
      :img-src="carousel3"
    ><h1 style="vertical-align:center;">HALEON</h1></b-carousel-slide>
    <b-carousel-slide
      :img-src="carousel2"
    ><h1 style="vertical-align:center;">HALEON</h1></b-carousel-slide>
    <b-carousel-slide
      :img-src="carousel1"
    >   <h1 style="vertical-align:center;">HALEON</h1>
    </b-carousel-slide>
    </b-carousel>
</div>
  
</template>

<script>
  
  export default {
    name : 'MainCarousel',
    data() {
      return {
        //slide: 0,
        sliding: null,
        carousel1:require("@/assets/carousel/carousel1.jpg"),
        carousel2:require("@/assets/carousel/carousel2.jpg"),
        carousel3:require("@/assets/carousel/carousel3.jpg"),
      }
    },
    methods: {
        /*
      onSlideStart(slide) {
        this.sliding = true
      },
      onSlideEnd(slide) {
        this.sliding = false
      }*/
    }
  };
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Oswald:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lora:ital,wght@1,500&display=swap');

img{
    max-height: 700px !important;
    min-height: 700px;
    object-fit: cover;
}
h1{
   position: relative;
   padding-bottom: 17%;
   font-family: 'Oswald', sans-serif;
   font-size: 100px !important;
   color: #7DE2D1;
   -webkit-text-stroke-width: 2px;
	-webkit-text-stroke-color: #131513
}
</style>