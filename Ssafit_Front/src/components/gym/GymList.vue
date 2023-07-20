<template>
  <div class="container">
    <br>
    <div class="d-flex justify-content-center">
      <b-card class="text-center">
        <br>
        <h2><img src="../../assets/img/physical-wellbeing.png" style="width: 3rem"> 헬스장</h2>
        <br>
        <div id="map" style="width:500px;height:400px;"></div>
        <br>
        <b-card-text>마커를 눌러보세요!
          <b-icon-hand-index-thumb></b-icon-hand-index-thumb>
        </b-card-text>
      </b-card>
    </div>
    <br>
    <div class="d-flex justify-content-around">
      <b-link to="/gym/star">별점 Top3 보러가기</b-link>
      <b-link to="/gym/mostreview">리뷰 Top3 보러가기</b-link>
    </div>
  </div>
</template>
<script>

import {mapState} from 'vuex';

  export default {
    name: "GymList",
    data() {
      return {
        map:null
      }
    },
    created() {
      this.$store.dispatch("getGymList")
    },
    mounted() {
      if(window.kakao && window.kakao.maps) {
        // 카카오 객체 있고, 카카오 맵그릴 준비 되어 있다면 맵 실행
        this.loadMap();
      } else {
        // 없다면 카카오 스크립트 추가 후 맵 실행
        this.loadScript();
      }
    },
    computed: {
      ...mapState(['gyms']),
    },
    methods: {
      loadScript() {
        const script = document.createElement("script");
        script.src = "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=8606d1d0c31fca9a95b2633a2ac23315&libraries=services";
        // &autoload=false api를 로드한 후 맵 그리는 함수가 실행되도록 구현
        script.onload = () => window.kakao.maps.load(this.loadMap);
        // 스크립트 로드 끝나면 지도를 실행될 준비가 되어 있다면 지도 실행되도록 구현
        document.head.appendChild(script); // html>head 안에 스크립트 소스 추가
      },
      loadMap() {
        const container = document.getElementById("map"); // 지도 담을 DOM 영역
        const options = {
          // 지도 생성할 때 필요한 기본 옵션
          center: new window.kakao.maps.LatLng(37.50128968577396, 127.03963859322724), // 지도의 중심좌표
          level: 5, // 지도의 레벨(확대, 축소 정도)
        };

        var map = new window.kakao.maps.Map(container, options); // 지도 생성 및 객체 리턴
        // console.log(this.gyms)

        // this.loadMaker();
        var geocoder = new window.kakao.maps.services.Geocoder();
        this.gyms.forEach(function(addr, index) {
          // var address = addr.address
          // console.log(address)
          geocoder.addressSearch(addr.address, function(result, status) {
            if(status === window.kakao.maps.services.Status.OK) {
              var coords = new window.kakao.maps.LatLng(result[0].y, result[0].x);
              console.log(coords)
              var marker = new window.kakao.maps.Marker({
                map: map,
                position: coords,
                clicable: true
              });
              // 인포윈도우 생성
              var infowindow = new window.kakao.maps.InfoWindow({
                content: '<div style="width:150px;text-align:center;padding:6px 0;">' + addr.name + '</div>',
                removable: true
              })
              window.kakao.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map, marker)
              })
            }
          })
        })
      },
      
      // loadMaker() {
        
      // },
    }
  }
  
</script>
