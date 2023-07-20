<template>
    <div class="container">
        <br>
        <h2 class="text-center">전체 영상</h2>
        <br>
        <div>
        <b-row cols="1" cols-sm="3" cols-md="4">
            <b-card v-for="(video, index) in videos" :key="index"      
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
                <b-card-text class="small text-muted">{{video.category}}</b-card-text>
                <b-card-text class="small text-muted">{{video.part}}</b-card-text>
            </div>
            </b-list-group>
            </b-card>
        </b-row>
        <!--제대로 작동 안한다...어찌한담-->
        <b-pagination
      v-model="currentPage"
      :total-rows="videoCnt"
      :per-page="perPage"
      first-number
      last-number
      align="center"
    ></b-pagination>
    </div>

 <!--  <div>{{ $store.state.id }}</div>
   <div>{{ $store.state.nickName }}</div> -->
        <br><hr><br>
        <popular-video></popular-video>
        <br><hr><br>
        <star-video></star-video>
        <br><hr><br>
        <part-video></part-video>
        <br><hr><br>
        <category-video></category-video>
    </div>
</template>

<script>
import PartVideo from "../video/VideoPart.vue";
import CategoryVideo from "../video/VideoCate.vue";
import PopularVideo from "../video/VideoPopular.vue";
import StarVideo from "../video/VideoStar.vue";

import {mapState} from 'vuex';

export default {
    name: "VideoList",
    components:{
        PartVideo,
        CategoryVideo,
        PopularVideo,
        StarVideo
    },
    data(){
        return {
            currentPage: 1,
            perPage: 20,
        };
    },
    methods: {},
    computed: {
        ...mapState(["videos"]),
        ...mapState(["videoCnt"]),
        videoCnt() {
            return this.videos.length
        },
        pageVideoList() {
        return this.videos.slice(
            (this.currentPage-1) * this.perPage,
            this.currentPage * this.perPage
      )
    }
//        ...mapState("id"),
//       ...mapState("nickName"),
    },
    created() {
        this.$store.dispatch("setVideos")
//        this.$store.dispatch("splitAccessToken")
    },
}
</script>

<style>

</style>