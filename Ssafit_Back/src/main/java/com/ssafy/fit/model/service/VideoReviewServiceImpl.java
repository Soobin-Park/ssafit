package com.ssafy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dto.Video;
import com.ssafy.fit.model.dto.VideoReview;

@Service
public class VideoReviewServiceImpl implements VideoReviewService{
	
	@Autowired
	private VideoReviewDao videoReviewDao;
	
	// 영상 아이디에 해당하는 리뷰 목록
	@Override
	public List<VideoReview> getReviewByVideoId(String video_id) {
		return videoReviewDao.selectVR(video_id);
	}
	
	// 리뷰 조회
	@Override
	public VideoReview getVideoReview(int review_id) {
		return videoReviewDao.selectOne(review_id);
	}
	
	// 리뷰 등록
	@Override
	public int insertVideoReview(VideoReview videoReview) {
		int result = videoReviewDao.insertVR(videoReview);
		setRating(videoReview.getVideo_id());
		return result;
	}
	
	// 리뷰 수정
	@Override
	public void updateVideoReview(VideoReview videoReview) {
		videoReviewDao.updateVR(videoReview);
		setRating(videoReview.getVideo_id());
	}
	
	// 리뷰 삭제
	@Override
	public void deleteVideoReview(int review_id) {
		VideoReview videoReview = videoReviewDao.selectOne(review_id);
		videoReviewDao.deleteVR(review_id);
		setRating(videoReview.getVideo_id());
	}
	
	public void setRating(String video_id) {
		Double rating_avg = videoReviewDao.getVideoRatingAvg(video_id);
		
		Video video = new Video();
		video.setId(video_id);
		video.setRating_avg(rating_avg);
		
		videoReviewDao.updateRating(video);
	}

}
