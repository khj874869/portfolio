package com.alone.special.user.service.impl;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alone.special.user.domain.User;
import com.alone.special.user.service.UserService;
import com.alone.special.user.store.UserStore;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private SqlSession session;
	@Autowired
	private UserStore uStore;
	
	// 회원가입
	@Override
	public int insertUser(User user) {
		int result = uStore.insertUser(session, user);
		return result;
	}
	// 회원정보수정
	@Override
	public int updateUser(User user) {
		int result = uStore.updateUser(session, user);
		return result;
	}
	// 회원정보 탈퇴
	@Override
	public int deleteUser(String userId) {
		int result = uStore.deleteUser(session, userId);
		return result;
	}
	// 회원로그인
	@Override
	public int loginUser(User user) {
		int result = uStore.loginUser(session, user);
		return result;
	}
	// 회원정보
	@Override
	public User selectOneById(String userId) {
		User uOne = uStore.selectOneById(session, userId);
		return uOne;
	}
	// 회원가입 아이디 유효성 체크
	@Override
	public boolean userIdValid(String userId) {
		return uStore.userIdValid(session, userId);
	}
	// 회원가입 이메일 유효성 체크
	@Override
	public boolean userEmailValid(String userEmail) {
		return uStore.userEmailValid(session, userEmail);
	}
	// 회원 아이디 찾기
	@Override
	public String findUserId(String userEmail) {
		String userId = uStore.findUserId(session, userEmail);
		return (userId != null) ? userId : null;
	}
	// 회원 비밀번호 찾기
	@Override
	public Map<String, String> findUserPw(String userId, String userEmail) {
		Map<String, String> userPw = uStore.findUserPw(session, userId, userEmail);
		return userPw;
	}
}
