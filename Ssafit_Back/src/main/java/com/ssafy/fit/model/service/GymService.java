package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.Gym;

public interface GymService {
	// 모든 헬스장 목록
	public List<Gym> getGymList();
	
	// 헬스장 아이디에 해당하는 헬스장 조회
	public Gym getGymById(int id);
	
	// 리뷰 많은 순으로 3개의 헬스장 조회
	public List<Gym> getGymByReviewCnt();
	
	// 별점 높은 순으로 3개의 헬스장 조회
	public List<Gym> getGymByRatingAvg();
}
