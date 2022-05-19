<template>
<div>
  <b-carousel
    id="carousel-fade"
    style="text-shadow: 0px 0px 2px #000"
    fade
    indicators
    min-height="200px"
  >
    <b-carousel-slide
      img-src="https://pixabay.com/get/gd770d108bce3cf089b42319b056a3bf913f9edb3335fc036ae22439563ae08220524c9bc82c2e40e6e9a36d797802a4aa41082a02b0250fa9bf732c50e9975d99a494d8d9108899a520120332f23ff16_1920.jpg"
    ><h1 style="vertical-align:center;">HALEON</h1></b-carousel-slide>
    <b-carousel-slide
      img-src="https://pixabay.com/get/gab793c06b7c8733356cd347b586444dd2b80a96ec89ca74cb92ed456813c61f797a61f4636682733f1f8be6d4d163dd1bfd7ff2798c29058933eae6fe3f593ceec47640df2bc859443257028ec8f5989_1920.jpg"
    >   <h1 style="vertical-align:center;">HALEON</h1>
    </b-carousel-slide>
    <b-carousel-slide
      img-src="https://pixabay.com/get/gef4d040b4fb5b9caa89f4cbc37e4dfabd77cce75689cac8f495147022ef73cdca8e5a11730431114624da3a3b3765d2ef935fb5e6add8585c10c70e89a6032b65fc0a2b8c36934b0ac66b13a9ef9fd2b_1920.jpg"
    ><h1 style="vertical-align:center;">HALEON</h1></b-carousel-slide>
  </b-carousel>
</div>
  
</template>

<script>
  export default {
    name : 'MainCarousel',
    data() {
      return {
        //slide: 0,
        sliding: null
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
  }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Oswald:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lora:ital,wght@1,500&display=swap');

img{
    max-height: 700px !important;
    min-height: 500px;
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