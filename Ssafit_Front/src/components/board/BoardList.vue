<template>
  <div class="container">
    <br>
    <h2 class="text-center">SSAFIT 커뮤니티
      <img src="../../assets/img/talking_line.png" style="width: 3rem">
    </h2>
    <div>
      <b-table-simple>
        <b-thead>
          <b-tr>
            <b-th></b-th>
            <b-th>제목</b-th>
            <b-th>작성자</b-th>
            <b-th>조회</b-th>
            <b-th>작성일</b-th>
          </b-tr>
        </b-thead>
        <b-tbody>
          <b-tr v-for="board in pageBoardList" :key="board.id">
            <b-td>{{ board.id }}</b-td>
            <b-td><b-link :to="`/board/${board.id}`">{{ board.title }} </b-link>
            <b-badge variant="primary">{{ board.commentCnt }}</b-badge></b-td>
            <b-td>{{ board.writer }}</b-td>
            <b-td>{{ board.viewCnt }}</b-td>
            <b-td>{{ board.createdAt }}</b-td>
          </b-tr>
        </b-tbody>
      </b-table-simple>
    </div>
    <b-pagination
      v-model="currentPage"
      :total-rows="boardCnt"
      :per-page="perPage"
      first-number
      last-number
      align="center"
    ></b-pagination>
    <div class="row justify-content-between">
      <b-form inline>
        <b-form-select v-model="mode">
          <b-form-select-option value="1">제목</b-form-select-option>
          <b-form-select-option value="2">내용</b-form-select-option>
          <b-form-select-option value="3">제목+내용</b-form-select-option>
        </b-form-select>
        <b-form-input type="text" v-model="keyword"/>
        <b-button variant="outline-primary" @click="search"><b-icon-search></b-icon-search></b-button>
      </b-form>
      <b-button variant="outline-primary" @click="moveCreate"><b-icon-vector-pen></b-icon-vector-pen></b-button>
    </div>
  </div>
</template>

<script>
import { mapState } from 'vuex';

export default {
  name: "BoardList",
  data() {
    return {
      currentPage: 1,
      perPage: 20,
      mode: 1,
      keyword: '',
    }
  },
  computed: {
    ...mapState(['boards']),
    boardCnt() {
      return this.boards.length
    },
    pageBoardList() {
      return this.boards.slice(
        (this.currentPage-1) * this.perPage,
        this.currentPage * this.perPage
      )
    }
  },
  created() {
    this.$store.dispatch('getBoards');
  },
  methods: {
    search() {
      const payload = {
        mode: this.mode,
        keyword: this.keyword,
      };
      this.$store.dispatch('getBoards', payload);
    },
    moveCreate() {
      this.$router.push({ name: 'BoardCreate' })
    },
  }
}
</script>

<style>

</style>
