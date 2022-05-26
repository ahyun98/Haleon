<template>
    <div class = "boardcomp">
        <div class = "title">Workout</div>
        <hr style="background-color : #7DE2D1; height:1px; margin: 3% 30%;">

        <exercise-list></exercise-list>
    </div>
</template>

<script>

import ExerciseList from '../components/exercise/ExerciseList.vue'
export default {
    data(){
        return{
            title : "공지사항",
        }
    },
    components: { ExerciseList },
    methods: {
        changeboard(title){
            this.title = title
            console.log(this.title)
        }
    }
}
</script>

<style scoped>
    .boardcomp{
        background-color: #131515;
        padding-top: 120px;
    }
    .btncontainer{
        display: flex;
        margin: 3% 10%;
    }
    .boardbtn{
        flex-grow : 1;
        background-color: #212323;
        color: white;
        padding: 20px 0px 20px 0px;
        border:0;
    }
</style>