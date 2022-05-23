import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex)
const YOUTUBE_API_KEY = ''
const YOUTUBE_API_URL = 'https://www.googleapis.com/youtube/v3/search'

const REST_API = 'http://localhost:8888/api'
const qlist = ['운동', '다이어트', '운동할 때 듣는 노래']
export default new Vuex.Store({
  state: {
    videos: [],
    boards: [],
  },
  getters: {
  },
  mutations: {
    GET_VIDEOS(state, payload){
      state.videos = payload
    },
    GET_BOARDS(state,payload){
      state.boards = payload
    }
  },
  actions: {
    getVideos({commit}){
      const API_URL = YOUTUBE_API_URL;
      axios({
        url : API_URL,
        method: 'GET',
        params:{
          part: 'snippet',
          type: 'video',
          q: `${qlist[Math.floor(Math.random() * 3)]}`,
          maxResults: 6,
          key: YOUTUBE_API_KEY,
        }
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
        const API_URL = `${REST_API}/communityBoard`
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
    }
  },
  modules: {
  }
})
