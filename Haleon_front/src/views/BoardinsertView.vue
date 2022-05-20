<template>
<div style="background-color:#131515">
  <div class = "insertform">
      <div>
      <hr>
      <div class="banner">💌 게시글 작성</div>
      </div>
      <div class = "insertinput">
      <div>
      제목 : <input class = "titlef" type = "text" v-model="title">
          </div>
          <div>
      카테고리 : <select class = "category" name="fruit">
        <option value="바나나">바나나</option>
        <option value="사과">사과</option>
        <option value="파인애플" selected="selected">파인애플</option>
        </select>
              </div>    
      </div>
      <textarea class = "content" v-model="content" placeholder="내용을 입력하세요"></textarea>
      <button class = "insertbtn" @click="insertform">글쓰기</button>
  </div>
</div>
</template>

<script>
export default {
    name: "BoardinsertView"
}
</script>

<style scoped>
.insertform{
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
    border: 1px solid #7DE2D1
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
</style>