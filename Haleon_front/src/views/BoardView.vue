<template>
    <div class = "boardcomp">
        <div class = "title">Board</div>
        <hr style="background-color : #7DE2D1; height:1px; margin: 3% 10%;">
        <div class = "btncontainer">
            <button class = "boardbtn" @click="changeboard('공지사항')" >공지사항</button>
            <button class = "boardbtn" @click="changeboard('Routine 공유')">Routine 공유</button>
            <button class = "boardbtn" @click="changeboard('자유')" >자유</button>
            <button class = "boardbtn" @click="changeboard('Tip 공유')" >Tip 공유</button>
        </div>
        <board-list :boardtitle = title></board-list>
    </div>
</template>

<script>
import BoardList from '@/components/board/BoardList.vue'
export default {
    data(){
        return{
            title : "공지사항",
        }
    },
    components: { BoardList },
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