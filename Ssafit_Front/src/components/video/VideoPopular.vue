<template>
  <div class="container">
    <div class="row">
      <h3><b-icon-hand-thumbs-up></b-icon-hand-thumbs-up> 조회수 Top 3 영상</h3>
      <b-button class="col-1 mb-2 mx-3" variant="outline-primary" @click="popularVideo"><b-icon-hand-index-thumb></b-icon-hand-index-thumb></b-button>
        <b-row cols="1" cols-sm="2" cols-md="4">
            <b-card v-for="(video, index) in popularVideos" :key="index"      
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
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "PopularVideo",
  methods: {
    popularVideo(){
      this.$store.dispatch("popularVideo");
    },
  },
  computed: {
    ...mapState(["popularVideos"]),
  },
};
</script>
<style scoped>
  .row {
    display: flex;
    justify-content: center;
  }
</style>