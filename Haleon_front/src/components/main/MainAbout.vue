<template>
<div>

  <div id = "aboutcomp">
        <img  src = "@/assets/carousel/about3.jpg">
        <div class = "about">
            <br><br><br><br><br><br>
            <h3>About</h3><br>
            <p >Haleon은 건강함과 힘을 뜻하는 것으로,</p>
            <p >건강함 (in Good Health)을 의미하는</p>
            <p >고대 영어의 ‘Hale’과 힘(Strength)과 연관되는</p>
            <p >그리스어의 ‘Leon’ 으로 이루어진 말입니다.</p>
            <p >우리를 통해 건강함을 유지하길 바라는 마음으로 만들어졌습니다.</p>
            <br><br><br><br><br><br>
        </div>
  </div>

</div>
</template>

<script>
export default {
    name: "MainAbout"
}

</script>

<style scoped>
.profileimg{
        width: 12vw !important;
        max-height: 12vw !important;
        min-height: 12vw !important;
        object-fit: cover;
        border-radius: 70%;
        margin-right: 40px;
}
.flex{
    display: flex;
    justify-content: space-around;
}
.developer{
    background-color: #131513;
    color: white;
}
#aboutcomp{
    margin: 30px 0px;
    border: 0;
    padding: 0;
    display:flex;
    justify-content: space-between;
}
img{
    min-height: 553px;
    max-height: 553px;
    max-width: 40%;
}
.about{
    text-align: center;
    align-self: center;
    width: 57%;
    background-color: #131513;
    color: white;
    font-family: 'Roboto Flex', sans-serif;
}

</style>