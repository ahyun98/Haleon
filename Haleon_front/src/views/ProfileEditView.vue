<template>
  <div class = "login">

        <h3>Login</h3>

            <span class = "id" id = "input" style = "margin: 5px 5px;">
            <input type = "text" placeholder="ID" v-model ="id" required />
            </span>
            <span id = "input" style = "margin: 5px 5px;">
            <input type = "password" placeholder="Password" v-model ="pw" required />
            </span>
            <button class = "loginbtn" @click="Login" style = "margin: 5px 5px;">Login</button>
      
        <div style = "display : flex; justify-content:space-evenly;">
        <span><router-link to="/join"> Join </router-link></span>
        
        <span><router-link to="#">SearchID</router-link></span>
        </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name : "UserLogin",
    data(){
        return{
            id : this.profile.id,
            period : this.profile.period,
            height : this.profile.height,
            weight : this.profile.weight,
            bmi : this.profile.bmi,
            fat_rate : this.profile.fat_rate,
            muscle_rate : this.profile.muscle_rate,
        }
    },
    computed:{
        ...mapState([
            "profile"
        ])
    },
    methods:{
        Login(){
            if (this.id=="" || this.pw==""){
                alert("내용을 입력해주세요");
                return;
            }
            const user = {
                id: this.id,
                pw: this.pw,
            }
            this.$store.dispatch('userLogin', user)
        }
    },
    create(){
        const id = sessionStorage.getItem("id");
        this.$store.dispatch('getProfile',id);
    }
}
</script>

<style scoped>
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
}
input{
    color: white;
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