<template>
    <div style="background-color:#131515">
    <div class = "insertform">
        <div>
        <hr>
        <div class="banner">💌 게시글</div>
        </div>
        <div class = "insertinput">
            <div>
                <span>writer : {{board.writer}}</span>
            </div>
            <div>
                <span>제목 : </span>{{board.title}}
            </div>
            <div>
                <span>등록일 : </span>{{board.regDate}}
            </div>
        </div>
        <div class = "boardcontent">
            {{board.content}}
        </div>
        
        <button class = "insertbtn" @click = "boardlist">목록</button>
    </div>
    </div>
</template>

<script>
import { mapState } from 'vuex'
export default {
    computed: {
      ...mapState([
          "board",
          "isLogin"
      ])
    },
    methods:{
        boardlist(){
            this.$router.push({name : 'board'})
        }
    }
}
</script>

<style>
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
}
.boardcontent{
    width: 100%;
    height: 70%;
    background-color: #131515;
    border: 1px solid #7DE2D1;
    color: white;
    padding: 2%;
}
.insertbtn{
    width: 5%;
    align-self: center;
        background-color: #7DE2D1;
        margin: 0px 5px 0px 0px;
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