import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "../router";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

const REST_API_BOARD = `http://localhost:9999/api-board`
const REST_API_COMMENT = `http://localhost:9999/api-comment`
const REST_API_VIDEO = `http://localhost:9999/api-video`
const REST_API_VIDEO_REVIEW = `http://localhost:9999/api-videoReview`
const REST_API_USER = `http://localhost:9999/api-user`
const REST_API_GYM = `http://localhost:9999/api-gym`

export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    boards: [],
    board: {},
    comments: [],
    comment: {},
    // getcomment: {},
    wimg: '',
    videos: [],
    video: {},

    partVideos:[],
    popularVideos :[],
    categoryVideos:[],
    starVideos:[],
    VideoReviews: [],
    VideoReview: {},

    users:[],
    // searchUsers:[],
    user: null,
    loginUser: null,
    id : "",
    nickName : "",

    gyms: [],
    gymStar: [],
    gymReviewMost: [],
  },
  getters: {
    categoryVideoCnt: function (state) {
      return state.categoryVideos.length > 0 ? state.categoryVideos.length : null;
    },

    partVideoCnt: function (state) {
      return state.partVideos.length > 0 ? state.partVideos.length : null;
    },
    
    VideoReviewCnt: function (state) {
      return state.VideoReviews.length > 0 ? state.VideoReviews.length : null;
    }
    // userCnt: function (state) {
    //   return state.users.length;
    // },
    // searchUserCnt: function (state) {
    //   return state.searchUsers.length > 0 ? state.searchUsers.length : null;
    // },
    
  },
  mutations: {

    GET_BOARDS(state, boards) {
      state.boards = boards
    },
    GET_BOARD(state, board) {
      state.board = board
    },
    GET_COMMENTS(state, comments) {
      state.comments = comments
    },
    GET_COMMENT(state, comment) {
      state.comment = comment
    },
    GET_WRITER_IMG(state, wimg) {
      state.wimg = wimg
    },
    CREATE_BOARD(state, payload) {
      state.boards.push(payload);
    },
    UPDATE_BOARD(state, payload) {
      state.board = payload;
    },
    CREATE_COMMENT(state, payload) {
      state.comments.push(payload)
    },
    UPDATE_COMMENT(state, payload) {
      state.comment = payload;
    },

    SEARCH_VIDEO_CATEFORY: function (state, videos) {
      state.categoryVideos = videos;
    },
    SEARCH_VIDEO_PART: function (state, videos) {
      state.partVideos = videos;
    },
    POPULAR_VIDEOS: function (state, videos) {
      state.popularVideos = videos;
    },
    STAR_VIDEOS: function (state, videos) {
      state.starVideos = videos;
    },
    SET_VIDEOS: function (state, videos) {
      state.videos = videos;
    },
    SET_VIDEO: function (state, video) {
      state.video = video;
    },
    SET_VIDEO_REVIEWS: function(state, VideoReviews) {
      state.VideoReviews = VideoReviews;
    },
    CREATE_VIDEO_REVIEW: function(state, videoReview) {
      state.VideoReviews.push(videoReview)
    },
    GET_VIDEO_REVIEW: function(state, VideoReview) {
      state.VideoReview = VideoReview
    },
    UPDATE_VIDEO_REVIEW: function(state, VideoReview) {
      state.VideoReview = VideoReview
    },

    CREATE_USER: function (state, user) {
      state.users.push(user);
    },
    SET_USERS: function (state, users) {
      state.users = users;
    },
    SET_USER: function (state, user) {
      state.user = user;
    },
    SET_LOGIN_USER: function (state, user) {
      state.loginUser = user;
      //console.log(state.loginUser);
    },
    LOGOUT: function (state) {
      state.loginUser = null;
    },
    SET_USER_ID: function (state, id){
      state.id = id;
    },
    SET_USER_NICKNAME : function(state, nickName){
      state.nickName = nickName;
    },

    GET_GYMS(state, gyms) {
      state.gyms = gyms;
    },
    GET_GYMS_STAR(state, gyms) {
      state.gymStar = gyms;
    },
    GET_GYMS_REVIEW_MOST(state, gyms) {
      state.gymReviewMost = gyms;
    },
  },
  actions: {
    getBoards({commit}, payload) {
      let params = null;
      if(payload) params = payload;

      const API_URL = `${REST_API_BOARD}/board`
      axios({
        url: API_URL,
        method: "GET",
        params,
      })
      .then((res) => {
        commit("GET_BOARDS", res.data);
      })
      .catch((err) => {
        console.log(err)
      })
    },
    getBoard({commit}, id) {
      const API_URL = `${REST_API_BOARD}/board/${id}`
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        commit("GET_BOARD", res.data);
      })
      .catch((err) => {
        console.log(err)
      })
    },
    getWriterImg({commit}, id) {
      const API_URL = `${REST_API_BOARD}/board/img/${id}`
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        console.log(res.data)
        commit("GET_WRITER_IMG", res.data);
      })
      .catch((err) => {
        console.log(err)
      })
    },
    getComments({commit}, id) {
      const API_URL = `${REST_API_COMMENT}/comment/${id}`
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        commit("GET_COMMENTS", res.data);
      })
      .catch((err) => {
        console.log(err);
      })
    },
    createBoard({commit}, board) {
      const API_URL = `${REST_API_BOARD}/board`;
      axios({
        url: API_URL,
        method: "POST",
        params: board,
      })
      .then(() => {
        commit("CREATE_BOARD", board);

        router.push("/board")
      })
      .catch((err) => {
        console.log(err);
      })
    },
    deleteBoard({commit}, id) {
      const API_URL = `${REST_API_BOARD}/board/${id}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
      .then(() => {
        commit,
        router.push({ name: "BoardList"})
      })
      .catch((err) => {
        console.log(err)
      })
    },
    updateBoard({ commit }, board){
      const API_URL = `${REST_API_BOARD}/board`;
      axios({
        url: API_URL,
        method: "PUT",
        params: board,
      })
      .then(() => {
        commit("UPDATE_BOARD", board);
        router.push({name: "BoardDetail", params: {id: board.id}})
      })
      .catch((err) => {
        console.log(err)
      })
    },
    createComment({ commit }, comment) {
      const API_URL = `${REST_API_COMMENT}/comment`;
      axios({
        url: API_URL,
        method: "POST",
        params: comment,
      })
      .then(() => {
        commit("CREATE_COMMENT", comment);
        router.go(0);
      })
      .catch((err) => {
        console.log(err)
      })
    },
    deleteComment({ commit }, comment_id) {
      console.log(comment_id)
      const API_URL = `${REST_API_COMMENT}/comment/${comment_id}`
      axios({
        url: API_URL,
        method: "DELETE",
      })
      .then(() => {
        commit,
        router.go(0);
        alert("댓글을 삭제했습니다.")
      })
      .catch((err) => {
        console.log(err);
      })
    },
    getComment({ commit }, comment_id) {
      const API_URL = `${REST_API_COMMENT}/comment/one/${comment_id}`
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        commit("GET_COMMENT", res.data);
      })
      .catch((err) => {
        console.log(err)
      })
    },
    updateComment({commit}, comment) {
      const API_URL = `${REST_API_COMMENT}/comment`
      axios({
        url: API_URL,
        method: "PUT",
        params: comment,
      })
      .then(() => {
        commit("UPDATE_COMMENT", comment);
        router.go(0);
      })
      .catch((err) => {
        console.log(err)
      })
    },

    categoryVideo({commit}, category){
      const API_URL = `${REST_API_VIDEO}/list/category/${category}`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          key: "category",
          word: category,
        },
      })
        .then((res) => {
          commit("SEARCH_VIDEO_CATEFORY", res.data);
        })
        .catch((err) => {
          console.log(err);
        });      

    },
    partVideo({commit}, part){
      const API_URL = `${REST_API_VIDEO}/list/part/${part}`;
      axios({
        url: API_URL,
        method: "GET",
        params: {
          key: "part",
          word: part,
        },
      })
        .then((res) => {
          commit("SEARCH_VIDEO_PART", res.data);
        })
        .catch((err) => {
          console.log(err);
        });      

    },
    popularVideo({commit}){
      const API_URL = `${REST_API_VIDEO}/list/viewCnt`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("POPULAR_VIDEOS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });      

    },
    starVideo({commit}){
      const API_URL = `${REST_API_VIDEO}/list/rating_avg`;
      axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("STAR_VIDEOS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });      

    },
    setVideos({commit}) {
      const API_URL = `${REST_API_VIDEO}/list`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        commit("SET_VIDEOS", res.data);
      })
      .catch((err) => {
        console.log(err);
      })
    },
    setVideo({commit}, id) {
      const API_URL = `${REST_API_VIDEO}/${id}`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        commit("SET_VIDEO", res.data);
      })
      .catch((err) => {
        console.log(err);
      })
    },
    setVideoReviews({commit}, InputVideoId) {
      // console.log(videoId)
      const API_URL = `${REST_API_VIDEO_REVIEW}/review`
      axios({
        url: API_URL,
        method: "GET",
        params: {
          video_id: InputVideoId,
        },
      })
      .then((res) => {
        console.log(res.data);
        console.log(res.status);
        commit("SET_VIDEO_REVIEWS", res.data);
      })
      .catch((err) => {
        console.log(err)
      })
    },
    createVideoReview({commit}, videoReview) {
      console.log(videoReview)
      const API_URL = `${REST_API_VIDEO_REVIEW}/review`
      axios({
        url: API_URL,
        method: "POST",
        params: videoReview,
      })
      .then(() => {
        console.log(this.videoReview)
        commit("CREATE_VIDEO_REVIEW", videoReview)
        // router.go(0);
      })
      .catch((err) => {
        console.log(err)
      })
    },
    deleteVideoReview({ commit }, review_id) {
      const API_URL = `${REST_API_VIDEO_REVIEW}/review/${review_id}`
      axios({
        url: API_URL,
        method: "DELETE",
      })
      .then(() => {
        commit,
        alert("리뷰를 삭제했습니다.")
        router.go(0);
      })
      .catch((err) => {
        console.log(err);
      })
    },
    getVideoReview({ commit }, review_id) {
      const API_URL = `${REST_API_VIDEO_REVIEW}/review/${review_id}`
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        console.log(res.data)
        commit("GET_VIDEO_REVIEW", res.data);
      })
      .catch((err) => {
        console.log(err)
      })
    },
    updateVideoReview({commit}, videoReview) {
      const API_URL = `${REST_API_VIDEO_REVIEW}/review`
      axios({
        url: API_URL,
        method: "PUT",
        params: videoReview,
      })
      .then(() => {
        commit("UPDATE_VIDEO_REVIEW", videoReview);
        router.go(0);
      })
      .catch((err) => {
        console.log(err)
      })
    },

    createUser: function ({ commit }, user) {
      const API_URL = `${REST_API_USER}/signup`;
      console.log(user);
      axios({
        url: API_URL,
        method: "POST",
        params: user,
      })
      .then((res) => {
        commit("CREATE_USER",user);
        alert("등록되었습니다. 로그인해주세요!");
        router.push("/login");
      })
      .catch((err) => {
        console.log(err);
      })
    },
    setUsers: function ({commit}) {
      const API_URL = `${REST_API_USER}/users`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        console.log("Users setting...");
        commit("SET_USERS",res.data);
      })
      .catch((err) => {
        console.log(err);
      })    
    },
    updateUser: function ({ commit }, user) {
      const API_URL = `${REST_API_USER}/user/${user.id}`;
      axios({
        url: API_URL,
        method: "PUT",
        params:user,
      })
      .then((res) => {
        commit("UPDATE_USER",res.data);
        // commit("SET_LOGIN_USER",res.data);
        router.go(0)
      })
      .catch((err) => {
        console.log(err);
      })   
    },
    deleteUser: function ({ commit }, id) {
      const API_URL = `${REST_API_USER}/user/${id}`;
      axios({
        url: API_URL,
        method: "DELETE",
      })
      .then((res) => {
        commit("DELETE_USER",res.data);
      })
      .catch((err) => {
        console.log(err);
      })  
    },
    setUser: function ({commit}, id) {
      const API_URL = `${REST_API_USER}/${id}`;
      axios({
        url: API_URL,
        method: "GET",
        //params:id,
      })
      .then((res) => {
        commit("SET_USER",res.data);
      })
      .catch((err) => {
        console.log(err);
      })  
    },
    idCheck: function ({commit}, id){
      const API_URL = `${REST_API_USER}/idCheck`;
      axios({
        url : API_URL,
        method:"GET",
        params :{id:encodeURI(id)},
      })
      .then((res) =>{
        console.log(res.data);
        alert(res.data);
      })
      .catch((err)=>{
        alert(Object(err.data));
        console.log(err);
      })
    },
    emailCheck: function ({commit}, email ){
      const API_URL = `${REST_API_USER}/emailCheck`;
      axios({
        url : API_URL,
        method:"GET",
        params :{email: encodeURI(email)},
      })
      .then((res) =>{
        alert(res.data);
      })
      .catch((err)=>{
        alert(Object(err.data));
        console.log(err);
      })
    },
    nickNameCheck: function ({commit}, nickName ){
      const API_URL = `${REST_API_USER}/nickNameCheck`;
      axios({
        url : API_URL,
        method:"GET",
        params :{nickName :encodeURI(nickName)},
      })
      .then((res) =>{
        alert(res.data);
      })
      .catch((err)=>{
        alert(Object(err.data));
        console.log(err);
      })
    },
    setLoginUser: function ({ commit, dispatch, context}, user) {
      const API_URL = `${REST_API_USER}/login`;
      console.log(user);
      axios({
        url: API_URL,
        method: "GET",
        params: user,
      })
      .then((res) => {
        commit("SET_LOGIN_USER",Object.values(res.data)[3]);
        console.log(res.data);
        let access_token = Object.values(res.data)[1];
        let refresh_token = Object.values(res.data)[0];
        //유효기간...세션 끌때까지
        document.cookie = `access-token=${access_token}`;
        document.cookie = `refresh-token=${refresh_token}`;
        // dispatch("setCookie",("access-token", access_token, 30 ));
        // dispatch("setCookie",("refresh-token", refresh_token, 30 * 5));

        // console.log(access_token);
        // console.log(refresh_token);

        alert(Object.values(res.data)[2]);
        router.push("/");
      })
      .catch((err) => {
        alert(Object(err.data)[0]);
        console.log(err);
      })
    },
    //확인필요
    logout: function({commit, dispatch},id){
      commit("LOGOUT",id);
      //this.dispatch("getCookie","access-token")
      //.then((res) => {
      //  console.log(res);
      //})
      //this.dispatch("getCookie","refresh-token")
      //.then((res) => {
      //  console.log(res);
      //})
      dispatch("deleteCookie","access-token");
      dispatch("deleteCookie","refresh-token");
      //this.dispatch("getCookie","access-token")
      //.then((res) => {
      //  console.log(res);
      //})
      //this.dispatch("getCookie","refresh-token")
      //.then((res) => {
      //  console.log(res);
      //})
    },
    setCookie: function ({commit}, key, value, expirePeriod) {
        const todayDate = new Date();
        todayDate.setTime(todayDate.getTime() + expirePeriod * 60 * 1000); //현재 시각 + 쿠키 만료 기간(분?)
        document.cookie = key + "=" + escape(value) + "; expires=" + todayDate.toUTCString()+"; path/;";
    },     
    getCookie: function({commit}, key){
      let name= key + "=";
      let decodedCookie = decodeURIComponent(document.cookie);
      let ca = decodedCookie.split(';');
      //console.log(name);
      //console.log(decodedCookie);
      //console.log(ca);
      for (let i =0; i<ca.length;i++){
        let c = ca[i];
        while (c.charAt(0) == ' '){
          c = c.substring(1);
        }
        if(c.indexOf(name) == 0){
          //console.log(c.substring(name.length, c.length));
          return c.substring(name.length, c.length);
        }
      }
      return "";
      },
    deleteCookie: function({commit, dispatch},key) {
      const todayDate = new Date();
      document.cookie = key + "=; path=/; expires"+todayDate.toUTCString()+";"
      //현재 시각 이전이면 쿠키가 사라진다.
    },
    //백에서 액세스토큰 디코딩한거 문자열로 받아와서 잘라가지구 유저 아이디랑 닉네임 가져오기
    splitAccessToken : function({commit, dispatch}){
      const API_URL = `${REST_API_USER}/decode`;
      //promise가 찍힘
      let token  = ""
      dispatch("getCookie", "access-token")
      .then((res) =>{
        token = res
      }).then(()=>{
      axios({
        url: API_URL,
        method: "GET",
        //string..객체로 전송
        params : {token : token }     
      })
      .then((res) => {
       //console.log(res.data);
        const obj = JSON.parse(JSON.stringify(res.data));
        commit("SET_USER_ID",obj.id);
        commit("SET_USER_NICKNAME",obj.nickName);

      })
      .catch((err) => {
        console.log(err);
      })
    })
    },
    getGymList({commit}) {
      const API_URL = `${REST_API_GYM}/gym`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        commit("GET_GYMS", res.data);
      })
      .catch((err) => {
        console.log(err);
      })
    },
    getGymStar({commit}) {
      const API_URL = `${REST_API_GYM}/gym/rating_avg`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        commit("GET_GYMS_STAR", res.data);
      })
      .catch((err) => {
        console.log(err);
      })
    },
    getGymReviewMost({commit}) {
      const API_URL = `${REST_API_GYM}/gym/reviewCnt`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res) => {
        commit("GET_GYMS_REVIEW_MOST", res.data);
      })
      .catch((err) => {
        console.log(err);
      })
    }
  },
  modules: {},
});
