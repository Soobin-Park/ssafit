package com.ssafy.fit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.Gym;
import com.ssafy.fit.model.service.GymService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "헬스장 컨트롤러")
@RequestMapping("/api-gym")
public class GymRestController {
	
	@Autowired
	private GymService gymService;
	
	// 모든 헬스장 목록
	@GetMapping("/gym")
	public ResponseEntity<List<Gym>> getGymList() {
		List<Gym> gymList = gymService.getGymList();
		return new ResponseEntity<List<Gym>>(gymList, HttpStatus.OK);
	}
	
	// 헬스장 아이디에 해당하는 헬스장 조회
	@GetMapping("/{id}")
	public ResponseEntity<?> getGymById(@PathVariable int id) {
		Gym gym = gymService.getGymById(id);
		if(gym != null)
			return new ResponseEntity<Gym>(gym, HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	// 리뷰 많은 순 헬스장
	@GetMapping("/gym/reviewCnt")
	public ResponseEntity<List<Gym>> getGymByReviewCnt() {
		List<Gym> gymList = gymService.getGymByReviewCnt();
		return new ResponseEntity<List<Gym>>(gymList, HttpStatus.OK);
	}
	
	// 별점 높은 순 헬스장
	@GetMapping("/gym/rating_avg")
	public ResponseEntity<List<Gym>> getGymByRatingAvg() {
		List<Gym> gymList = gymService.getGymByRatingAvg();
		return new ResponseEntity<List<Gym>>(gymList, HttpStatus.OK);
	}
}
