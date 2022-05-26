<template>
    <div class = "developer">
        <h2 style = "margin:50px 0px;">DEVELOPER</h2>
        <div class = "flex">
            <div class = "info">
                <img class = "profileimg" src="@/assets/dohoon.jpg" alt="">
                <h2>Back-End</h2>
                <h4>김도훈</h4>
            </div>
            <div claff = "info">
                <img class = "profileimg" src="@/assets/ahyun.jpg" alt="">
                <h2>Front-End</h2>
                <h4>이아현</h4>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name : "AboutDeveloper"
}
</script>

<style scoped>
h4{
    font-weight: 200;
}

*{
  font-family: 'Roboto Flex', sans-serif;
}
.developer{
    display: flex;
    height: 80vh;
    background-color: #131515;
    flex-direction: column;
    justify-content: center ;
    color: white;
    text-align: center;
}
.profileimg{
        width: 23vw !important;
        max-height: 23vw !important;
        min-height: 23vw !important;
        object-fit: cover;
        border-radius: 70%;
        margin-bottom: 30px;
}
.flex{
    display: flex;
    justify-content: space-evenly;
    margin-bottom: 40px;
}
.info{
    width: 25vw;
}
</style>