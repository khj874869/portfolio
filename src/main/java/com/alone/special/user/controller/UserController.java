package com.alone.special.user.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alone.special.user.domain.User;
import com.alone.special.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	// 회원가입 페이지
	@RequestMapping(value="/user/register.do", method=RequestMethod.GET)
	public ModelAndView registerForm(ModelAndView mv) {
		mv.setViewName("user/register");
		return mv;
	}
	// 회원가입
	@RequestMapping(value="/user/register.do", method=RequestMethod.POST)
	public ModelAndView registerUser(ModelAndView mv, @ModelAttribute User user) {
		try {
			int result = service.insertUser(user);
			if(result > 0) {
				// 성공
				mv.setViewName("redirect:/index.jsp");
			}else {
				mv.addObject("msg", "회원가입 실패");
				mv.addObject("error", "회원가입 실패");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	// 회원가입 아이디 유효성체크
	@RequestMapping(value="/user/checkUserId.do", method=RequestMethod.POST)
	@ResponseBody
	public String checkUserId(@RequestParam("userId") String userId) {
		// 아이디 중복체크 수행
		boolean userIdValid = service.userIdValid(userId);
		return userIdValid ? "valid" : "invalid";
	}
	// 회원가입 이메일 유효성체크
	@RequestMapping(value="/user/checkUserEmail.do", method=RequestMethod.POST)
	@ResponseBody
	public String checkUserEmail(@RequestParam("userEmail") String userEmail) {
		// 아이디 중복체크 수행
		boolean userEmailValid = service.userEmailValid(userEmail);
		return userEmailValid ? "valid" : "invalid";
	}
	// 회원정보 페이지
	@RequestMapping(value="/user/mypage.do", method=RequestMethod.POST)
	public ModelAndView mypageForm(ModelAndView mv, HttpSession session) {
		try {
			String userId = (String)session.getAttribute("userId");
			User uOne = service.selectOneById(userId);
			if(userId != "" && userId != null) {
				// 성공
				uOne = service.selectOneById(userId);
			}if(uOne != null) {
				mv.addObject("user", uOne);
				mv.setViewName("user/mypage");
			}else {
				mv.addObject("msg", "회원정보 불러오기 실패");
				mv.addObject("error", "회원정보 불러오기 실패");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	// 회원정보 업데이트
	@RequestMapping(value="/user/update.do", method=RequestMethod.POST)
	public ModelAndView modifyUser(ModelAndView mv, @ModelAttribute User user) {
		try {
			int result = service.updateUser(user);
			if(result > 0) {
				// 성공
				mv.setViewName("redirect:/index.jsp");
			}else {
				// 실패
				mv.addObject("msg", "회원정보 수정 실패");
				mv.addObject("error", "회원정보 수정 실패");
				mv.addObject("url", "/user/mypage.do?userId"+user.getUserId());
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	// 회원정보 탈퇴
	@RequestMapping(value="/user/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteUser(ModelAndView mv, @RequestParam("userId") String userId) {
		try {
			int result = service.deleteUser(userId);
			if(result > 0) {
				// 성공
				mv.setViewName("redirect:/user/logout.do");
			}else {
				// 실패
				mv.addObject("msg", "회원정보 삭제 실패");
				mv.addObject("error", "회원정보 삭제 실패");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	// 회원로그인 페이지
	@RequestMapping(value="/user/login.do", method=RequestMethod.GET)
	public ModelAndView loginForm(ModelAndView mv) {
		// 로그인 페이지 이동
		mv.setViewName("user/login");
		return mv;
	}
	// 회원로그인
	@RequestMapping(value="/user/login.do", method=RequestMethod.POST)
	public ModelAndView loginUser(ModelAndView mv, @ModelAttribute User user, HttpSession session) {
		try {
			int result = service.loginUser(user);
			if(result > 0) {
				// 성공
				session.setAttribute("userId", user.getUserId());
				mv.setViewName("redirect:/index.jsp");
			}else {
				// 실패
				mv.addObject("msg", "로그인 실패");
				mv.addObject("error", "로그인 실패");
				mv.addObject("url", "/user/login.do");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	// 회원로그아웃
	@RequestMapping(value="/user/logout.do", method=RequestMethod.GET)
	public ModelAndView logoutUser(ModelAndView mv, HttpSession session) {
		if(session != null) {
			// 성공
			session.invalidate();
			mv.setViewName("redirect:/index.jsp");
		}else {
			// 실패
			mv.addObject("msg", "로그아웃 실패");
			mv.addObject("error", "로그아웃 실패");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	// 회원 아이디 찾기 페이지
	@RequestMapping(value="/user/findUserId.do", method=RequestMethod.GET)
	public ModelAndView findUserIdForm(ModelAndView mv) {
		mv.setViewName("user/findUserId");
		return mv;
	}
	// 회원 아이디 찾기
	@RequestMapping(value="/user/findUserId.do", method=RequestMethod.POST)
	public ModelAndView findUserId(ModelAndView mv, @RequestParam("userEmail") String userEmail, HttpSession session) {
		try {
			String userId = service.findUserId(userEmail);
			if(userId != null) {
				session.setAttribute("userId", userId);
				mv.setViewName("user/findUserIdResult");
			}else {
				mv.addObject("msg", "입력하신 이메일로 가입된 아이디는 없습니다");
				mv.addObject("error", "아이디 찾기 실패");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("user/findUserIdResult");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	// 회원 아이디 찾기 결과 페이지
	@RequestMapping(value="/user/findUserIdResult.do", method=RequestMethod.GET)
	public ModelAndView findUserIdResult(ModelAndView mv
								, @RequestParam("userEmail") String userEmail
								, HttpSession session) {
//		String userId = (String) session.getAttribute("userId");
		String userId = service.findUserId(userEmail);
		mv.addObject("userId", userId); 
	    mv.setViewName("/user/findUserIdResult");
	    return mv;
	}
	// 회원 비밀번호 찾기 페이지
		@RequestMapping(value="/user/findUserPw.do", method=RequestMethod.GET)
		public ModelAndView findUserPwForm(ModelAndView mv) {
			mv.setViewName("user/findUserPw");
			return mv;
		}
	// 회원 비밀번호 찾기
	@RequestMapping(value="/user/findUserPw.do", method=RequestMethod.POST)
	public ModelAndView findUserPw(ModelAndView mv, @RequestParam("userId") String userId, @RequestParam("userEmail") String userEmail, HttpSession session) {
		try {
			Map<String, String> userPw = service.findUserPw(userId, userEmail);
			if(userPw != null) {
				session.setAttribute("userPw", userPw);
				mv.setViewName("user/findUserPwResult");
			}else {
				mv.addObject("msg", "입력하신 아이디와 이메일로 가입된 아이디는 없습니다");
				mv.addObject("error", "비밀번호 찾기 실패");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("user/findUserPwResult");
			}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의 바랍니다");
			mv.addObject("error", e.getMessage());
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	// 회원 비밀번호 찾기 결과 페이지
	@RequestMapping(value="/user/findUserPwResult.do", method=RequestMethod.GET)
	public ModelAndView findUserPwResult(ModelAndView mv
								, @RequestParam("userId") String userId
								, @RequestParam("userEmail") String userEmail
								, HttpSession session) {
		Map<String, String> userPw = service.findUserPw(userId, userEmail);
		mv.addObject("userPw", userPw);
	    mv.setViewName("user/findUserPwResult");
	    return mv;
	}
}
