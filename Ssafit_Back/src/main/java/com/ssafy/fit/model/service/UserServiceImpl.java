package com.ssafy.fit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.fit.model.dao.UserDao;
import com.ssafy.fit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public int signup(User user) {
		//id 중복 체크해야함!
		int result = userDao.insertUser(user);
		return result;
	}

	@Override
	public User login(String id, String password) {
		User tmp = userDao.selectOne(id);
		if(tmp != null && tmp.getPassword().equals(password))
			return tmp;
		return null;
	}

	@Override
	public User searchById(String id) {
		return userDao.selectOne(id);
	}
	
    @Override
    public int idCheck(String id) {
        return userDao.idCheck(id);
    }

	@Override
	public boolean modifyUser(User user) {
		User originUser = userDao.selectOne(user.getId());
//		originBoard.setTitle(board.getTitle());
//		originBoard.setContent(board.getContent());
		return userDao.updateUser(user) == 1;
	}

	@Override
	public boolean removeUser(String id) {
		return userDao.deleteUser(id) == 1;
		
	}

	@Override
	public int nickNameCheck(String nickName) {
		return userDao.nickNameCheck(nickName);
	}

	@Override
	public int emailCheck(String email) {
		return userDao.emailCheck(email);
	}

}

