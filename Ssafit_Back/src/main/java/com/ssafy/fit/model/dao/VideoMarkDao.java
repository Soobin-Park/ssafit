package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.model.dto.VideoMark;

public interface VideoMarkDao {
	// 찜하기
	public int insertMark(VideoMark videoMark);
	
	// 찜했는지 여부
	public int getVideoMarkCheck(String user_id, String video_id);
	
	// 찜 조회 (아이디로)
	public VideoMark selectVideoMark(int id);
	
	// 찜 취소
	public int deleteMark(int id);
	
	// 유저가 찜한 영상 목록
	public List<Video> VideoMarkList(String user_id);
}
