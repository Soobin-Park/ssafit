package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.GymReview;

public interface GymReviewService {
	// 헬스장 아이디에 해당하는 리뷰 목록
	public List<GymReview> getReviewByGymId(int gym_id);
	
	// 리뷰 조회
	public GymReview getGymReview(int review_id);
	
	// 리뷰 등록
	public int insertGymReview(GymReview gymReview);
	
	// 리뷰 수정
	public void updateGymReview(GymReview gymReview);
	
	// 리뷰 삭제
	public void deleteGymReview(int review_id);
}
