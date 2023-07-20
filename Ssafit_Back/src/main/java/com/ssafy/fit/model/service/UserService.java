package com.ssafy.fit.model.service;

import java.util.List;

import com.ssafy.fit.model.dto.User;

public interface UserService {
	
	// 전체 회원 조회
	public List<User> getUserList();
	
	//아이디로 회원찾기
	public User searchById(String id);
	
	// 회원 가입
	public int signup(User user);
	public User login(String id, String password);
	// 아이디 중복 체크
    public int idCheck(String id);
	// 닉네임 중복 체크
    public int nickNameCheck(String nickName);
	// 이메일 중복 체크
    public int emailCheck(String email);
    // 회원 정보 수정
    public boolean modifyUser(User user);
    // 회원 탈퇴
    public boolean removeUser(String id);
}

