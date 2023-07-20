package com.ssafy.fit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.VideoReview;
import com.ssafy.fit.model.service.VideoReviewService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin
@RestController
@Api(tags = "영상 리뷰 컨트롤러")
@RequestMapping("/api-videoReview")
public class VideoReviewRestController {
	
	@Autowired
	private VideoReviewService vrService;
	
	// 영상 아이디에 해당하는 리뷰 목록
	@GetMapping("/review")
	public ResponseEntity<?> getVideoReviews(String video_id) {
		List<VideoReview> list = vrService.getReviewByVideoId(video_id);
		System.out.println(video_id);
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<VideoReview>>(list, HttpStatus.OK);
	}
	
	// 리뷰 조회
	@GetMapping("/review/{review_id}")
	public ResponseEntity<?> getVideoReviewOne(@PathVariable int review_id) {
		VideoReview videoReview = vrService.getVideoReview(review_id);
		return new ResponseEntity<VideoReview>(videoReview, HttpStatus.OK);
	}
	
	// 리뷰 등록
	@PostMapping("/review")
	public ResponseEntity<VideoReview> write(VideoReview videoReview) {
		vrService.insertVideoReview(videoReview);
		return new ResponseEntity<VideoReview>(videoReview, HttpStatus.CREATED);
	}
	
	// 리뷰 수정
	@PutMapping("/review")
	public ResponseEntity<Void> update(@RequestBody VideoReview videoReview) {
		vrService.updateVideoReview(videoReview);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 리뷰 삭제
	@DeleteMapping("/review/{review_id}")
	public ResponseEntity<Void> delete(@PathVariable int review_id) {
		vrService.deleteVideoReview(review_id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
