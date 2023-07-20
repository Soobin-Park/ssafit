package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.VideoReview;

public interface VideoReviewService {
	// 영상 아이디에 해당하는 리뷰 목록
	public List<VideoReview> getReviewByVideoId(String video_id);
	
	// 리뷰 조회
	public VideoReview getVideoReview(int review_id);
	
	// 리뷰 등록
	public int insertVideoReview(VideoReview videoReview);
	
	// 리뷰 수정
	public void updateVideoReview(VideoReview videoReview);
	
	// 리뷰 삭제
	public void deleteVideoReview(int review_id);
}
