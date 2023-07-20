<template>
  <header class="px-4" style="background-color: #B2EBF4">
    <nav class="header-nav">
      <div>
        <b-link to="/" class="logo">SSAFIT</b-link>
      </div>
      <div class="m-3">
        <b-link class="mx-3" to="/video" v-if="getUser"><img src="../../assets/img/video_line.png" style="width: 2rem"></b-link>
        <b-link class="mx-3" to="/gym" v-if="getUser"><img src="../../assets/img/maps_line.png" style="width: 2rem"></b-link>
        <b-link class="mx-3" to="/board" v-if="getUser"><img src="../../assets/img/talking_line.png" style="width: 2rem"></b-link>
        <b-link class="mx-3" :to="`/user/${loginUser.id}`" v-if="getUser"><img src="../../assets/img/social-network.png" style="width: 2rem"></b-link>
        <a class="m-1" href="/" v-if="getUser" @click="logout">로그아웃</a>
        <b-link class="m-1" to="/login" v-if="!getUser">로그인</b-link>
        <b-link class="m-1" :to="{ name: 'Regist' }" v-if="!getUser" >회원가입</b-link>
      </div>
    </nav>
  </header>
</template>
<script>
import { mapState} from "vuex";
export default {
  name: "HeaderNav",
  data(){
   return {
    //loginCheck : false,
  };
  },
  methods: {
    logout() {
      this.$store.dispatch("logout");
      
    },
  },
  computed: {
    ...mapState(["loginUser"]),
    getUser() {
        // this.$store.dispatch("getCookie",`access-token`)
       // .then((res) =>{
        //console.log(res);
        //console.log(this.loginUser);
        //console.log((this.loginUser !=={})|| (res !==""));
        let temp = JSON.parse(localStorage.getItem("vuex")).loginUser
        console.log(temp);
        console.log(typeof(temp));
      if (this.loginUser || temp !== null){
        return true;
      } else {
        return false;
      }
    },
  },
};
</script>
<style scoped>
header a, header a:hover {
  text-decoration: none;
  color: whitesmoke;
}

.header-nav {
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
  margin: 0;
}
</style>
