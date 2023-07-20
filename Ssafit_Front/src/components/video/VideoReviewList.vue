<template>
  <div class="container">
    <br>
    <h2 class="text-center">리뷰 목록
      <b-avatar variant="dark" size="3rem"><template #badge>{{ VideoReviewCnt }}</template></b-avatar></h2>
    <div v-if="VideoReviewCnt">
        <div v-for="(review, index) in VideoReviews" :key="index">
          <b-card class="p-3">
            <div class="row justify-content-start">
              <b-card-text class="m-2">{{ review.writer }}</b-card-text>
              <b-card-text class="m-2">{{ review.createdAt }}</b-card-text>
            </div>
            <br>
            <b-container class="bv-example-row">
              <b-row align-h="between">
                <b-col cols="6" class="d-flex justify-content-start"><h4>{{ review.content }}</h4></b-col>
                <b-col cols="3" class="d-flex justify-content-end"><p class="h4 mb-2"><b-icon icon="star-fill" variant="warning"></b-icon> {{ review.rating }}</p></b-col>
                <b-col cols="3" class="d-flex justify-content-end">
                  <b-button variant="outline-primary" class="m-1" v-if="userCheck(review.writer)" @click="showReviewUpdateModal(review, $event)">수정</b-button>
                  <b-button variant="outline-primary" class="m-1" v-if="userCheck(review.writer)" @click="deleteVideoReview(review, $event)">삭제</b-button>
                </b-col>
              </b-row>
            </b-container>
          </b-card>
          <br>
        </div>
    </div>
    <div v-else>해당 영상에 등록된 리뷰가 없습니다.</div>

    <b-modal ref="updateVideoReviewModal" hide-footer>
      <template #modal-header>
        <p class="h5 mb-2"><b-icon-vector-pen></b-icon-vector-pen> 수정</p>
      </template>
      <div class="d-block text-start">
        <b-input type="text" id="writer" v-model="VideoReview.writer"/>
        <br>
        <b-form-textarea id="content" v-model="VideoReview.content" no-resize></b-form-textarea>
        <br>
        <!-- <b-input type="number" id="rating" v-model="VideoReview.rating"></b-input> -->
        <div class="d-flex justify-content-center">
          <star-rating :border-width="4" border-color="#d8d8d8" 
            id="rating" v-model="VideoReview.rating" :rounded-corners="true"
            :star-points="[23,2, 14,17, 0,19, 10,34, 7,50, 23,43, 38,50, 36,34, 46,19, 31,17]"
          ></star-rating>
        </div>
        <br>
      </div>
      <br>
      <div class="d-flex justify-content-end">
        <b-button class="m-1" variant="outline-primary" @click="updateVideoReview">등록</b-button>
      </div>
    </b-modal>
  </div>
</template>
<script>
import StarRating from 'vue-star-rating'
import { mapState, mapGetters } from "vuex";
export default {
  name: "VideoReviewList",
  components: {
    StarRating,
  },
  methods: {
    deleteVideoReview(review, event) {
      const review_id = review.review_id;
      this.$store.dispatch('deleteVideoReview', review_id)
    },
    showReviewUpdateModal(review, event) {
      console.log(review.review_id)
      const review_id = review.review_id;
      this.$store.dispatch('getVideoReview', review_id)
      this.$refs['updateVideoReviewModal'].show()
    },
    updateVideoReview() {
      const pathName = new URL(document.location).pathname.split("/");
      const videoId = pathName[pathName.length - 1];
      let updateVideoReview = {
        video_id: videoId,
        review_id: this.VideoReview.review_id,
        writer: this.VideoReview.writer,
        content: this.VideoReview.content,
        rating: this.VideoReview.rating,
      };
      this.$store.dispatch('updateVideoReview', updateVideoReview);
      this.$refs['updateVideoReviewModal'].hide();
    },
  },
  computed: {
    ...mapState(["VideoReviews"]),
    ...mapGetters(["VideoReviewCnt"]),
    ...mapState(["VideoReview"]),
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
    const pathName = new URL(document.location).pathname.split("/");
    const videoId = pathName[pathName.length - 1];
    this.$store.dispatch("setVideoReviews", videoId);
    
  },
};
</script>