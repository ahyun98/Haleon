<template>
<div style="background-color:#131515">
  <div class = "insertform">
      <div>
      <hr>
      <div class="banner">💌 게시글 작성</div>
      </div>
      <div class = "insertinput">
      <div>
      <span>제목 : </span><input class = "titlef" type = "text" v-model="title">
          </div>
          <div>
      <span>카테고리 : </span><select class = "category" name="category" v-model="category">
        <option disabled value="">--Category--</option>
        <option value="자유">자유</option>
        <option value="Routine 공유">Routine 공유</option>
        <option value="Tip 공유" selected="selected">Tip 공유</option>
        </select>
              </div>    
      </div>
      <textarea class = "content" v-model="content" placeholder="내용을 입력하세요"></textarea>
      <button class = "insertbtn" @click="createBoard">등록</button>
  </div>
</div>
</template>

<script>
export default {
    name: "BoardinsertView",
    data(){
        return{
            title:"",
            category:"",
            content:"",
            writer:""
        }
    },
    methods:{
        createBoard(){
            const id = sessionStorage.getItem("id");
            let newBoard = {
                category : this.category,
                title : this.title,
                writer : id,
                content : this.content,
            }
            this.$store.dispatch('createBoard', newBoard);
        }
    }
}
</script>

<style scoped>
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
.content{
    width: 100%;
    height: 70%;
    background-color: #131515;
    border: 1px solid #7DE2D1;
    color: white;
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