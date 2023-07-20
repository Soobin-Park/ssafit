package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.model.dto.VideoReview;

public interface VideoReviewDao {
	// 영상 아이디에 해당하는 리뷰 목록
	public List<VideoReview> selectVR(String video_id);
	
	// 리뷰 조회
	public VideoReview selectOne(int review_id);
	
	// 리뷰 등록
	public int insertVR(VideoReview videoReview);
	
	// 리뷰 수정
	public void updateVR(VideoReview videoReview);
	
	// 리뷰 삭제
	public void deleteVR(int review_id);
	
	// 별점 평균 구하기
	public Double getVideoRatingAvg(String video_id);
	
	// 별점 평균 반영하기
	public int updateRating(Video video);
}
