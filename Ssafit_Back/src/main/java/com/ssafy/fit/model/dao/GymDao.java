package com.ssafy.fit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.fit.model.dto.Gym;

public interface GymDao {
	// 모든 헬스장 목록
	public List<Gym> selectAll();
	
	// 헬스장 아이디에 해당하는 헬스장 조회
	public Gym selectOne(int id);
	
	// 리뷰 개수 구하기
	public void updateGymReviewCnt(@Param("id") int id, @Param("amount") int amount);
	
	// 리뷰 많은 순으로 3개의 헬스장 조회
	public List<Gym> selectReviewCnt();
	
	// 별점 높은 순으로 3개의 헬스장 조회
	public List<Gym> selectReviewRating();
	
}
