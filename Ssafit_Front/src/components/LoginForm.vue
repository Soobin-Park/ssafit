<template>
  <div class="container">
    <br>
    <div class="row justify-content-center">
      <b-card class="col-6">
      <h2 class="text-center">로그인</h2>
      <div class="m-1">
        <label for="id" class="p-1">아이디</label>
        <b-input class="m-1" type="text" id="id" v-model="id"/>
        <label for="password" class="p-1">비밀번호</label>
        <b-input class="m-1" type="password" id="password" v-model="password"/>
        <br>
        <b-button class="m-1 py-2" block variant="outline-primary" @click="login">로그인</b-button>
        <!--아직 회원이 아니신가요? 하고 회원가입 하나 만들기-->
      </div>   
    </b-card>
    </div>
    
  </div>
</template>
<script>
export default {
  name: "LoginForm",
  data() {
    return {
      id: "",
      password: "",
    };
  },
  methods: {
    login() {
      let user = {
        id: this.id,
        password: this.password,
      };

      this.$store.dispatch("setLoginUser", user);
    },
  },
};
</script>
