<template>
  <div class = "board">

    <div class="overflow-auto">
        <div class = "infobox">
        <span class="mt-3">Current Page: {{ currentPage }}</span>
        </div>
        <b-table
        id="my-table"
        striped hover
        :items="exercises"
        :per-page="perPage"
        :current-page="currentPage"
        :fields="fields"
        @row-clicked="goDetail"
        >
        <template #cell(#)="data">
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
</template>

<script>
import { mapState } from 'vuex'


export default {
    name: "ExerciseList",
    data() {
        
        return {
        perPage: 10,
        currentPage: 1,
        keyword: "",
        items: this.exercises,
        index: 0,
        fields: [{key:"regDate", label:'date'}],
      }
    },
    computed: {
      rows() {
        return this.exercises.length
      },
      ...mapState([
          "exercises"
      ])
    },
    components: {
        
    },
    methods:{

        goDetail(row) {
            console.log(row.regDate )
            const id = sessionStorage.getItem("id")
            const payload={
                id:id,
                regDate: row.regDate
            }
            this.$store.dispatch('getExercise',payload)
            this.$store.dispatch('getWorkout',payload)
            this.$router.push('/exercisedetail')
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
        const id = sessionStorage.getItem("id")
        this.$store.dispatch('getExercises',id)

    },

}

</script>

<style scoped>
    @import url('https://fonts.googleapis.com/css2?family=Roboto+Flex:opsz,wght@8..144,100&display=swap');

    .title{
        padding: 50px 0 0 0;
        text-align: center;
        color: white;
        font-size: 30px;
    }
    .overflow-auto{
        color: white !important;
        padding: 2% 30%;
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
        height : auto;
        min-height: 60vh;
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