package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.Video;


public interface VideoService {
	//모든 영상 가져오기
	public List<Video> getVideoList();

	// ID에 해당하는 영상 하나 가져오기
	public Video getVideoById(String id);
	
	//운동 부위에 맞는 영상들 가져오기
	public List<Video> getVideoByPart(String part);
	
	//운동 종류에 맞는 영상들 가져오기
	public List<Video> getVideoByCategory(String category);

	//조회수 높은 순으로 영상 가져오기
	public List<Video> getVideoByViewCnt();
	
	//별점 높은 순으로 영상 가져오기
	public List<Video> getVideoByRatingAvg();
	
}
