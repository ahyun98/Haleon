<template>
  <div class = "rank">
    <button class = "rankingbtn">Steady</button>
    <button class = "rankingbtn">Body Muscle</button>
  <div class="RankingComp">
    <div class = "title">Top Rated</div>
    <div class="overflow-auto">
        <p class="mt-3">Current Page: {{ currentPage }}</p>

        <b-table
        id="my-table"
        :items="items"
        :per-page="perPage"
        :current-page="currentPage"
        :fields = "fields"
        >
          <template #cell(index)="data">
            {{ data.index + 1 }}
          </template>
        </b-table>
        <b-pagination
        align="center"
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="my-table"
        ></b-pagination>
    </div>
  </div>
  </div>
</template>

<script>


export default {
    data() {
        return {
        perPage: 20,
        currentPage: 1,

        items: [
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},

          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},
          {username:"ahyun", period: "13", muscle: '14'},

        ],
        fields: ['index',
            'username','period','muscle'],
      }
    },
    computed: {
      rows() {
        return this.items.length
      }
    },
    components: {
        
    },
    methods:{


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
    .RankingComp{

        background-color: #131515;
        height : 2000px;
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
        
    }
    .rankingbtn{
        background-color: #7DE2D1;
        margin: 0px 5px 0px 0px;
        color: #131515;
        border-radius: 5px 5px 0px 0px;
        border-color: #7DE2D1;
        font-weight: bolder;
    }
    .rank{
        margin: 30px 0px 0px 0px;
        font-family: 'Roboto Flex', sans-serif !important;
    }
    .clicked{
        background-color: blue;
    }
    th{
        font-size: 18px;
        background-color: #00b99a;
        color: #131515;
    }
</style>