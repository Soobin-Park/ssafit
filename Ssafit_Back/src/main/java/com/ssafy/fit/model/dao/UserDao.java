package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.User;

public interface UserDao {
	public List<User> selectAll();
	public int insertUser(User user);
	public User selectOne(String id);
	// 아이디 중복 체크
    public int idCheck(String id);
	// 이메일 중복 체크
    public int emailCheck(String email);
	// 닉네임 중복 체크
    public int nickNameCheck(String nickName);
    //회원 정보 수정
    public int updateUser(User user);
    public int deleteUser(String id);

    
}
