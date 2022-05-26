import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'
import router from '@/router'


Vue.use(Vuex)
// AIzaSyDyfOh2BxGL0ynInW3c-LyCltAVLY3y_dA
//AIzaSyAmCuG3yHJYja58BIGE0gXNWmPUb-FJaqY
const YOUTUBE_API_KEY = 'AIzaSyDyfOh2BxGL0ynInW3c-LyCltAVLY3y_dA'
const YOUTUBE_API_URL = 'https://www.googleapis.com/youtube/v3/search'

const REST_API = 'http://localhost:8888/api'
const qlist = ['운동', '다이어트', '운동할 때 듣는 노래']
export default new Vuex.Store({
  state: {
    videos: [],
    boards: [],
    board: {},
    profile: {},
    LoginCheck: false,
    username:"",
    workout:{},
    exercise:[],
    exercises:[],
    ischeck:false,
    is_Exercise:[],
    user:{},
    videolog: [],
    userlist:[],
  },
  getters: {
  },
  mutations: {
    GET_VIDEOS(state, payload){
      state.videos = payload
    },
    GET_BOARDS(state,payload){
      state.boards = payload
    },
    CREATE_BOARD(state, payload){
      state.boards.push(payload)
    },
    USER_LOGIN(state){
      state.LoginCheck=true
    },
    GET_BOARD(state,payload){
      state.board = payload
    },
    GET_PROFILE(state,payload){
      state.profile = payload
    },
    ADD_EXERCISE (state,payload){
      state.exercise = payload
    },
    GET_EXERCISE(state, payload){
      state.exercise = payload
    },
    GET_EXERCISES(state, payload){
      state.exercises=payload
    },
    ID_CHECK(state){
      state.ischeck=true
    },
    GET_WORKOUT(state, payload){
      state.workout = payload
    },
    IS_EXERCISE(state,payload){
      state.is_Exercise.push(payload)
    },
    GET_USER(state,payload){
      state.user = payload
    },
    GET_VIDEOLOG(state,payload){
      state.videolog = payload
    },
    GET_USERLIST(state,payload){
      state.userlist = payload
    }    
  },
  actions: {
    getVideos({commit},payload){
      let params = {
        part: 'snippet',
        type: 'video',
        q: `${qlist[Math.floor(Math.random() * 3)]}`,
        maxResults: 6,
        key: YOUTUBE_API_KEY,
      }
      if(payload){
        if(payload=='전체'){
          params = {
            part: 'snippet',
            type: 'video',
            q: `${qlist[Math.floor(Math.random() * 3)]}`,
            maxResults: 6,
            key: YOUTUBE_API_KEY,
          }
        }else if(payload=='Playlist'){
          params = {
            part: 'snippet',
            type: 'video',
            q: `${qlist[Math.floor(Math.random() * 3)]}`,
            maxResults: 6,
            key: YOUTUBE_API_KEY,
          }
        }else {
          params = {
            part: 'snippet',
            type: 'video',
            q: `${payload}`,
            maxResults: 6,
            key: YOUTUBE_API_KEY,
          }
        }
      }
      const API_URL = YOUTUBE_API_URL;
      axios({
        url : API_URL,
        method: 'GET',
        params:params,
      }).then((res)=>{
        commit('GET_VIDEOS', res.data.items)
        console.log(res.data.items)
      }).catch((err)=>{
        console.log(qlist)
        console.log(err)
      })
    },
    getBoards({commit},payload){
      let params = null;
      if(payload){
        params = payload
      }
        const API_URL = `${REST_API}/communityBoardDesc`
        axios({
          url : API_URL,
          method : 'GET',
          params
        }).then((res)=>{
          console.log(res.data)
          commit('GET_BOARDS',res.data)
        }).catch((err)=>{
          console.log(err)
        })
    },
    createBoard({commit}, board){
      const API_URL = `${REST_API}/communityBoard`;
      axios({
        url : API_URL,
        method : 'POST',
        params : board
      }).then(()=>{
        console.log("hi")
        commit('CREATE_BOARD', board)
        router.push({name : 'board'})
      }).catch((err)=>{
        console.log(err)
      })
    },
    userLogin({commit}, user){
      const API_URL = `${REST_API}/login`;
      axios({
        url : API_URL,
        method : 'POST',
        params : user
      }).then((res)=>{
        commit('USER_LOGIN', user)
        sessionStorage.setItem("access-token", res.data)
        sessionStorage.setItem("id", user.id)
        router.push("/") 
      }).catch((err)=>{
        alert("ID 또는 비밀번호가 일치하지 않습니다.");
        console.log(err)
      })
    },
    BoardDetail({commit}, num){
      const API_URL = `${REST_API}/communityBoard/${num}`;
      axios({
        url : API_URL,
        method : 'GET',
      }).then((res)=>{
        console.log(res.data)
        commit('GET_BOARD', res.data)
        router.push({name : 'boarddetail'})
      }).catch((err)=>{
        console.log(err)
      })
    },
    UserJoin({commit}, user){
      commit
      const API_URL = `${REST_API}/user`;
      axios({
        url : API_URL,
        method : "POST",
        params : user,
      }).then(()=>{
      }).catch((err)=>{
        console.log(err)
      })
    },
    insertProfile({commit}, payload){
      commit
      const API_URL = `${REST_API}/profile`;
      console.log("안녕")
      axios({
        url : API_URL,
        method : "POST",
        params : payload,
      }).then(()=>{
        router.push({name : 'login'})
      }).catch((err)=>{
        console.log(err)
      })
    },
    getProfile({commit}, id){
      if(!id){
        alert("로그인이나 해라")
        router.push("/login")
      }
      const API_URL = `${REST_API}/profile/${id}`;
      axios({
        url : API_URL,
        method : 'GET',
      }).then((res)=>{
        commit('GET_PROFILE',res.data)
      }).catch((err)=>{
        console.log(err)
      })
    },
    addExercise({commit},payload){
      const API_URL = `${REST_API}/routine`;
      axios({
        url : API_URL,
        method : 'POST',
        params : payload
      }).then(()=>{
        console.log("성공")
        commit('ADD_EXERCISE',payload)
      }).catch((err)=>{
        console.log(err)
      })
    },
    addWorkout({commit},payload){
      
      commit
      const API_URL = `${REST_API}/workout`;
      const data = {
        id: payload.id,
        regDate: payload.regDate,
      }
      axios({
        url : API_URL,
        method: 'GET',
        params: data,
      }).then((res)=>{
        console.log(res.data)
        if(!res.data){
          axios({
            url : API_URL,
            method: 'POST',
            params : payload
          }).then(()=>{
          }).catch((err)=>{
            console.log(err)
          })
        }
        console.log("이미 있어")
      }).catch((err)=>{
        console.log(err)
      })
    },
    boardInsertForm({commit}){
      commit
      const id = sessionStorage.getItem("id");
      if(!id){
        alert("로그인이나 해라")
        router.push("/login")
      }else{
        router.push("/boardinsert")
      }
    },
    getExercise({commit},payload){
      const API_URL = `${REST_API}/routine`
      axios({
        url : API_URL,
        method: 'GET',
        params: payload
      }).then((res)=>{
        console.log(res);
        commit('GET_EXERCISE',res.data);

      }).catch((err)=>{
        console.log(err);
      })
    },
    getExercises({commit},id){
      const API_URL = `${REST_API}/routine/{id}?id=${id}`
      axios({
        url : API_URL,
        method: 'GET',
      }).then((res)=>{
        commit('GET_EXERCISES',res.data);

      }).catch((err)=>{
        console.log(err);
      })
    },
    getWorkout({commit},payload){
      const API_URL = `${REST_API}/workout`
      axios({
        url : API_URL,
        method: 'GET',
        params: payload
      }).then((res)=>{
        commit('GET_WORKOUT',res.data);

      }).catch((err)=>{
        console.log(err);
      })
    },
    idCheck({commit},id){

      const API_URL = `${REST_API}/user/${id}`;
      axios({
        url:API_URL,
        method:'GET',

      }).then((res)=>{
        if(res.data){
          alert("이미 사용중인 아이디입니다.")
        }else{
          alert("사용 가능한 아이디입니다.")
          commit('ID_CHECK');
        }
      }).catch((err)=>{
        console.log(err);
      })
    },
    isExercise({commit},payload){
      if(this.state.is_Exercise==""){
        const API_URL = `${REST_API}/routine`
        axios({
          url : API_URL,
          method: 'GET',
          params: payload
        }).then((res)=>{
          
          if(res.data){
            
            commit('IS_EXERCISE',true);
          }else{
            
            commit('IS_EXERCISE',false);
          }
          
        }).catch((err)=>{
          console.log(err);
        })
      }
    },
    workoutEdit({commit}, payload){
      commit
      const API_URL = `${REST_API}/workout`
      axios({
        url : API_URL,
        method: 'PUT',
        params: payload
      }).then(()=>{
        console.log("수정 성공")
        router.push("/workout")
      }).catch((err)=>{
        console.log(err);
      })
    },
    profileEdit({commit}, payload){
      commit
      const API_URL = `${REST_API}/profile`
      axios({
        url : API_URL,
        method: 'PUT',
        params: payload
      }).then(()=>{
        console.log("수정 성공")
        router.push("/workout")
      }).catch((err)=>{
        console.log(err);
      })
    },
    getUser({commit}, payload){
      const API_URL = `${REST_API}/user/${payload}`
      axios({
        url : API_URL,
        method: 'GET',
      }).then((res)=>{
        commit("GET_USER",res.data)
      }).catch((err)=>{
        console.log(err);
      })
    },
    addVideolog({commit}, payload){
      commit
      const API_URL = `${REST_API}/insertLog`
      axios({
        url : API_URL,
        method: 'POST',
        params: payload
      }).then(()=>{
        console.log("성공")
      }).catch((err)=>{
        console.log(err);
      })
    },
    getVideolog({commit}, id){
      const API_URL = `${REST_API}/userVideoLog/${id}`
      axios({
        url : API_URL,
        method: 'GET',
      }).then((res)=>{
        commit("GET_VIDEOLOG",res.data)
      }).catch((err)=>{
        console.log(err);
      })
    },
    getUserlist({commit}){
      const API_URL= `${REST_API}/profileListPeriod`
      axios({
        url : API_URL,
        method: 'GET',
      }).then((res)=>{
        commit("GET_USERLIST",res.data)
      }).catch((err)=>{
        console.log(err);
      })
    }

  },
  modules: {
  }
})
