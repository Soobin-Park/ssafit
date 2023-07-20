<template>
  <footer class="px-4" style="background-color: #B2EBF4">
    <nav class="footer-nav">
      <p class="pt-2">copyright &copy; by SSAFY 9기 서울 5반 박수빈 이지원 </p>
      <p class="pt-2">수빈이의 지원군 도와조~~</p>
    </nav>
  </footer>
</template>

<script>
export default {
  name: "FooterNav",
}
</script>

<style scoped>
footer {
  height: 50px;
  position: relative;
  bottom: 0;
  width: 100%;
  color: whitesmoke;
}

.footer-nav {
  display: flex;
  justify-content: space-between;
}
</style>