<template>
<div class = "JoinView">

  <div class = "join">
        <h3>Workout Edit</h3>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Eat Calories</span>
            <input type = "text" v-model = "cal" required/> cal
        </span>

        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Burn Calories</span>
            <input type = "text" v-model = "burn" required/> cal
        </span>
        <span class = "input" style = "font-size:15px;">
            <span style = "margin-right:10%; flex-basis: 100px;">운동 시간</span>
            <b-form-select v-model="workHour" :options="Hours" style = "background-color : #212323; color: white; margin-right:10px; width:50px;">
                
            </b-form-select>시간
            <b-form-select v-model="workMinute" :options="Minutes" style = "background-color : #212323; color: white; margin-left:10px; width:80px; margin-right:10px;"></b-form-select> 분
        </span>
        <button class = "joinbtn" @click="workoutEdit" style = "color:black">수정</button>
  </div>
</div>
</template>

<script>
import { mapState } from 'vuex';
export default {
    name: "UserJoin",
    data(){
        return{
            cal : "",
            burn : "",
            workTime : "",
            workHour:"",
            workMinute:"",
            Hours:[
                { value: 1, text: '1' },
                { value: 2, text: '2 ' },
                { value: 3, text: '3 ' },
                { value: 4, text: '4 ' },
                { value: 5, text: '5 ' },
                { value: 6, text: '6 ' },
                { value: 7, text: '7 ' },
                { value: 8, text: '8 ' },

            ],
            Minutes:[
                { value: 5, text: '5 ' },
                { value: 10, text: '10 ' },
                { value: 15, text: '15 ' },
                { value: 20, text: '20 ' },
                { value: 25, text: '25 ' },
                { value: 30, text: '30 ' },
                { value: 35, text: '35 ' },
                { value: 40, text: '40 ' },
                { value: 45, text: '45 ' },
                { value: 50, text: '50 ' },
                { value: 55, text: '55 ' },
            ],
        }
    },
    computed:{
        ...mapState([
            "workout",
        ])
    },
    created(){
        const today = new Date();
        const id = sessionStorage.getItem("id");
        const todayformat =  today.getFullYear() + "-" + ((today.getMonth() + 1) > 9 ? (today.getMonth() + 1).toString() : "0" + (today.getMonth() + 1)) + "-" + (today.getDate() > 9 ? today.getDate().toString() : "0" + today.getDate().toString());
        const payload = {
            id: id,
            regDate: todayformat,
        }
        this.$store.dispatch("getWorkout",payload)
        this.cal = this.workout.cal
        this.burn = this.workout.burn
        this.workTime = this.workout.workTime
        this.workHour = parseInt(this.workout.workTime / 60);
        this.workMinute = this.workout.workTime-this.workHour*60;
    },
    methods:{
        workoutEdit(){
            const today = new Date();
            const id = sessionStorage.getItem("id");
            const todayformat =  today.getFullYear() + "-" + ((today.getMonth() + 1) > 9 ? (today.getMonth() + 1).toString() : "0" + (today.getMonth() + 1)) + "-" + (today.getDate() > 9 ? today.getDate().toString() : "0" + today.getDate().toString());
            const payload = {
                id: id,
                regDate: todayformat,
                cal : this.cal,
                burn : this.burn, 
                workTime : this.workHour*60+this.workMinute,
            }
            this.$store.dispatch("workoutEdit",payload);
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