package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.Gym;
import com.ssafy.fit.model.dto.GymReview;

public interface GymReviewDao {
	// 헬스장 아이디에 해당하는 리뷰 목록
	public List<GymReview> selectGR(int gym_id);
	
	// 리뷰 조회
	public GymReview selectOne(int review_id);
	
	// 리뷰 등록
	public int insertGR(GymReview gymReview);
	
	// 리뷰 수정
	public void updateGR(GymReview gymReview);
	
	// 리뷰 삭제
	public void deleteGR(int review_id);
	
	// 별점 평균 구하기
	public Double getGymRatingAvg(int id);
		
	// 별점 평균 반영하기
	public int updateRating(Gym gym);
}
