package com.alone.special.user.store;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.alone.special.user.domain.User;

public interface UserStore {
	/**
	 * 회원가입 store
	 * @param session
	 * @param user
	 * @return
	 */
	int insertUser(SqlSession session, User user);
	/**
	 * 회원정보수정 store
	 * @param session
	 * @param user
	 * @return
	 */
	int updateUser(SqlSession session, User user);
	/**
	 * 회원정보 탈퇴 store
	 * @param session
	 * @param userId
	 * @return
	 */
	int deleteUser(SqlSession session, String userId);
	/**
	 * 회원로그인 store
	 * @param session
	 * @param user
	 * @return
	 */
	int loginUser(SqlSession session, User user);
	/**
	 * 회원정보 store
	 * @param session
	 * @param userId
	 * @return
	 */
	User selectOneById(SqlSession session, String userId);
	/**
	 * 회원가입 아이디 유효성 체크 store
	 * @param userId
	 * @return
	 */
	boolean userIdValid(SqlSession session, String userId);
	/**
	 * 회원가입 이메일 유효성 체크 store
	 * @param session
	 * @param userEmail
	 * @return
	 */
	boolean userEmailValid(SqlSession session, String userEmail);
	/**
	 * 회원 아이디 찾기 store
	 * @param session
	 * @param userEmail
	 * @return
	 */
	String findUserId(SqlSession session, String userEmail);
	/**
	 * 회원 비밀번호 찾기 store
	 * @param session
	 * @param userId
	 * @param userEmail
	 * @return
	 */
	Map<String, String> findUserPw(SqlSession session, String userId, String userEmail);
}
