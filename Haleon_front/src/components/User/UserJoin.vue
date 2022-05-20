<template>
  <div class = "join">
        <h3>Join</h3>



        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">ID</span>
            <input type = "text"/>
            <button class = "joinbtn" style = "margin-left : 3px; width : 15%; padding : 5px 0px; font-size: 13px; height: 35px; border:0;">중복체크</button>
        </span>

        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Password</span>
            <input type = "text"/>
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">NickName</span>
            <input type = "text" />
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Gender</span>
            
            <input type="radio" id = "man" name="chk_info" value="man" style = "width : 5%"><label for = "man">남</label>
            <input type="radio" id = "woman" name="chk_info" value="woman" style = "margin-left : 10%; width : 5%"><label for = "woman">여</label>

        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Age</span>
            <input type = "text" placeholder="ex ) 25"/> <span style = "margin-left : 10px">세</span>
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Height</span>
            <input type = "text" placeholder="ex ) 170"/> <span style = "margin-left : 10px">cm</span>
        </span>
        <span class = "input">
            <span style = "margin-right:10%; flex-basis: 100px;">Weight</span>
            <input type = "text" placeholder="ex ) 65"/> <span style = "margin-left : 10px">kg</span>
        </span>
        <button class = "joinbtn">Join</button>


  </div>
</template>

<script>
export default {
    name: "UserJoin"
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz,wght@8..144&display=swap');
*{
  font-family: 'Roboto Flex', sans-serif;
}
.join{
    display: flex;
    position: absolute;
    left: 30%;
    top: 15%;
    width: 40%;
    height: 60%;
    background-color: #212323;
    text-align: center;
    color: white;
    padding: 0px 7% 30px 7%;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
}
.input{
    display: flex;
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