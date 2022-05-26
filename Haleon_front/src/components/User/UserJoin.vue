<template>
  <div class = "join">
        <h3>Join</h3>



        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">ID</span>
            <input type = "text" v-model = "id" required/>
            <button class = "joinbtn" style = "margin-left : 3px; width : 80%; padding : 5px 0px; font-size: 13px; height: 35px; border:0; color:black;" @click="idcheck">중복체크</button>
        </span>

        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Password</span>
            <input type = "text" v-model = "pw" required/>
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Name</span>
            <input type = "text" v-model = "name" required/>
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">NickName</span>
            <input type = "text" v-model = "nickname" required/>
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Gender</span>
            
            <input type="radio" id = "man" name="chk_info" value="man" style = "width : 5%" v-model = "gender"><label for = "man">남</label>
            <input type="radio" id = "woman" name="chk_info" value="woman" style = "margin-left : 10%; width : 5%" v-model = "gender" required><label for = "woman">여</label>

        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Age</span>
            <input type = "text" placeholder="ex ) 25" v-model = "age" required/> <span style = "margin-left : 10px">세</span>
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Height</span>
            <input type = "text" placeholder="ex ) 170" v-model = "height" required/> <span style = "margin-left : 10px">cm</span>
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Weight</span>
            <input type = "text" placeholder="ex ) 65" v-model = "weight" required/> <span style = "margin-left : 10px">kg</span>
        </span>
        <button class = "joinbtn" @click="join" style = "color:black">Join</button>
  </div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name: "UserJoin",
    data(){
        return{
            id: "",
            pw: "",
            name: "",
            nickname: "",
            gender: "",
            age: "",
            height: "",
            weight: ""
        }
    },
    computed:{
        ...mapState([
            "ischeck",
        ])
    },
    methods:{
        join(){
             if (this.id=="" || this.pw=="" || this.name=="" || this.nickname =="" || this.gender=="" || this.age=="" || this.height=="" || this.weight==""){
                alert("내용을 입력해주세요");
                return;
            }
            if(!this.ischeck){
                alert("중복체크 먼저해");
                return;
            }
            
            let user = {
                id : this.id,
                pw : this.pw,
                username : this.name,
                gender : this.gender
            }
            
            this.$store.dispatch("UserJoin",user);
            const bmi = Math.round((this.weight/this.height/this.height)*10000);
            console.log(bmi);
            let profile = {
                id : this.id,
                height : this.height,
                weight : this.weight,
                bmi : bmi,
            };
            this.$store.dispatch("insertProfile",profile);
        },
        idcheck(){
            this.$store.dispatch("idCheck",this.id);
        }
    }
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz,wght@8..144&display=swap');
*{
  font-family: 'Roboto Flex', sans-serif;
  color: white;
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