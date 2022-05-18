<template>
  <header>
      <div>
        <div class = "logo">Heleon</div>
        <nav>
          <div class="container">
              <ul>
                  <li><a href ="#">Home</a></li>
                  <li><a to ="#">About</a></li>
                  <li><a to ="#">Videos</a></li>
                  <li><a to ="#">Ranking</a></li>
                  <li><a to ="#">Board</a></li>
                  <li><a to ="#">GYM</a></li>
                  <li><a to ="#">Work-out</a></li>
              </ul>
              <a to="/login">Login</a>
          </div>
        </nav>
      </div>
  </header>
</template>

<script>
export default {
  name: "HeaderView"
};
</script>

<style scoped>
#{
    
}
header{
    background-color: #131515;
    height : 100px;
    
}

.logo{
    text-align: end;
    text-shadow: -1px 0 rgb(110, 104, 104), 0 1px rgb(110, 104, 104), 1px 0 rgb(110, 104, 104), 0 -1px rgb(110, 104, 104);
    color: #7DE2D1;
    font-size: 35px;
    margin-right: 30px;
}

li{
    color:white
}

.container{
    justify-content: space-between;
}
</style>
