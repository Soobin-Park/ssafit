<template>
  <div class="container">
    <h3 class="text-center">
      <b-icon-emoji-smile-fill variant="warning" animation="spin-pulse"></b-icon-emoji-smile-fill>
      운동 부위별 영상</h3>
    <br>
    <div class="row">
      <b-input class="view col-10" type="text" v-model="search"
        placeholder="운동 부위를 입력하세요."
      />
      <b-button class="col-1" variant="outline-primary" @click="searchPart"><b-icon-search></b-icon-search></b-button>
    </div>
    <br />
    <div>
      <div v-if="partVideoCnt">
       <!-- <div>개수 : ${partVideoCnt} 개</div> 변수랑 연동 어케 하지 ... -->
        <b-row cols="1" cols-sm="2" cols-md="4">
            <b-card v-for="(video, index) in partVideos" :key="index"      
            :img-src="`https://i.ytimg.com/vi/${video.id}/hqdefault.jpg`"
            img-top>
            <b-card-body>
                <b-card-title>
                    <b-link :to="`/video/${video.id}`">{{video.title}}</b-link>
                </b-card-title>
            </b-card-body>
            <b-list-group flush>
            <b-list-group-item class = "text-muted"><b-icon-eye></b-icon-eye> {{video.viewCnt}} 회</b-list-group-item>
            <b-list-group-item class = "text-muted"><b-icon-star-fill variant="warning"></b-icon-star-fill> {{video.rating_avg}}</b-list-group-item>
            <br>
            <div class="d-flex justify-content-around">
              <b-card-text class = "small text-muted">{{video.category}}</b-card-text>
              <b-card-text class = "small text-muted">{{video.part}}</b-card-text>
            </div>
            </b-list-group>
            </b-card>
        </b-row>
      </div>
      <div v-else>해당 운동 부위의 영상이 없습니다.</div>
    </div>
    <br />
  </div>
</template>
<script>
import { mapState, mapGetters } from "vuex";
export default {
  name: "PartVideo",
  data() {
    return {
      search: "",
    };
  },
  methods: {
    searchPart() {
      this.$store.dispatch("partVideo", this.search);
    },
  },
  computed: {
    ...mapState(["partVideos"]),
    ...mapGetters(["partVideoCnt"]),
  },
};
</script>
<style scoped>
  .row {
    display: flex;
    justify-content: center;
  }
</style>