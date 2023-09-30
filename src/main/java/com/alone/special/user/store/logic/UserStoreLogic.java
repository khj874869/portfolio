package com.alone.special.user.store.logic;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.alone.special.user.domain.User;
import com.alone.special.user.store.UserStore;

@Repository
public class UserStoreLogic implements UserStore{
	
	// 회원가입
	@Override
	public int insertUser(SqlSession session, User user) {
		int result = session.insert("UserMapper.insertUser", user);
		return result;
	}
	// 회원정보수정
	@Override
	public int updateUser(SqlSession session, User user) {
		int result = session.update("UserMapper.updateUser", user);
		return result;
	}
	// 회원정보 탈퇴
	@Override
	public int deleteUser(SqlSession session, String userId) {
		int result = session.delete("UserMapper.deleteUser", userId);
		return result;
	}
	// 회원로그인
	@Override
	public int loginUser(SqlSession session, User user) {
		int result = session.selectOne("UserMapper.loginUser", user);
		return result;
	}
	// 회원정보
	@Override
	public User selectOneById(SqlSession session, String userId) {
		User uOne = session.selectOne("UserMapper.selectOneById", userId);
		return uOne;
	}
	// 회원가입 아이디 유효성 체크
	@Override
	public boolean userIdValid(SqlSession session, String userId) {
		int result = session.selectOne("UserMapper.userIdValid", userId);
		return result == 0;
	}
	// 회원가입 이메일 유효성 체크
	@Override
	public boolean userEmailValid(SqlSession session, String userEmail) {
		int result = session.selectOne("UserMapper.userEmailValid", userEmail);
		return result == 0;
	}
	// 회원 아이디 찾기
	@Override
	public String findUserId(SqlSession session, String userEmail) {
		String userId = session.selectOne("UserMapper.findUserId", userEmail);
		return userId;
	}
	// 회원 비밀번호 찾기
	@Override
	public Map<String, String> findUserPw(SqlSession session, String userId, String userEmail) {
		Map<String, String> userPwMap = new HashMap<>();
		userPwMap.put("userId", userId);
		userPwMap.put("userEmail", userEmail);
		
		Map<String, String> userPw = session.selectOne("UserMapper.findUserPw", userPwMap);
		return userPw;
	}
}
