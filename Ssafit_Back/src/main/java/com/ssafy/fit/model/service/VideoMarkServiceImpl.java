package com.ssafy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fit.model.dao.VideoMarkDao;
import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.model.dto.VideoMark;

@Service
public class VideoMarkServiceImpl implements VideoMarkService {
	
	@Autowired
	private VideoMarkDao videoMarkDao;
	
	// 찜하기
	@Override
	public int insertVideoMark(VideoMark videoMark) {
		if(videoMarkDao.getVideoMarkCheck(videoMark.getUser_id(), videoMark.getVideo_id()) == 0)
			return videoMarkDao.insertMark(videoMark);
		return 0;
	}
	
	// 찜 취소
	@Override
	public int deleteVideoMark(int id) {
		VideoMark videoMark = videoMarkDao.selectVideoMark(id);
		if(videoMarkDao.getVideoMarkCheck(videoMark.getUser_id(), videoMark.getVideo_id()) != 0)
			return videoMarkDao.deleteMark(videoMark.getId());
		return 0;
	}
	
	// 유저가 찜한 영상 목록
	@Override
	public List<Video> getMarkedVideoList(String user_id) {
		return videoMarkDao.VideoMarkList(user_id);
	}

}
