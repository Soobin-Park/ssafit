<template>
  <div id="app">
    <header-nav/>
    <router-view id="wrap"/>
    <footer-nav />
  </div>
</template>
<script>
import HeaderNav from "@/components/common/HeaderNav.vue";
import FooterNav from "@/components/common/FooterNav.vue";
export default {
  name: "App",
  components: {
    HeaderNav,
    FooterNav,
  },
};
</script>
<style>
/* @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic:wght@400;700;800&display=swap');
#app {
  font-family: 'Nanum Gothic', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}
.text-center {
  text-align: center;
}
.container {
  margin: 0px 30px;
}
#wrap {
  min-height: 100%;
  position: relative;
  padding-bottom: 300px;
}
</style>
