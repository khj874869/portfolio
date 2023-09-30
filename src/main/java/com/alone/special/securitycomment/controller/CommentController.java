package com.alone.special.securitycomment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alone.special.product.domain.Product;
import com.alone.special.securitycomment.domain.Comment;
import com.alone.special.securitycomment.service.CommentService;
import com.alone.special.user.domain.User;
import com.alone.special.user.service.UserService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentservice;
	@Autowired 
	private UserService userservice;
	@RequestMapping(value="/map.do",method=RequestMethod.GET)
	public ModelAndView showMap(ModelAndView mv,HttpSession session) {
		String userId = (String)session.getAttribute("userId");
	    User user = userservice.selectOneById(userId);

		List<Comment> Comments = commentservice.getCommentList();
		if(Comments.size()>0) {
		mv.addObject("User",user).addObject("Comments", Comments).setViewName("sMap/sMap");
		return mv;
		}
		else {
			mv.setViewName("sMap/sMap");
		}
		return mv;
	}
	@RequestMapping(value = "/insertComment.do", method = RequestMethod.POST)
	public ModelAndView insertComment(ModelAndView mv,@ModelAttribute Comment comment,HttpSession session) {
		String userId = (String)session.getAttribute("userId");
	    User user = userservice.selectOneById(userId);
	    comment.setUserId(user.getUserId());
	    comment.setUserNo(user.getUserNo());
	    int result = commentservice.insertComment(comment);
	    if(result>0) {
	    	mv.setViewName("redirect:/comment/map.do");
	    }
	    return mv; 
	}
	@RequestMapping(value="/select.do",method=RequestMethod.POST)
	public ModelAndView searchComment(ModelAndView mv ,@RequestParam("searchCondition") String searchCondition
			,@RequestParam("searchKeyword") String searchKeyword) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchCondition", searchCondition);
		paramMap.put("searchKeyword", searchKeyword);
		List<Comment> searchList = commentservice.searchCommentsByKeyword(paramMap);
		if(!searchList.isEmpty()) {
			mv.addObject("searchCondition", searchCondition);
			mv.addObject("searchKeyword", searchKeyword);
			mv.addObject("Comments", searchList);
			mv.setViewName("sMap/sMap"); 
	}else {
		mv.setViewName("redirect:/index.jsp");
	}
	return mv;
}
	@RequestMapping(value="/commentdelete.do",method=RequestMethod.GET)
	public ModelAndView deleteComment(ModelAndView mv,@RequestParam("sCommentNo") Integer sCommentNo) {
		int result = commentservice.deleteComment(sCommentNo);
		if(result>0) {
			mv.setViewName("redirect:/comment/map.do");
		}
		return mv;
	}
	 @PostMapping("/insertrecommend.do")
	  @ResponseBody
	  public int likeComment(@RequestParam("commentId") Integer commentId) {
	      int result = commentservice.updatelike(commentId);
	      return result;
	  }

	 @RequestMapping(value="/update.do",method=RequestMethod.POST)
	 public ModelAndView updateComment(ModelAndView mv,@RequestParam("sCommentContent") String sCommentContent,
	    		Model model,
	    		@RequestParam("sCommentNo") Integer sCommentNo,Comment comment,HttpSession session)
	 {
		 String userId = (String)session.getAttribute("userId");
		 if ( userId!= null && !userId.equals("")) {
	        	comment.setsCommentNo(sCommentNo);
	        	comment.setsCommentContent(sCommentContent);
	        	comment.setUserId(userId);
		 	}
		    int result = commentservice.editComment(comment);
            if (result > 0) {
                mv.setViewName("redirect:/comment/map.do");
            } else {
                mv.setViewName("redirect:/index.jsp");
            }
	 return mv;
    } 

}