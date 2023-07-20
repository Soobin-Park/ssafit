<template>
  <div class="container">
    <br />
    <b-jumbotron
      style="background-image: url('https://cdn.pixabay.com/photo/2019/05/19/23/47/clouds-4215608_960_720.jpg');"
      text-variant="white"
    >
      <template #header>SSAFIT</template>
      <template #lead>{{ message }}</template>
      <hr class="my-4">
    </b-jumbotron>
    <br/>
    <b-container>
      <b-row>
        <b-col>
          <b-link to="/video"><img src="../assets/img/video.png" style="width: 15rem"></b-link>
        </b-col>
        <b-col>
          <b-link to="/gym"><img src="../assets/img/maps.png" style="width: 15rem"></b-link>
        </b-col>
        <b-col>
          <b-link to="/board"><img src="../assets/img/talking.png" style="width: 15rem"></b-link>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>

export default {
  name: "Home",
  data() {
    return {
      message: "SSAFIT 사이트에 오신것을 환영합니다.",
    };
  },
  components: {
    
  },
};
</script>
