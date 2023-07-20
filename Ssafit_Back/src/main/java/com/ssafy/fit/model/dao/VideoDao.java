package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.SearchCondition;
import com.ssafy.fit.model.dto.Video;

public interface VideoDao {
	//영상 모두 가져오기
	public List<Video> selectAll();

	// ID에 해당하는 영상 하나 가져오기
	public Video selectOne(String id);
	
	//운동 부위에 맞는 영상 가져오기
	public List<Video> selectPart(String part);
	
	//운동 종류에 맞는 영상 가져오기
	public List<Video> selectCategory(String category);
	
	//조회수 많은 순으로 영상 가져오기
	public List<Video> selectViewCnt();

	//별점 높은 순으로 영상 가져오기
	public List<Video> selectRatingAvg();
}
