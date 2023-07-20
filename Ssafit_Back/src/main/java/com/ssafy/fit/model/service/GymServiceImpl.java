package com.ssafy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fit.model.dao.GymDao;
import com.ssafy.fit.model.dto.Gym;

@Service
public class GymServiceImpl implements GymService {
	
	@Autowired
	private GymDao gymDao;
	
	// 모든 헬스장 목록
	@Override
	public List<Gym> getGymList() {
		return gymDao.selectAll();
	}
	
	// 헬스장 아이디에 해당하는 헬스장 조회
	@Override
	public Gym getGymById(int id) {
		return gymDao.selectOne(id);
	}
	
	// 리뷰 많은 순으로 3개의 헬스장 조회
	@Override
	public List<Gym> getGymByReviewCnt() {
		return gymDao.selectReviewCnt();
	}
	
	// 별점 높은 순으로 3개의 헬스장 조회
	@Override
	public List<Gym> getGymByRatingAvg() {
		return gymDao.selectReviewRating();
	}
	
}
