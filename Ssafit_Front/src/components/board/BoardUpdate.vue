<template>
  <div class="container">
    <br>
    <div class="row justify-content-center">
      <b-card class="col-7">
        <h2 class="text-center"><b-icon-vector-pen></b-icon-vector-pen> 글 작성</h2>
        <br>
        <div class="m-1">
          <b-input class="m-1" type="text" id="title" v-model="board.title"/>
          <br>
          <b-form-textarea id="content" cols="30" rows="10" v-model="board.content"></b-form-textarea><br>
          <br>
          <div class="row justify-content-center">
            <b-button-group>
              <b-button variant="outline-primary" @click="updateBoard">작성</b-button>
            </b-button-group>
          </div>
        </div>
      </b-card>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: "BoardUpdate",
  computed: {
    ...mapState(['board']),
  },
  methods: {
    updateBoard() {
      let updateBoard = {
        id: this.board.id,
        title: this.board.title,
        content: this.board.content,
      };
      this.$store.dispatch('updateBoard', updateBoard);
    }
  }
}
</script>

<style>

</style>
