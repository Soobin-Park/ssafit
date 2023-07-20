package com.ssafy.fit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.model.service.VideoService;

import io.swagger.annotations.Api;

@RestController
@Api(tags ="비디오 컨트롤러")
@RequestMapping("/api-video")
public class VideoRestController {
	
	@Autowired
	private VideoService videoService;
	
	//VIDEO READ
	@GetMapping("list")
	public ResponseEntity<List<Video>> getVideoList(){
		List<Video> videoList = videoService.getVideoList();
		return new ResponseEntity<List<Video>>(videoList,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getVideoById(@PathVariable String id){
		System.out.println(id);
		Video video = videoService.getVideoById(id);
		if(video != null)
			return new ResponseEntity<Video>(video,HttpStatus.OK);
		else
			return new ResponseEntity<String>("아이디에 해당하는 비디오가 없습니다.",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//운동 부위별 영상
	@GetMapping("/list/part/{part}")
	public ResponseEntity<?> getVideoByPart(@PathVariable String part){
		List<Video> videoList = videoService.getVideoByPart(part);
		
		if(videoList == null)
			return new ResponseEntity<String>("해당 운동 부위에 맞는 영상이 없습니다.",HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<List<Video>>(videoList,HttpStatus.OK);
			
	}
	
	//운동 종류별 영상
	@GetMapping("/list/category/{category}")
	public ResponseEntity<?> getVideoByCategory(@PathVariable String category){
		List<Video> videoList = videoService.getVideoByCategory(category);
		
		if(videoList == null)
			return new ResponseEntity<String>("해당 운동 종류에 맞는 영상이 없습니다.",HttpStatus.INTERNAL_SERVER_ERROR);
		else
			return new ResponseEntity<List<Video>>(videoList,HttpStatus.OK);
			
	}
		
	//조회수 높은 순 영상
	@GetMapping("/list/viewCnt")
	public ResponseEntity<List<Video>> getVideoByViewCnt(){
		List<Video> videoList = videoService.getVideoByViewCnt();
		return new ResponseEntity<List<Video>>(videoList,HttpStatus.OK);
	}
	
	//별점 높은 순 영상
	@GetMapping("/list/rating_avg")
	public ResponseEntity<List<Video>> getVideoByRatingAvg(){
		List<Video> videoList = videoService.getVideoByRatingAvg();
		return new ResponseEntity<List<Video>>(videoList,HttpStatus.OK);
	}
		
}
