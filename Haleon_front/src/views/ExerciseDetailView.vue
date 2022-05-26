<template>
    <div style="background-color:#131515">
    <div class = "insertform">
        <div>
        <hr>
        <div class="banner">🏋️‍♀️ {{exercise.regDate}}</div>
        </div>
        <div class = "boardcontent">
            <div class = "profile_2" style = "padding-top:60px; margin-bottom:40px;">
                <div style = "display: flex; justify-content:space-around; align-items:center;">
                    <p style = "font-size : 15px;">총 운동 시간</p>
                    <p style = "font-size : 20px;">{{workHour}}시간 {{workMinute}}분</p>
                    <div>
                        <p>섭취 Calories</p>
                        <p>Burn Calories</p>
                    </div>
                    <div>
                        <p>{{workout.cal}} cal</p>
                        <p>{{workout.burn}} cal</p>
                    </div>

                </div>
            </div>
            <hr>
             <div class = "profile_2" style = "margin-top:30px;">
                <div style = "display: flex; justify-content:space-around;">
                    <div  class = "exer">
                        <h4>Cardio</h4>
                        <div v-show="exercise.card1>0">싸이클 : {{exercise.card1}} set</div>
                        <div v-show="exercise.card2>0">트레드밀 : {{exercise.card2}} set</div>
                        <div v-show="exercise.card3>0">조깅 : {{exercise.card3}} set</div>
                        <div v-show="exercise.card4>0">요가 : {{exercise.card4}} set</div>
                        <div v-show="exercise.card5>0">필라테스 : {{exercise.card5}} set</div>
                    </div>
                    
                    <div  class = "exer">
                        <h4>하체</h4>
                        <div v-show="exercise.weight1>0">바벨 백스쿼트 : {{exercise.weight1}} set</div>
                        <div v-show="exercise.weight2>0">프론트 스쿼트 : {{exercise.weight2}} set</div>
                        <div v-show="exercise.weight3>0">레그 프레스 : {{exercise.weight3}} set</div>
                        <div v-show="exercise.weight4>0">레그 컬 : {{exercise.weight4}} set</div>
                        <div v-show="exercise.weight5>0">레그 익스텐션 : {{exercise.weight5}} set</div>
                        <div v-show="exercise.weight6>0">덤벨 런지 : {{exercise.weight6}} set</div>
                        <div v-show="exercise.weight7>0">데드 리프트 : {{exercise.weight7}} set</div>
                        <div v-show="exercise.weight8>0">이너 싸이 : {{exercise.weight8}} set</div>
                        <div v-show="exercise.weight9>0">힙 쓰러스트 : {{exercise.weight9}} set</div>
                    </div>
                    <div  class = "exer">
                        <h4>가슴</h4>
                        <div v-show="exercise.chest1>0"> 벤치프레스 : {{exercise.chest1}} set</div>
                        <div v-show="exercise.chest2>0"> 덤벨 플라이 : {{exercise.chest2}} set</div>
                        <div v-show="exercise.chest3>0"> 푸쉬업 : {{exercise.chest3}} set</div>
                        <div v-show="exercise.chest4>0"> 체스트 프레스 : {{exercise.chest4}} set</div>
                    </div>
                    <div  class = "exer">
                        <h4>등</h4>
                        <div v-show="exercise.back1>0">풀업 : {{exercise.back1}} set</div>
                        <div v-show="exercise.back2>0">덤벨 로우 : {{exercise.back2}} set</div>
                        <div v-show="exercise.back3>0">시티드 로우 : {{exercise.back3}} set</div>
                        <div v-show="exercise.back4>0">랫풀다운 : {{exercise.back4}} set</div>
                        <div v-show="exercise.back5>0">시티드 케이블 로우 : {{exercise.back5}} set</div>

                    </div>
                </div>
                <div style = "display: flex; justify-content:space-around; margin-top: 50px;">
                    <div  class = "exer">
                        <h4>어깨</h4>
                        <div v-show="exercise.shoul1>0">오버헤드 프레스 : {{exercise.shoul1}} set</div>
                        <div v-show="exercise.shoul2>0">덤벨 숄더 프레스 : {{exercise.shoul2}} set</div>
                        <div v-show="exercise.shoul3>0">덤벨 레터럴 레이즈 : {{exercise.shoul3}} set</div>
                        <div v-show="exercise.shoul4>0">덤벨 프론트 레이즈 : {{exercise.shoul4}} set</div>
                        <div v-show="exercise.shoul5>0">사이드 레터럴 레이즈 : {{exercise.shoul5}} set</div>
                        <div v-show="exercise.shoul6>0">바벨 업라이트 로우 : {{exercise.shoul6}} set</div>
                        <div v-show="exercise.shoul7>0">숄더 프레스 머신 : {{exercise.shoul7}} set</div>

                    </div>
                    <div  class = "exer">
                        <h4>팔</h4>
                        <div v-show="exercise.arm1>0">바벨컬 : {{exercise.arm1}} set</div>
                        <div v-show="exercise.arm2>0">덤벨 컬 : {{exercise.arm2}} set</div>
                        <div v-show="exercise.arm3>0">덤벨 킥백 : {{exercise.arm3}} set</div>
                        <div v-show="exercise.arm4>0">덤벨 삼두 익스텐션 : {{exercise.arm4}} set</div>
                        <div v-show="exercise.arm5>0">덤벨 리스트 컬 : {{exercise.arm5}} set</div>

                    </div>
                    <div class = "exer">
                        <h4 >복근</h4>
                        <div v-show="exercise.abs1>0">싯업 : {{exercise.abs1}} set</div>
                        <div v-show="exercise.abs2>0">레그 레이즈 : {{exercise.abs2}} set</div>
                        <div v-show="exercise.abs3>0">러시안 트위스트 : {{exercise.abs3}} set</div>
                        <div v-show="exercise.abs4>0">플랭크 : {{exercise.abs4}} set</div>
                        <div v-show="exercise.abs5>0">브이업 : {{exercise.abs5}} set</div>
                        <div v-show="exercise.abs6>0">크런치 : {{exercise.abs6}} set</div>
                        <div v-show="exercise.abs7>0">복근 크런치 머신 : {{exercise.abs7}} set</div>

                    </div>
                </div>
            </div>
        </div>
        
        <button class = "insertbtn" @click = "exerciselist">목록</button>
    </div>
    </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
    data(){
        return{
            workHour:"",
            workMinute:"",
        }
    },
    computed: {
      ...mapState([
          'exercise',
          'workout',
      ])
    },
    methods:{
        exerciselist(){
            this.$router.push({name : 'exerciselist'})
        }
    },
    created(){
    },
    updated(){
        this.workHour = parseInt(this.workout.workTime / 60);
        this.workMinute = this.workout.workTime-this.workHour*60;
    },
}
</script>

<style>
.exer{
     background-color:#212323; 
     padding: 10px; border-radius:3%;
     min-width: 150px;
     min-height: 150px;
     text-align: center;
}
.insertform{
    padding-top:40px;
    margin-left: 10vw;
    width: 80vw;
    height: 82vh;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    background-color: #131515;
}
hr{
    background-color: #7DE2D1;
    height: 3px;
    margin: 0;
}
.banner{
    width: 100%;
    padding-top: 15px;
    height: 50px;
    padding-left: 3%;
    background-color: #212323;
    color: white;
    margin-top:0px;
    margin-bottom: 20px;
}
.boardcontent{
    width: 100%;
    height: auto;
    background-color: #131515;
    border: 1px solid #7DE2D1;
    color: white;
    padding: 2%;
}
.insertbtn{
    width: 5%;
    align-self: center;
        background-color: #7DE2D1;
        margin: 10px 5px 0px 0px;
        color: #131515;
        border-radius: 5px 5px 5px 5px;
        border-color: #7DE2D1;
        font-weight: bolder;
    }
.insertinput{
    display: flex;
    justify-content: space-between;
    color: white;
    background-color: #131515;
}
.titlef{
    background-color: #131515;
    color: white;
    border: 1px solid #7DE2D1
}
.category{
    background-color: #131515;
    color: white;
}
span{
    padding: 0px 30px 0px 0px;
}

</style>