<template>
  <div class="container">
    <br>
    <b-card class="p-3">
      <b-card-title>{{ board.title }}</b-card-title>
      <div class="row justify-content-between">
        <div class="row justify-content-between p-1">
          <img :src="require(`../../assets/profile/${wimg}.png`)" class="m-2">
          <b-card-text class="small text-muted pt-4">{{ board.writer }}</b-card-text>
        </div>
        <div class="row justify-content-between p-1">
          <b-card-text class="small text-muted m-2 pt-3"><b-icon-calendar/> {{ board.createdAt }}</b-card-text>
          <b-card-text class="small text-muted m-2 pt-3"><b-icon-eye/> {{ board.viewCnt }}</b-card-text>
          <b-card-text class="small text-muted m-2 pt-3"><b-icon-chat-dots/> {{ board.commentCnt }}</b-card-text>
        </div>
      </div>
      <hr>
      <br>
      <div>
        {{ board.content }}
      </div>
      <br>
    </b-card>
    <div class="d-flex justify-content-end">
      <b-button variant="outline-primary" class="m-1" v-if="userCheck(board.writer)" @click="moveUpdate">수정</b-button>
      <b-button variant="outline-primary" class="m-1" v-if="userCheck(board.writer)" @click="showModal">삭제</b-button>
    </div>

    <b-modal ref="deleteModal" hide-footer>
      <template #modal-header>
        <p class="h5 mb-2"><b-icon icon="exclamation-circle-fill" variant="danger"></b-icon> 경고</p>
      </template>
      <div class="d-block text-start">
        <h4>정말 삭제하시겠습니까?</h4>
      </div>
      <br>
      <div class="d-flex justify-content-end">
        <b-button class="m-1" variant="outline-primary" @click="deleteBoard">예</b-button>
        <b-button class="m-1" variant="outline-primary" @click="hideModal">아니요</b-button>
      </div>
    </b-modal>

    <br>
    <h6><b-icon-chat-dots/> 댓글 {{ board.commentCnt }}</h6>
    <b-card class="p-3">
      <div v-for="(comment, index) in comments" :key="index">
        <div class="d-flex">
          <h6 class="m-1">{{ comment.writer }}</h6>
          <small class="m-1">{{ comment.createdAt}}</small>
        </div>
        <br>
        <b-container class="bv-example-row">
          <b-row align-h="between">
            <b-col cols="9" >{{ comment.content }}</b-col>
            <b-col cols="3">
              <div class="d-flex justify-content-center">
            <b-button class="p-1 m-1" size="sm" variant="outline-primary" v-if="userCheck(comment.writer)" @click="showUpdateModal(comment, $event)">수정</b-button>
            <b-button class="p-1 m-1" size="sm" variant="outline-primary" v-if="userCheck(comment.writer)" @click="deleteComment(comment, $event)">삭제</b-button>
          </div>
            </b-col>
          </b-row>
        </b-container>
        <hr>
      </div>
      <br>
      <!-- <b-input type="text" id="writer" placeholder="작성자" v-model="writer"/> -->
      <div class="d-flex justify-content-between">
        <b-form-textarea id="content" placeholder="내용" v-model="content" no-resize style="width: 85%;"/>
        <b-button variant="outline-primary" class="py-1" @click="createComment">등록</b-button>
      </div>
    </b-card>
    
    <b-modal ref="updateCommentModal" hide-footer>
      <template #modal-header>
        <p class="h5 mb-2"><b-icon icon="chat-square-text" variant="primary"></b-icon> 수정</p>
      </template>
      <div class="d-block text-start">
        <b-form-textarea id="content" v-model="comment.content" no-resize ></b-form-textarea><br>
      </div>
      <br>
      <div class="d-flex justify-content-end">
        <b-button class="m-1" variant="outline-primary" @click="updateComment">등록</b-button>
      </div>
      <!--취소도 있으면 좋겠다-->
    </b-modal>

    
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: "BoardDetail",
  data() {
    return {
      writer: '',
      content: '',
    }
  },
  computed: {
    ...mapState(['board']),
    ...mapState(['comments']),
    ...mapState(['wimg']),
    ...mapState(['comment']),
    ...mapState(['loginUser']),
    userCheck(){
      return(writer) => {
      let temp = JSON.parse(localStorage.getItem("vuex")).loginUser.nickName
        //console.log(temp);
        //console.log(typeof(temp));
      if ( temp === writer){
        return true;
      } else {
        return false;
      }
    };
    },
  },
  created() {
    const pathName = new URL(document.location).pathname.split('/');
    const id = pathName[pathName.length-1]
    this.$store.dispatch('getBoard', id);
    this.$store.dispatch('getWriterImg', id);
    this.$store.dispatch('getComments', id);
  },
  methods: {
    showModal() {
      this.$refs['deleteModal'].show()
    },
    hideModal() {
      this.$refs['deleteModal'].hide()
    },
    moveUpdate() {
      this.$router.push({ name: 'BoardUpdate' });
    },
    deleteBoard() {
      this.$store.dispatch('deleteBoard', this.board.id);
    },
    createComment() {
      const pathName = new URL(document.location).pathname.split('/');
      const id = pathName[pathName.length-1] // 글 아이디
      let comment = {
        board_id: id,
        writer: this.loginUser.nickName,
        content: this.content,
      };

      this.$store.dispatch('createComment', comment);
    },
    deleteComment(comment, event) {
      const comment_id = comment.comment_id;
      this.$store.dispatch('deleteComment', comment_id)
    },
    showUpdateModal(comment, event) {
      const comment_id = comment.comment_id;
      this.$store.dispatch('getComment', comment_id)
      this.$refs['updateCommentModal'].show()
    },
    updateComment() {
      let updateComment = {
        comment_id: this.comment.comment_id,
        content: this.comment.content,
      };
      this.$store.dispatch('updateComment', updateComment);
    },
  }
}
</script>

<style scoped>
  img {
    width: 3rem;
  }
</style>