import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex)
const YOUTUBE_API_KEY = ''
const YOUTUBE_API_URL = 'https://www.googleapis.com/youtube/v3/search'
const qlist = ['운동', '다이어트', '운동할 때 듣는 노래']
export default new Vuex.Store({
  state: {
    videos: [],
  },
  getters: {
  },
  mutations: {
    GET_VIDEOS(state, payload){
      state.videos = payload
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
    }
  },
  modules: {
  }
})
