<template>
  <div class="container">
      <br>
      <b-card>
        <div class="row justify-content-center">
            <iframe
                width="560"
                height="315"
                :src="videoURL"
                title="YouTube video player"
                frameborder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                allowfullscreen
            >
            </iframe>
        </div>
        <br>
        <div class="d-flex justify-content-center">
            <b-card-title><b-icon-youtube variant="danger"></b-icon-youtube> {{video.title}}</b-card-title>
        </div>
        <b-row align-h="center">
            <b-col cols="6" class="d-flex justify-content-between">
                <b-card-text class="text-muted m-2 pt-3">{{ video.category }}</b-card-text>
                <b-card-text class="text-muted m-2 pt-3">{{ video.part }}</b-card-text>
            </b-col>
        </b-row>
        <b-row align-h="center">
            <b-col cols="6" class="d-flex justify-content-between">
                <b-card-text class="text-muted m-2 pt-3"><b-icon-eye></b-icon-eye> {{ video.viewCnt }} 회</b-card-text>
                <b-card-text class="text-muted m-2 pt-3"><b-icon-star-fill variant="warning"></b-icon-star-fill> {{ video.rating_avg }}</b-card-text>
            </b-col>
        </b-row>
      </b-card>
        <br>
        <div class="d-flex justify-content-end">
            <b-button variant="outline-primary" @click="showReviewModal">리뷰작성</b-button>
        </div>
        <video-review-list :id="`${video.id}`"></video-review-list>

        <b-modal ref="createModal" hide-footer>
            <template #modal-header>
                <p class="h5 mb-2"><b-icon-vector-pen></b-icon-vector-pen> 리뷰</p>
            </template>
            <div class="d-block text-start">
                <!-- <b-input type="text" id="writer" placeholder="작성자" v-model="writer"/>
                <br> -->
                <b-form-textarea id="content" v-model="content" no-resize placeholder="내용을 입력하세요."></b-form-textarea>
                <br>
                <div class="d-flex justify-content-center">
                    <star-rating :border-width="4" border-color="#d8d8d8" 
                        id="rating" v-model="rating" :rounded-corners="true"
                        :star-points="[23,2, 14,17, 0,19, 10,34, 7,50, 23,43, 38,50, 36,34, 46,19, 31,17]"
                    ></star-rating>
                </div>
                <br>
            </div>
            <br>
            <div class="d-flex justify-content-end">
                <b-button class="m-1" variant="outline-primary" @click="createVideoReview">작성</b-button>
                <b-button class="m-1" variant="outline-primary" @click="hideModal">취소</b-button>
            </div>
        </b-modal>
  </div>
</template>

<script>
import StarRating from 'vue-star-rating'
import VideoReviewList from ".//VideoReviewList.vue";

import { mapState } from "vuex";

export default {
    name: "VideoDetail",
    components: {
        VideoReviewList,
        StarRating,
    },
    data() {
        return {
            content: '',
            rating: 0,
        }
    },
    methods: {
        async setVideo(id) {
            await this.$store.dispatch("setVideo", id);
        },
        //"" -> ""안에 문자 그대로
        //`` ->문자열 안에 변수를 붙히고 싶다
        moveCreate() {
            const videoId = this.video.id
            this.$router.push(`/video/create`)
        },
        showReviewModal() {
            this.$refs['createModal'].show()
        },
        hideModal() {
            this.$refs['createModal'].hide()
        },
        createVideoReview() {
            const pathName = new URL(document.location).pathname.split("/");
            const id = pathName[pathName.length - 1];
            if(
                this.content === "" ||
                this.rating === 0
            ) {
                alert("빈 칸이 있는지 확인해주세요.")
                return;
            }
            let videoReview = {
                video_id: id,
                writer: this.loginUser.nickName,
                content: this.content,
                rating: this.rating,
            };
            this.$store.dispatch('createVideoReview', videoReview);
            this.$refs['createModal'].hide()
            this.$router.go(0)
        }
    },
    computed: {
        ...mapState(["video"]),
        ...mapState(['loginUser']),
        videoURL() {
            const videoId = this.video.id;
            return `https://www.youtube.com/embed/${videoId}`
        },
    },
    created() {
        const pathName = new URL(document.location).pathname.split("/");
        const id = pathName[pathName.length - 1];
        this.setVideo(id);
    }
}
</script>

<style>

</style>