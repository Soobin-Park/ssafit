<template>
  <div class="container">
    <!-- <div>{{ user }}</div> -->
    <br>
    <b-card no-body class="overflow-hidden">
      <b-row no-gutters>
        <b-col md="6">
          <b-card-img id="profile_img" :src="require(`../../assets/profile/${user.img}.png`)" alt="Image" class="rounded-0"></b-card-img>
        </b-col>
        <b-col md="6">
          <b-card-body>
            <br>
            <div class="d-flex justify-content-center">
              <b-card-title><b-icon-person-circle></b-icon-person-circle> 내 정보</b-card-title>
            </div>
            <br>
            <b-container class="bv-example-row">
              <br><br>
              <b-row align-h="start">
                <b-col cols="3"><b-card-text>이름</b-card-text></b-col>
                <b-col><h4>{{ user.name }}</h4></b-col>
              </b-row>
              <br>
              <b-row align-h="start">
                <b-col cols="3"><b-card-text>아이디</b-card-text></b-col>
                <b-col><h4>{{ user.id }}</h4></b-col>
              </b-row>
              <br>
              <b-row align-h="start">
                <b-col cols="3"><b-card-text>닉네임</b-card-text></b-col>
                <b-col><h4>{{ user.nickName }}</h4></b-col>
              </b-row>
              <br>
              <b-row align-h="start">
                <b-col cols="3"><b-card-text>이메일</b-card-text></b-col>
                <b-col><h4>{{ user.email }}</h4></b-col>
              </b-row>
              <br>
              <b-row align-h="start">
                <b-col cols="3"><b-card-text>주소</b-card-text></b-col>
                <b-col><h4>{{ user.address }}</h4></b-col>
              </b-row>
              <br>
              <b-row align-h="start">
                <b-col cols="3"><b-card-text>등급</b-card-text></b-col>
                <b-col v-if="userLevel"><h4>일반회원</h4></b-col>
                <b-col v-if="!userLevel"><h4>관리자</h4></b-col>
              </b-row>
            </b-container>
          </b-card-body>
        </b-col>
      </b-row>
    </b-card>
      <br>
        <div class="row justify-content-center">
        </div>
        <br>
        
        <!--updateUser 클릭시 비밀번호 확인 한 번 하고 싶음 -> 해냄!....-->
        <b-button variant="outline-primary" @click="updateModalConfirm"><b-icon icon="gear-fill"></b-icon> 회원 정보 수정</b-button>
        <b-button variant="outline-primary" @click="deleteUser"><b-icon icon="person-dash-fill"></b-icon> 회원 탈퇴</b-button>
        <b-modal ref="createModal" hide-footer>
            <template #modal-header>
              <p class="h5 mb-2">회원 정보 수정</p>
            </template>
            <div class="d-block text-start">
              <div>이름</div>
              <b-input type="text" id="name" v-model="user.name"/>
              <br>
              <!--아이디는 수정 x 보여주기만-->
              <div>아이디</div>
              <b-input type="text" id="id" readonly v-model="user.id"/>
              <br>
              <div>비밀번호</div>
              <b-input type="password" id="password" placeholder="비밀번호" v-model="password"/>
              <br>
              <!--비밀번호 맞는지 체크해야함-->
              <div>비밀번호 확인</div>
              <b-input type="password" id="passwordConfirm" placeholder="비밀번호 확인" v-model="passwordConfirm"/>
              <br>
              <div>별명</div>
              <b-input type="text" id="nickName" v-model="user.nickName"/>
              <b-button class="m-1 py-2" block variant="outline-primary" @click="nickNameCheck">중복체크</b-button>
              <br>
              <div>이메일</div>
              <b-input type="email" id="email" v-model="user.email"/>
              <b-button class="m-1 py-2" block variant="outline-primary" @click="emailCheck">중복체크</b-button>
              <br>
              <div>주소</div>
              <b-input type="text" id="address" v-model="user.address"/>
              <br>
              <!-- 이미지-->
              <label for="img">이미지</label>
              <b-container>
                <b-row>
                  <b-col cols="4">
                    <b-form-radio id="img1" v-model="user.img" class="m-1 view" value = "avatar1" /><br />
                    <img :src="require(`../../assets/profile/avatar1.png`)" class="m-2">
                  </b-col>
                  <b-col cols="4">
                    <b-form-radio id="img2" v-model="user.img" class="m-1 view" value = "avatar2" /><br />
                    <img :src="require(`../../assets/profile/avatar2.png`)" class="m-2">
                  </b-col>
                  <b-col cols="4">
                    <b-form-radio id="img3" v-model="user.img" class="m-1 view" value = "avatar3" /><br />
                    <img :src="require(`../../assets/profile/avatar3.png`)" class="m-2">
                  </b-col>
                  <b-col cols="4">
                    <b-form-radio id="img4" v-model="user.img" class="m-1 view" value = "avatar4" /><br />
                    <img :src="require(`../../assets/profile/avatar4.png`)" class="m-2">
                  </b-col>
                  <b-col cols="4">
                    <b-form-radio id="img5" v-model="user.img" class="m-1 view" value = "avatar5" /><br />
                    <img :src="require(`../../assets/profile/avatar5.png`)" class="m-2">
                  </b-col>
                  <b-col cols="4">
                    <b-form-radio id="img6" v-model="user.img" class="m-1 view" value = "avatar6" /><br />
                    <img :src="require(`../../assets/profile/avatar6.png`)" class="m-2">
                  </b-col>
                  <b-col cols="4">
                    <b-form-radio id="img7" v-model="user.img" class="m-1 view" value = "avatar7" /><br />
                    <img :src="require(`../../assets/profile/avatar7.png`)" class="m-2">
                  </b-col>
                  <b-col cols="4">
                    <b-form-radio id="img8" v-model="user.img" class="m-1 view" value = "avatar8" /><br />
                    <img :src="require(`../../assets/profile/avatar8.png`)" class="m-2">
                  </b-col>
                </b-row>
              </b-container>
              <br>
            </div>
            <br>
            <!-- 버튼 위치 정렬 -->
            <div class="d-flex justify-nickName-end">
                <b-button class="m-1" variant="outline-primary" @click="updateUser">수정</b-button>
                <b-button class="m-1" variant="outline-primary" @click="hideModal">취소</b-button>
            </div>
        </b-modal>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
    name: "Mypage",
    computed: {
      ...mapState(["loginUser"]),
      // v-once... 
      ...mapState(["user"]),
      userLevel() {
        if(this.user.user_rank === 1) {
          return true
        } else {
          return false
        }
      },
    },
    data() {
      return {
        password :"",
        passwordConfirm : "",
        // img: "",
      };
    },
    methods: {
      // async setUser(id) {
      //   //console.log(id)
      //   await this.$store.dispatch("setUser", id);
      //   console.log(user);
      // },
      //"" -> ""안에 문자 그대로
      //`` ->문자열 안에 변수를 붙히고 싶다
      updateModalConfirm(){
      let confirm = prompt("회원정보를 수정하고 싶으면 비밀번호를 한 번 더 입력해주세요.","password");

      if(this.user.password=== confirm){
        this.showUpdateModal(this.user);
      } else{
        alert("비밀번호가 일치하지 않습니다.");
      }
    },
      emailCheck(){
        this.$store.dispatch('emailCheck', this.email);   
      },
      nickNameCheck(){
        this.$store.dispatch('nickNameCheck', this.nickName);   
      },
      showUpdateModal(user) {
        const id = user.id
        // this.setUser(id);
        this.$store.dispatch('setUser', id)
        this.$refs['createModal'].show()
      },
      hideModal() {
        this.$refs['createModal'].hide()
      },
      deleteUser(){
        this.$store.dispatch("deleteUser",user.id);
      },
     updateUser() {
      const pathName = new URL(document.location).pathname.split("/");
      const id = pathName[pathName.length - 1];
      if(
          this.password === "" ||
          this.passwordConfirm === "" ||
          this.user.name ==="" ||
          this.user.nickName ==="" ||
          this.user.email ===""||
          this.user.address==="" ||
          this.user.img ===""
      ) {
         alert("빈 칸이 있는지 확인해주세요.");
        return;
        }
        let updatedUser = {
          id: id,
          name: this.user.name,
          nickName: this.user.nickName,
          password: this.password,
          email:this.user.email,
          address:this.user.address,
          img: this.user.img,
        };
        console.log(updatedUser);
        this.$store.dispatch('updateUser', updatedUser);
        // this.$store.dispatch('setUser',id);
        alert("수정 완료~");
        this.$refs['createModal'].hide();
      }
    },

    created() {
      //로그인유저..미리 데이터 받아와서 유저 정보에 사용 // v-once(새로고침할 때만 바뀜)
      const pathName = new URL(document.location).pathname.split("/");
      const id = pathName[pathName.length - 1];
      this.$store.dispatch('setUser', id)
    }
}
</script>

<style scoped>
  img {
    width: 5rem;
  }
  #profile_img{
    width: 35rem;
  }
</style>
