package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.model.dto.VideoMark;

public interface VideoMarkService {
	// 찜하기
	public int insertVideoMark(VideoMark videoMark);
	
	// 찜 취소
	public int deleteVideoMark(int id);
	
	// 유저가 찜한 영상 목록
	public List<Video> getMarkedVideoList(String user_id);
}
