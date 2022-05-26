import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import RankingView from '@/views/RankingView.vue'
import BoardView from '@/views/BoardView.vue'
import LoginView from '@/views/LoginView.vue'
import JoinView from '@/views/JoinView.vue'
import MapView from '@/views/MapView.vue'
import BoardinsertView from '@/views/BoardinsertView.vue'
import BoardDetailView from '@/views/BoardDetailView.vue'
import UserProfileView from '@/views/UserProfileView.vue'
import VideosView from '@/views/VideosView.vue'
import ExerciseListView from '@/views/ExerciseListView.vue'
import ExerciseDetailView from '@/views/ExerciseDetailView.vue'
import ProfileEditView from '@/views/ProfileEditView.vue'
import WorkoutEditView from '@/views/WorkoutEditView.vue'
import VideoDetailView from '@/views/VideoDetailView.vue'










Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/ranking',
    name : 'ranking',
    component: RankingView
  },
  {
    path: '/board',
    name: 'board',
    component: BoardView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/join',
    name: 'join',
    component: JoinView
  },
  {
    path: '/map',
    name: 'map',
    component: MapView
  },
  {
    path: '/boardinsert',
    name: 'boardinsert',
    component: BoardinsertView
  },
  {
    path: '/boarddetail',
    name : 'boarddetail',
    component: BoardDetailView
  },
  {
    path : '/workout',
    name : 'workout',
    component : UserProfileView
  },
  {
    path : '/videos',
    name : 'videos',
    component : VideosView
  },
  {
    path : '/exerciselist',
    name : 'exerciselist',
    component : ExerciseListView,
  },
  {
    path : '/exercisedetail',
    name : 'exercisedetail',
    component : ExerciseDetailView,
  },
  {
    path: '/profileEdit',
    name : 'profileEdit',
    component : ProfileEditView,
  },
  {
    path: '/workoutEdit',
    name : 'workoutEdit',
    component : WorkoutEditView,
  },
  {
    path: '/videoDetail/:videoId',
    name: 'videoDetail',
    component: VideoDetailView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
