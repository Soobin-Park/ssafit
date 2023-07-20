package com.ssafy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fit.model.dao.VideoDao;
import com.ssafy.fit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoDao videoDao;
	
	@Override
	public List<Video> getVideoList() {
		return videoDao.selectAll();
	}

	@Override
	public Video getVideoById(String id) {
		return videoDao.selectOne(id);
	}

	@Override
	public List<Video> getVideoByCategory(String category) {
		return videoDao.selectCategory(category);
	}

	@Override
	public List<Video> getVideoByViewCnt() {
		return videoDao.selectViewCnt();
	}

	@Override
	public List<Video> getVideoByPart(String part) {
		return videoDao.selectPart(part);
	}

	@Override
	public List<Video> getVideoByRatingAvg() {
		return videoDao.selectRatingAvg();
	}



}
