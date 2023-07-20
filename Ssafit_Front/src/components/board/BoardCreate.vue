<template>
  <div class="container">
    <br>
    <div class="row justify-content-center">
      <b-card class="col-7">
        <h2 class="text-center"><b-icon-vector-pen></b-icon-vector-pen> 글 작성</h2>
        <br>
        <div class="m-1">
          <b-input class="m-1" type="text" id="title" placeholder="제목" v-model="title"/>
          <br>
          <!-- <input type="hidden" id="writer" v-model="writer"/> -->
          <b-form-textarea id="content" cols="30" rows="10" v-model="content" placeholder="내용"></b-form-textarea><br>
          <br>
          <div class="row justify-content-center">
            <b-button-group>
              <b-button variant="outline-primary" @click="createBoard">작성</b-button>
            </b-button-group>
          </div>
        </div>
      </b-card>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "BoardCreate",
  data() {
    return {
      title: '',
      content: '',
    }
  },
  computed: {
    ...mapState(['loginUser']),
  },
  methods: {
    createBoard() {
      //console.log(this.loginUser);
      if(
        this.title === "" ||
        this.content === ""
      ) {
        alert("빈 칸이 있는지 확인해주세요.")
        return;
      }
      let board = {
        title: this.title,
        writer: this.loginUser.nickName,
        content: this.content,
      };
      this.$store.dispatch('createBoard', board);
    }
  }
}
</script>

<style>

</style>