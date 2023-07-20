package com.ssafy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.fit.model.dao.GymDao;
import com.ssafy.fit.model.dao.GymReviewDao;
import com.ssafy.fit.model.dto.Gym;
import com.ssafy.fit.model.dto.GymReview;

@Service
public class GymReviewServiceImpl implements GymReviewService {
	
	@Autowired
	private GymReviewDao gymReviewDao;
	
	@Autowired
	private GymDao gymDao;
	
	// 헬스장 아이디에 해당하는 리뷰 목록
	@Override
	public List<GymReview> getReviewByGymId(int gym_id) {
		return gymReviewDao.selectGR(gym_id);
	}
	
	// 리뷰 조회
	@Override
	public GymReview getGymReview(int review_id) {
		return gymReviewDao.selectOne(review_id);
	}
	
	// 리뷰 등록
	@Transactional
	@Override
	public int insertGymReview(GymReview gymReview) {
		gymDao.updateGymReviewCnt(gymReview.getGym_id(), 1);
		int result = gymReviewDao.insertGR(gymReview);
		setRating(gymReview.getGym_id());
		return result;
	}
	
	// 리뷰 수정
	@Override
	public void updateGymReview(GymReview gymReview) {
		gymReviewDao.updateGR(gymReview);
		setRating(gymReview.getGym_id());
	}
	
	// 리뷰 삭제
	@Transactional
	@Override
	public void deleteGymReview(int review_id) {
		GymReview gymReview = gymReviewDao.selectOne(review_id);
		gymDao.updateGymReviewCnt(gymReview.getGym_id(), -1);
		gymReviewDao.deleteGR(review_id);
		setRating(gymReview.getGym_id());
	}
	
	public void setRating(int id) {
		Double rating_avg = gymReviewDao.getGymRatingAvg(id);
		
		Gym gym = new Gym();
		gym.setId(id);
		gym.setRating_avg(rating_avg);
		
		gymReviewDao.updateRating(gym);
	}

}
