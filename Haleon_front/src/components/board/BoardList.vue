<template>
  <div class = "board">

    <div class="overflow-auto">

        <p class="mt-3" style="font-size:25px;">{{boardtitle}}</p>
        <div class = "infobox">
        <span class="mt-3">Current Page: {{ currentPage }}</span>
        <span class = "search"><input type = "text" id = "input" placeholder="search" v-model="keyword"><button id = "input" @click = "search"><img src = "@/assets/search.png" style="width:40px; height:40px; min-height:1px !important;"></button></span>
        </div>
        <b-table
        id="my-table"
        striped hover
        :items="boards"
        :per-page="perPage"
        :current-page="currentPage"
        :fields="fields"
        @row-clicked="goDetail"
        >
        <template #cell(#)="data">
            {{ data.index + 1 }}
          </template>

        

        </b-table>
        <button class = "insertformbtn" @click="insertform">글쓰기</button>
        <b-pagination
        align="center"
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="my-table"
        ></b-pagination>
    </div>

  </div>
</template>

<script>
import { mapState } from 'vuex'


export default {
    name: "BoardList",
    props:['boardtitle'],
    data() {
        
        return {
        perPage: 10,
        currentPage: 1,
        keyword: "",
        items: this.boards,
        index: 0,
        fields: ['#',{key:"title", label:'title'} ,{key:"writer", label:'writer'},'regDate','viewCnt'],
      }
    },
    computed: {
      rows() {
        return this.boards.length
      },
      ...mapState([
          "boards"
      ])
    },
    components: {
        
    },
    methods:{
        search(){
            const payload = {
                category : this.boardtitle,
                keyword : this.keyword
            }
            this.$store.dispatch('getBoards',payload)
        },
        goDetail(row) {
            console.log(row.num )
            this.$store.dispatch('BoardDetail',row.num)
        },
        insertform(){
            this.$store.dispatch("boardInsertForm")
        },
        count(value){
            console.log(value);
            console.log(this.index);
            this.index = this.index+1;
            return this.index
        },
        showRowInfo (event, { item } ) {
            console.log(item)
            this.editedIndex = this.items.indexOf(item)
            this.editedItem = Object.assign({}, item)
            console.log(this.editedIndex)
            console.log(this.editedItem)
        }
        

    },
    created(){
        const payload = {
            category:this.boardtitle,
            keyword : null
        }
        this.$store.dispatch('getBoards',payload)

    },
    watch: {
        boardtitle: function(){
            const payload = {
            category:this.boardtitle,
            keyword : null
            }
            this.$store.dispatch('getBoards',payload)
        }
    }
}

</script>

<style>
    @import url('https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz,wght@8..144,100&display=swap');

    .title{
        padding: 50px 0 0 0;
        text-align: center;
        color: white;
        font-size: 30px;
    }
    .overflow-auto{
        color: white !important;
        padding: 2% 10%;
    }

    .page-link{
        color: white !important;
        background-color: #131515 !important;
        
    }
    .page-link:active{
        color: aqua;
    }
    #my-table{
        color: white;
        margin-top: 15px;
        text-align: center;
    }
    .board{
        margin: 30px 0px 0px 0px;
        font-family: 'Roboto Flex', sans-serif !important;
        background-color: #131515;
        height : 2000px;
    }
    th{
        background-color: #00b99a;
        color: #131515;
    }
    .search{
        text-align: end;
        border: 1px solid #7DE2D1;
    }
    .infobox{
        display: flex;
        justify-content: space-between;
        align-items: flex-end;
    }
    input::-webkit-input-placeholder { color: white; font-size: 20px;}
    #input{
        padding: 5px 10px;
        background-color: #131515;
        border:0;
        color: white;
    }
    .btn-secondary{
        background-color: #131515 !important;
    }
    .btn-secondary:hover{
        background-color: #00b99a !important;
    }
    .insertformbtn{
        position: absolute;
        right: 10%;
        background-color: #7DE2D1;
        margin: 0px 5px 0px 0px;
        color: #131515;
        border-radius: 5px 5px 5px 5px;
        border-color: #7DE2D1;
        font-weight: bolder;
    }
    .b-table > tbody > tr:hover{
        color:#7DE2D1 !important;
        text-decoration-line: underline;
    }
</style>