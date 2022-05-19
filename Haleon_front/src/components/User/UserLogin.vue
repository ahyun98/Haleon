<template>
  <div class = "login">

        <h3>Login</h3>
        <span id = "input">
        <input type = "text" placeholder="ID"/>
        </span>
        <span id = "input">
        <input type = "text" placeholder="Password"/>
        </span>
        <button class = "loginbtn">Login</button>
        <div style = "display : flex; justify-content:space-evenly;">
        <span><router-link to="/join"> Join </router-link></span>
        
        <span><router-link to="#">SearchID</router-link></span>
        </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz,wght@8..144&display=swap');
*{
  font-family: 'Roboto Flex', sans-serif;
}
.login{
    display: flex;
    position: absolute;
    left: 35%;
    top: 30%;
    width: 30%;
    height: 40%;
    background-color: #212323;
    text-align: center;
    color: white;
    padding: 0px 7% 30px 7%;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
}
#input{
    display: flex;
    border: 2px solid #7DE2D1;
    background-color: #212323;
    width: 80%;
}
input{
    width: 100%;
    background-color: #212323;
    border: 0;
}
a{
    color: white;
    text-decoration-line: none;
    margin: 0px 30px;
}
a:hover{
    color: white;
}
input::-webkit-input-placeholder { color: white; font-size: 15px;}
.loginbtn{
    background-color: #7DE2D1;
    padding: 5px 5px;
    width: 30%;
    font-weight: bold;
    border-color: #7DE2D1;
}
</style>