<template>
  <div class="container">
    <br>
    <div class="row justify-content-center">
    <b-card class="col-6">
    <h2 class="text-center">회원 가입</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <b-input class="m-1 view" type="text" id="id" v-model="id"/><br />
      <b-button class="m-1 py-2" block variant="outline-primary" @click="idCheck">중복체크</b-button>
      <!--메서드 추가-->
      <label for="password">비밀번호</label>
      <b-input
        type="password"
        class="m-1 view"
        id="password"
        v-model="password"
      /><br />
      <label for="password">비밀번호 확인</label>
      <b-input
        type="password"
        class="m-1 view"
        id="passwordConfirm"
        v-model="passwordConfirm"
      /><br />
      <div for="check" v-if="!passwordCheckValid" >비밀번호가 일치하지 않습니다.</div>
      <!--밑의 비밀번호가 위에랑 다르면...비밀번호가 일치하지 않습니다. 띄우기-->
      <br />
      <label for="name">이름</label>
      <b-input type="text" id="name" v-model="name" class="m-1 view" /><br />
      <label for="nickName">별명</label>
      <b-input type="text" id="nickName" v-model="nickName" class="m-1 view" /><br />
      <b-button class="m-1 py-2" block variant="outline-primary" @click="nickNameCheck">중복체크</b-button>
      <label for="email">이메일</label>
      <b-input type="email" id="email" v-model="email" class="m-1 view" /><br />
      <b-button class="m-1 py-2" block variant="outline-primary" @click="emailCheck">중복체크</b-button>
      <!--중복체크 메서드 추가-->
      <label for="address">주소</label>
      <b-input type="address" id="address" v-model="address" class="m-1 view" /><br />     
      <!-- 선택된 사진..어떻게 넣지 -->
      <label for="img">이미지</label>
      <b-container>
      <b-row>
      <b-col cols="4">
      <b-form-radio id="img1" v-model="img" class="m-1 view" value = "avatar1" /><br />
      <img :src="require(`../../assets/profile/avatar1.png`)" class="m-2">
      </b-col>
      <b-col cols="4">
      <b-form-radio id="img2" v-model="img" class="m-1 view" value = "avatar2" /><br />
      <img :src="require(`../../assets/profile/avatar2.png`)" class="m-2">
      </b-col>
      <b-col cols="4">
      <b-form-radio id="img3" v-model="img" class="m-1 view" value = "avatar3" /><br />
      <img :src="require(`../../assets/profile/avatar3.png`)" class="m-2">
      </b-col>
      <b-col cols="4">
      <b-form-radio id="img4" v-model="img" class="m-1 view" value = "avatar4" /><br />
      <img :src="require(`../../assets/profile/avatar4.png`)" class="m-2">
      </b-col>
      <b-col cols="4">
      <b-form-radio id="img5" v-model="img" class="m-1 view" value = "avatar5" /><br />
      <img :src="require(`../../assets/profile/avatar5.png`)" class="m-2">
      </b-col>
      <b-col cols="4">
      <b-form-radio id="img6" v-model="img" class="m-1 view" value = "avatar6" /><br />
      <img :src="require(`../../assets/profile/avatar6.png`)" class="m-2">
      </b-col>
      <b-col cols="4">
      <b-form-radio id="img7" v-model="img" class="m-1 view" value = "avatar7" /><br />
      <img :src="require(`../../assets/profile/avatar7.png`)" class="m-2">
      </b-col>
      <b-col cols="4">
      <b-form-radio id="img8" v-model="img" class="m-1 view" value = "avatar8" /><br />
      <img :src="require(`../../assets/profile/avatar8.png`)" class="m-2">
      </b-col>
      </b-row>
      </b-container>
      <b-button class="m-1 py-2" block variant="outline-primary" @click="regist">등록</b-button>
    </fieldset>
  </b-card>
</div>
  </div>
</template>
<script>

export default {
  name: "Regist",
  watch:{
    img(){
      console.log("img: ", this.img)
    },
    },
  data() {
    return {
      id: "",
      password: "",
      passwordConfirm: "",
      name: "",
      nickName: "",
      email: "",
      user_rank: 1,
      address: "",
      img: "",
      //passwordCheck : true,
    };
  },
  computed : {
    //비밀번호 확인
    passwordCheckValid(){
      console.log("passwordCheckValid");
      if(this.password === this.passwordConfirm){
        return true;
      } else {
        return false;
      }
    },
  },
  methods: {

    idCheck(){
      this.$store.dispatch('idCheck', this.id);   
    },
    emailCheck(){
      this.$store.dispatch('emailCheck', this.email);   
    },
    nickNameCheck(){
      this.$store.dispatch('nickNameCheck', this.nickName);   
    },
    regist() {
      if (
        this.id === "" ||
        this.password === "" ||
        this.passwordConfirm === "" ||
        this.name === "" ||
        this.nickName ===""||
        this.email === "" ||
        this.address === ""
      ) {
        alert("모든 내용을 입력해주세요");
        return;
      }

      let user = {
        id: this.id,
        password: this.password,
        name: this.name,
        nickName: this.nickName,
        email: this.email,
        address: this.address,
        img: this.img,
      };
      console.log(user);
      this.$store.dispatch("createUser", user);
    },
  },
};
</script>

<style scoped>
  img {
    width: 5rem;
  }
</style>