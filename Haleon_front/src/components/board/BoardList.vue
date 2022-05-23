<template>
  <div class = "board">

    <div class="overflow-auto">

        <p class="mt-3" style="font-size:25px;">{{boardtitle}}</p>
        <div class = "infobox">
        <span class="mt-3">Current Page: {{ currentPage }}</span>
        <span class = "search"><input type = "text" id = "input" placeholder="search" v-model="keyword"><button id = "input"><img src = "@/assets/search.png" style="width:40px; height:40px; min-height:1px !important;"></button></span>
        </div>
        <b-table
        id="my-table"
        @row-clicked="goDetail"
        :items="boards"
        :per-page="perPage"
        :current-page="currentPage"
        :fields="fields"
        >
        <template #cell(detail)="row">
            <b-button size = "sm" @click = "row.toggleDetails" style="border:0;">자세히</b-button>
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
        perPage: 2,
        currentPage: 1,
        keyword: "",
        items: this.boards,
        fields: [{key: "num",
            label: '#',}, 'title', 'writer','regDate','viewCnt','detail'],
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
        myRowClickHandler(record, index) {
            // 'record' will be the row data from items
            // `index` will be the visible row number (available in the v-model 'shownItems')
            console.log(record); // This will be the item data for the row
            console.log(index);
        },
        insertform(){
            this.$router.push({name : 'boardinsert'})
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
    .insertfrombtn{
        position: absolute;
        right: 10%;
        background-color: #7DE2D1;
        margin: 0px 5px 0px 0px;
        color: #131515;
        border-radius: 5px 5px 5px 5px;
        border-color: #7DE2D1;
        font-weight: bolder;
    }
</style>