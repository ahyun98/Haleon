<template>
<div class = "JoinView">

  <div class = "join">
        <h3>Exercise Edit</h3>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Height</span>
            <input type = "text" v-model = "height" required/>cm
        </span>

        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Weight</span>
            <input type = "text" v-model = "weight" required/>kg
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">체지방률</span>
            <input type = "text" v-model = "fatRate" required/>%
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">근육량</span>
            <input type = "text" v-model = "muscleRate" required/>kg
        </span>
        <button class = "joinbtn" @click="profileEdit" style = "color:black">수정</button>
  </div>
</div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name: "UserJoin",
    data(){
        return{
            height : "",
            weight : "",
            fatRate : "",
            muscleRate:"",
        }
    },
    computed:{
        ...mapState([
            "profile",
        ])
    },
    created(){
        const id = sessionStorage.getItem("id");
        const payload = {
            id: id,
        }
        this.$store.dispatch("getProfile",payload)
        this.height = this.profile.height
        this.weight = this.profile.weight
        this.fatRate = this.profile.fatRate
        this.muscleRate = this.profile.muscleRate
    },
    methods:{
        profileEdit(){
            const id = sessionStorage.getItem("id");
            const bmi = Math.round((this.weight/this.height/this.height)*10000);
            const payload = {
                id: id,
                height: this.height,
                weight: this.weight,
                bmi : bmi,
                fatRate: this.fatRate,
                muscleRate: this.muscleRate,
            }
            this.$store.dispatch("profileEdit",payload);
        }
        
    }
}
</script>

<style scoped>

*{
  font-family: 'Roboto Flex', sans-serif;
  color: white;
}
.JoinView{
        height: 82vh;
        background-color: #131515;
    }
.join{
    position: absolute;
    left: 30%;
    top: 15%;
    width: 40%;
    height: 60%;
    background-color: #212323;
    text-align: center;
    color: white;
    padding: 30px 7% 30px 7%;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
}

.input{
    display: flex;
    color: white;
    background-color: #212323;
    width: 80%;
    align-items: center;
    
}
input{
    
    width: 50%;
    left: 50%;
    background-color: #212323;
    padding: 4px 10px;
    border: 2px solid #7DE2D1;
    color: white;
    flex-shrink: 0;
    margin-right: 10px;
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
.joinbtn{
    background-color: #7DE2D1;
    padding: 5px 5px;
    width: 30%;
    font-weight: bold;
    border-color: #7DE2D1;
}
:root{
    --form-color: #7DE2D1;
}
input{
    accent-color:var(--form-color);
}
</style>