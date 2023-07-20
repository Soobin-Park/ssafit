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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.model.dto.VideoMark;
import com.ssafy.fit.model.service.VideoMarkService;

import io.swagger.annotations.Api;

@CrossOrigin
@RestController
@Api(tags = "영상 찜 컨트롤러")
@RequestMapping("/api-videoMark")
public class VideoMarkRestController {
	
	@Autowired
	private VideoMarkService vmService;
	
	// 찜하기
	@PostMapping("/mark")
	public ResponseEntity<?> addVideoMark(VideoMark videoMark) {
		int result = vmService.insertVideoMark(videoMark);
		if(result != 0)
			return new ResponseEntity<String>("mark success", HttpStatus.CREATED);
		return new ResponseEntity<String>("already marked", HttpStatus.BAD_REQUEST);
	}
	
	// 찜 취소
	@DeleteMapping("/mark/{id}")
	public ResponseEntity<?> deleteVideoMark(@PathVariable int id){
		int result = vmService.deleteVideoMark(id);
		if(result != 0)
			return new ResponseEntity<String>("cancel mark success", HttpStatus.OK);
		return new ResponseEntity<String>("Not marked", HttpStatus.BAD_REQUEST);
	}
	
	// 유저가 찜한 영상 목록
	@GetMapping("/mark")
	public ResponseEntity<List<Video>> getVideoMarkList(String user_id) {
		List<Video> list = vmService.getMarkedVideoList(user_id);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
}
