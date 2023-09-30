package com.alone.special.admin.controller;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alone.special.admin.domain.Singo;
import com.alone.special.admin.service.AdminService;
import com.alone.special.foodProduct.domain.FoodProduct;
import com.alone.special.foodProduct.service.FoodProductService;
import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.Reply;
import com.alone.special.hobby.service.BoardService;
import com.alone.special.hobby.service.ReplyService;
import com.alone.special.noticeEvent.domain.NoticeEvent;
import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.noticeEvent.service.NoticeEventService;
import com.alone.special.product.controller.ProductController;
import com.alone.special.product.domain.Product;
import com.alone.special.product.domain.ProductPageInfo;
import com.alone.special.product.service.ProductService;
import com.alone.special.review.domain.Review;
import com.alone.special.review.domain.ReviewPageInfo;
import com.alone.special.review.service.ReviewService;
import com.alone.special.securitycomment.domain.Comment;
import com.alone.special.user.domain.User;
import com.alone.special.user.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private AdminService aService;
	@Autowired
	private UserService uService;
	@Autowired
	private BoardService hService;
	@Autowired
	private NoticeEventService nService;
	@Autowired
	private ProductService pService;
	@Autowired
	private ReviewService rService;
	@Autowired
	private ReplyService hrService;
	@Autowired
	private FoodProductService fService;

	
	
	@RequestMapping(value="/member/list.do", method=RequestMethod.GET)
	public ModelAndView showMemberList(ModelAndView mv,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = aService.getUserListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<User> mList = aService.selectUserList(pInfo);
			if(!mList.isEmpty()) {
				mv.addObject("mList", mList).addObject("pInfo", pInfo).setViewName("admin/manageMember");
			} else {
				mv.addObject("msg", "멤버 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "멤버 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	// 회원정보 페이지
	@RequestMapping(value="/user/mypage.do", method=RequestMethod.GET)
	public ModelAndView mypageForm(ModelAndView mv, @RequestParam("userId") String userId) {
		try {
			User uOne = uService.selectOneById(userId);

				uOne = uService.selectOneById(userId);
			if(uOne != null) {
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
	
	@RequestMapping(value="/manageReply.do", method=RequestMethod.GET)
	public ModelAndView checkReplyType(ModelAndView mv,
			@RequestParam("selectedValue") String selectedValue,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		if(selectedValue.equals("hobby")) {
			Integer totalCount = aService.getHReplyListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Reply> hList = aService.getHReplyList(pInfo);
			mv.addObject("hList", hList).addObject("pInfo", pInfo).setViewName("/admin/manageHobbyReply");
		} else if(selectedValue.equals("security")) {
			Integer totalCount = aService.getSReplyListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Comment> sList = aService.getSReplyList(pInfo);
			mv.addObject("sList", sList).addObject("pInfo", pInfo).setViewName("/admin/manageSecurityReply");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/manageReply/search.do", method=RequestMethod.GET)
	public ModelAndView checkReplyTypeSearch(ModelAndView mv,
			@RequestParam("selectedValue") String selectedValue,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		if(selectedValue.equals("hobby")) {
			Integer totalCount = aService.getHReplyListCount(searchKeyword);
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Reply> sList = aService.getHReplyList(pInfo, searchKeyword);
			mv.addObject("sList", sList).addObject("pInfo", pInfo)
			.addObject("searchKeyword", searchKeyword).setViewName("/admin/manageHobbyReplySearch");
		} else if(selectedValue.equals("security")) {
			Integer totalCount = aService.getSReplyListCount(searchKeyword);
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Comment> sList = aService.getSReplyList(pInfo, searchKeyword);
			mv.addObject("sList", sList).addObject("pInfo", pInfo)
			.addObject("searchKeyword", searchKeyword).setViewName("/admin/manageSecurityReplySearch");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/manageBoard/search.do", method = RequestMethod.GET)
	public ModelAndView checkBoardTypeSearch(ModelAndView mv,
			@RequestParam("selectedValue") String selectedValue,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		if(selectedValue.equals("notice")) { // 공지사항
			Integer totalCount = nService.getNoticeListCount(searchKeyword);
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<NoticeEvent> sList = nService.searchNoticeByKeyword(pInfo, searchKeyword);
			mv.addObject("sList", sList).addObject("pInfo", pInfo)
			.addObject("searchKeyword", searchKeyword).setViewName("/admin/manageNoticeSearch");
		} else if(selectedValue.equals("event")) { // 행사
			Integer totalCount = nService.getEventListCount(searchKeyword);
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<NoticeEvent> sList = nService.searchEventByKeyword(pInfo, searchKeyword);
			mv.addObject("sList", sList).addObject("pInfo", pInfo)
			.addObject("searchKeyword", searchKeyword).setViewName("/admin/manageEventSearch");
		} else if(selectedValue.equals("sProduct")) { // 안전 상품
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("searchCondition", "title");
			paramMap.put("searchKeyword", searchKeyword);
			int totalCount = pService.getProductListCount(paramMap);
			ProductPageInfo pInfo = this.getPageInfoS(currentPage, totalCount);
			List<Product> searchList = pService.searchNoticesByKeyword(pInfo, paramMap);
			mv.addObject("sList", searchList).addObject("pInfo", pInfo)
			.addObject("searchKeyword", searchKeyword).setViewName("/admin/manageSProductSearch");
		} else if(selectedValue.equals("sReview")) { // 안전 리뷰
			Integer totalCount = aService.selectReviewListCountByKeyword(searchKeyword);
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Review> sList = aService.getAllReviewsByKeyword(pInfo, searchKeyword);
			mv.addObject("sList", sList).addObject("pInfo", pInfo)
			.addObject("searchKeyword", searchKeyword).setViewName("/admin/manageSReviewSearch");
		} else if(selectedValue.equals("hBoard")) { // 취미 게시글
			Integer totalCount = hService.getListCount(searchKeyword);
			com.alone.special.hobby.domain.PageInfo pInfo = this.getPageInfoH(totalCount, currentPage);
			List<Board> sList = hService.selectBoardListByCategoryForAdmin(searchKeyword, pInfo);
			mv.addObject("sList", sList).addObject("pInfo", pInfo)
			.addObject("searchKeyword", searchKeyword).setViewName("/admin/manageHBoardSearch");
		} else if(selectedValue.equals("fBoard")) { // 음식
			if(searchKeyword.equals("All")) {
				Integer totalCount = fService.getListCount();
				com.alone.special.foodProduct.domain.PageInfo pInfo = this.getPageInfoF(totalCount, currentPage);
				List<FoodProduct> fList = fService.selectProductInfoList(pInfo);
				mv.addObject("fList", fList).addObject("pInfo", pInfo).setViewName("/admin/manageFBoard");
			}else {
				Integer totalCount = fService.getListCountByCategory(searchKeyword);
				com.alone.special.foodProduct.domain.PageInfo pInfo = this.getPageInfoF(totalCount, currentPage);
				List<FoodProduct> sList = fService.selectProductInfoListByCategory(searchKeyword, pInfo);
				mv.addObject("sList", sList).addObject("pInfo", pInfo)
				.addObject("searchKeyword", searchKeyword).setViewName("/admin/manageFBoardSearch");
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/manageBoard.do", method = RequestMethod.GET)
	public ModelAndView checkBoardType(ModelAndView mv,
			@RequestParam("selectedValue") String selectedValue,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		if(selectedValue.equals("notice")) { // 공지사항
			Integer totalCount = nService.getNoticeListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<NoticeEvent> nList = nService.selectNoticeList(pInfo);
			mv.addObject("nList", nList).addObject("pInfo", pInfo).setViewName("/admin/manageNotice");
		} else if(selectedValue.equals("event")) { // 행사
			Integer totalCount = nService.getEventListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<NoticeEvent> eList = nService.selectEventList(pInfo);
			mv.addObject("eList", eList).addObject("pInfo", pInfo).setViewName("/admin/manageEvent");
		} else if(selectedValue.equals("sProduct")) { // 안전 상품
			int totalCount = pService.getListCount();
			ProductPageInfo pInfo = this.getPageInfoS(totalCount, currentPage);
			List<Product> pList = pService.selectProductLust(pInfo);
			mv.addObject("pList", pList).addObject("pInfo", pInfo).setViewName("/admin/manageSProduct");
		} else if(selectedValue.equals("hBoard")) { //취미 게시글
			Integer totalCount = hService.getListCountForAdmin();
			com.alone.special.hobby.domain.PageInfo pInfo = this.getPageInfoH(totalCount, currentPage);
			List<Board> hList = hService.selectAllBoardListForAdmin(pInfo);
			mv.addObject("hList", hList).addObject("pInfo", pInfo).setViewName("/admin/manageHBoard");
		} else if(selectedValue.equals("sReview")) { // 안전 리뷰
			Integer totalCount = rService.getListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Review> sList = aService.getAllReviews(pInfo);
			mv.addObject("sList", sList).addObject("pInfo", pInfo).setViewName("/admin/manageSReview");
		} else if(selectedValue.equals("fBoard")) { // 음식 추천
			Integer totalCount = fService.getListCount();
			com.alone.special.foodProduct.domain.PageInfo pInfo = this.getPageInfoF(totalCount, currentPage);
			List<FoodProduct> fList = fService.selectProductInfoList(pInfo);
			mv.addObject("fList", fList).addObject("pInfo", pInfo).setViewName("/admin/manageFBoard");
		}
		
		return mv;
	}
	
	
	@RequestMapping(value="/member/search.do", method=RequestMethod.GET)
	public ModelAndView showSearchMemberList(ModelAndView mv,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = aService.getUserListCount(searchKeyword);
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<User> searchList = aService.selectUserList(pInfo, searchKeyword);
			if(!searchList.isEmpty()) {
				mv.addObject("searchKeyword", searchKeyword).addObject("pInfo", pInfo)
				.addObject("sList", searchList).setViewName("admin/manageMemberSearch");
			} else {
				mv.addObject("msg", "멤버검색 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "멤버검색 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/admin/singo.do", method=RequestMethod.POST)
	public ModelAndView insertSingo(ModelAndView mv,
			@RequestParam("reason") String reason,
			@RequestParam("productTitle") String productTitle,
			@RequestParam("name") String name,
			@RequestParam("url") String url,
			@RequestParam("singocontents") String content) {
		try {
			//파라값들 받아서  singo 클래스에 넣어서 보내기-ajax로 받아서 String으로 리턴?
			Singo singo = new Singo();
			singo.setSingoContent(content);
			singo.setSingoId(name);
			singo.setSingoLocation(url);
			singo.setSingoLocationTitle(productTitle);
			singo.setSingoReason(reason);

			int result = aService.insertSingo(singo);
			if(result > 0) {
				mv.setViewName("common/singoSuccess");
			} else {
				mv.addObject("msg", "신고가 완료되지 않았습니다.");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "신고가 완료되지 않았습니다.");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/singo/list.do", method=RequestMethod.GET)
	public ModelAndView showSingoList(ModelAndView mv,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = aService.getSingoListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Singo> singoList = aService.selectSingoList(pInfo);
			if(!singoList.isEmpty()) {
				mv.addObject("singoList", singoList).addObject("pInfo", pInfo).setViewName("admin/singo");
			} else {
				mv.addObject("singoList", singoList).addObject("pInfo", pInfo).setViewName("admin/singo");
			}
		} catch (Exception e) {
			mv.addObject("msg", "신고 회원 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/singo/search.do", method=RequestMethod.GET)
	public ModelAndView showSearchSingoList(ModelAndView mv,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = aService.getSingoListCount(searchKeyword);
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<Singo> searchList = aService.selectSingoList(pInfo, searchKeyword);
			if(!searchList.isEmpty()) {
				mv.addObject("searchKeyword", searchKeyword).addObject("pInfo", pInfo)
				.addObject("singoList", searchList).setViewName("admin/singoSearch");
			} else {
				mv.addObject("msg", "신고회원 검색이 완료되지 않았습니다.");
				mv.addObject("url", "/singo/list.do");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "신고회원 검색이 완료되지 않았습니다.");
			mv.addObject("url", "/singo/list.do");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/singo/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteSingo(ModelAndView mv,
			@RequestParam("singoNo") Integer singoNo) {
		try {
			int result = aService.deleteSingo(singoNo);
			if(result > 0) {
				mv.setViewName("redirect:/singo/list.do");
			} else {
				mv.addObject("msg", "신고 취소 실패");
				mv.addObject("url", "/singo/list.do");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "신고 취소가 완료되지 않았습니다.");
			mv.addObject("url", "/singo/list.do");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	public PageInfo getPageInfo(int totalCount,int currentPage) {
		PageInfo page =null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		naviTotalCount =(int)((double)totalCount/recordCountPerPage + 0.9);
		startNavi = (((int)((double)currentPage/naviCountPerPage+0.9))-1)*naviCountPerPage+1;
		endNavi = startNavi + naviCountPerPage - 1;
		//endNavi는 startNavi에 무조건 naviCountPerPage에 값을 더하므로 실제 최대값 보다 무조건 클 수 있다.
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		page = new PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
				
		return page;
	}
	
	public com.alone.special.hobby.domain.PageInfo getPageInfoH(int totalCount,int currentPage) {
		com.alone.special.hobby.domain.PageInfo page =null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		naviTotalCount =(int)((double)totalCount/recordCountPerPage + 0.9);
		startNavi = (((int)((double)currentPage/naviCountPerPage+0.9))-1)*naviCountPerPage+1;
		endNavi = startNavi + naviCountPerPage - 1;
		//endNavi는 startNavi에 무조건 naviCountPerPage에 값을 더하므로 실제 최대값 보다 무조건 클 수 있다.
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		page = new com.alone.special.hobby.domain.PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
				
		return page;
	}
	
	public ProductPageInfo getPageInfoS(int totalCount,int currentPage) {
		ProductPageInfo page =null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		naviTotalCount =(int)((double)totalCount/recordCountPerPage + 0.9);
		startNavi = (((int)((double)currentPage/naviCountPerPage+0.9))-1)*naviCountPerPage+1;
		endNavi = startNavi + naviCountPerPage - 1;
		//endNavi는 startNavi에 무조건 naviCountPerPage에 값을 더하므로 실제 최대값 보다 무조건 클 수 있다.
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		page = new ProductPageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
				
		return page;
	}
	
	public com.alone.special.foodProduct.domain.PageInfo getPageInfoF(int totalCount,int currentPage) {
		com.alone.special.foodProduct.domain.PageInfo page =null;
		int recordCountPerPage = 10;
		int naviCountPerPage = 10;
		int naviTotalCount;
		int startNavi;
		int endNavi;
		naviTotalCount =(int)((double)totalCount/recordCountPerPage + 0.9);
		startNavi = (((int)((double)currentPage/naviCountPerPage+0.9))-1)*naviCountPerPage+1;
		endNavi = startNavi + naviCountPerPage - 1;
		//endNavi는 startNavi에 무조건 naviCountPerPage에 값을 더하므로 실제 최대값 보다 무조건 클 수 있다.
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		page = new com.alone.special.foodProduct.domain.PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
				
		return page;
	}
	
	private ReviewPageInfo getReviewPageInfo(int totalCount, Integer currentPage) {
		   ReviewPageInfo rpi =null;
	 	int recordCountPerPage = 10;
	 	int naviCountPerPage = 10;
	 	int naviTotalCount;
	 	int startNavi;
	 	int endNavi;
	 	naviTotalCount =(int)((double)totalCount/recordCountPerPage+0.9);
	 	startNavi = (((int)((double)currentPage/naviCountPerPage+0.9))-1)*naviCountPerPage+1;
	 	endNavi = startNavi + naviCountPerPage-1;
	 	if(endNavi>naviTotalCount) {
	 		endNavi = naviTotalCount;
	 	}
	 	rpi = new ReviewPageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
	 	
	 	return rpi;
		}
	
	@RequestMapping(value="/deleteHBaord.do", method = RequestMethod.GET)
	public ModelAndView deleteBoard(ModelAndView mv
			, @ModelAttribute Board board) {
		try {
				int result = aService.deleteBoard(board);
				if(result > 0) {
					mv.setViewName("/index.jsp");
				} else {
					mv.addObject("msg", "게시글 삭제가 완료되지 않았습니다.");
					mv.addObject("error", "게시글 삭제 실패");
					mv.setViewName("common/errorPage");
				}
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("error", e.getMessage());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/deleteHReply.do", method = RequestMethod.GET)
	public ModelAndView deleteReply(ModelAndView mv
			, @ModelAttribute Reply reply) {
		try {
				int result = hrService.deleteReply(reply);
				if(result > 0) {
					mv.setViewName("/index.jsp");
				} else {
					mv.addObject("msg", "댓글 삭제가 완료되지 않았습니다.");
					mv.addObject("url", "/index.jsp");
					mv.setViewName("common/errorPage");
				}
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/admin/companyHistory.do", method=RequestMethod.GET)
	public String showCompanyHistory() {
		return "admin/companyHistory";
	}
}
