import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

import Board from "../views/Board.vue";
import BoardList from "../components/board/BoardList.vue";
import BoardDetail from "../components/board/BoardDetail.vue";
import BoardCreate from "../components/board/BoardCreate.vue";
import BoardUpdate from "../components/board/BoardUpdate.vue";

import Video from '../views/Video.vue';
import VideoDetail from "../components/video/VideoDetail.vue";
import VideoList from "../components/video/VideoList.vue";

import User from '../views/User.vue';
import MyPage from "../components/user/MyPage.vue";
import UserRegist from "../components/user/UserRegist.vue";

import LoginForm from "@/components/LoginForm.vue";

import Gym from "../views/Gym.vue";
import GymList from "../components/gym/GymList.vue";
import GymStar from "../components/gym/GymStar.vue";
import GymReviewMost from "../components/gym/GymReviewMost.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/board",
    name: "Board",
    component: Board,
    children: [
      {
        path: "",
        name: "BoardList",
        component: BoardList,
        meta: {authRequired: true},
      },
      {
        path: ":id",
        name: "BoardDetail",
        component: BoardDetail,
        meta: {authRequired: true},
      },
      {
        path: "create",
        name: "BoardCreate",
        component: BoardCreate,
        meta: {authRequired: true},
      },
      {
        path: "update",
        name: "BoardUpdate",
        component: BoardUpdate,
        meta: {authRequired: true},
      },
    ]
  },
  {
    path: "/video",
    name: "Video",
    component: Video,
    children: [
      {
        path: "",
        name: "VideoList",
        component: VideoList,
        meta: {authRequired: true},
      },
      {
        path: ":id",
        name: "VideoDetail",
        component: VideoDetail,
        meta: {authRequired: true},
      },
    ],
  },
  {
    path : "/login",
    name : "LoginForm",
    component : LoginForm,
  },
  {
    path: "/user",
    component: User,
    children: [
      {
        // '/regist'라고 쓰면 그대로 넘어감.
        // 밑에처럼 쓰면 /user/regist로 감
        path: "regist",
        name: "Regist",
        component: UserRegist,
      },
      // {
      //   path: "",
      //   name: "List",
      //   component: UserList,
      // },
      {
        path: ":id",
        name: "MyPage",
        component: MyPage,
        meta: {authRequired: true},
      },
    ],
  },
  {
    path: "/gym",
    component: Gym,
    children: [
      {
        path: "",
        name: "GymList",
        component: GymList,
        meta: {authRequired: true},
      },
      {
        path: "star",
        name: "GymStar",
        component: GymStar,
        meta: {authRequired: true},
      },
      {
        path: "mostreview",
        name: "GymReviewMost",
        component: GymReviewMost,
        meta: {authRequired: true},
      }
    ]
  },
];

import store from "../store/index";

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach(function(to, from, next) {
  if(to.matched.some(function(routeInfo) {
    return routeInfo.meta.authRequired;
  }) && store.state.loginUser == null) {
    alert("로그인하세요.");
    next({name: "LoginForm"});
  } else {
    next();
  }
})

export default router;
