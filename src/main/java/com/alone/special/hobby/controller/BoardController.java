package com.alone.special.hobby.controller;

import java.io.File;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.PageInfo;
import com.alone.special.hobby.domain.Reply;
import com.alone.special.hobby.service.BoardService;
import com.alone.special.hobby.service.ReplyService;

@Controller
@RequestMapping("/hobby/board")
public class BoardController {

	@Autowired
	private BoardService bService;
	
	@Autowired
	private ReplyService rService;
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	private ModelAndView showBoardListForm(ModelAndView mv
			, @RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
			, @RequestParam(value="category") String refCategoryName) {
		
		try {
			Integer totalCount = bService.getListCount(refCategoryName);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			
			Map<String, Object> getListMap = new HashMap<>();
			getListMap.put("refCategoryName", refCategoryName);
			getListMap.put("pInfo", pInfo);
	        
			List<Board> bList = bService.selectBoardList(getListMap);
			
			mv.addObject("bList", bList);
			mv.addObject("pInfo", pInfo);
			mv.addObject("refCategoryName", refCategoryName);
			mv.setViewName("hobby/board");
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", "/hobby/category/list.do");
			mv.setViewName("common/errorPage");
		}
		mv.setViewName("hobby/board");
		return mv;
	}
	
	private PageInfo getPageInfo(Integer currentPage, int totalCount) {
		int recordCountPerPage = 10;
		int naviCountPerPage = 5;
		int naviTotalCount = (int)Math.ceil((double)totalCount/recordCountPerPage);
		int startNavi = (((int)((double)currentPage/naviCountPerPage+0.9))-1)*naviCountPerPage+1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		PageInfo pInfo = new PageInfo(currentPage, totalCount, naviTotalCount, recordCountPerPage, naviCountPerPage, startNavi, endNavi);
		return pInfo;
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.GET)
	public ModelAndView showInsertForm(ModelAndView mv
			, @RequestParam(value="category") String refCategoryName
			, HttpSession session) {
		
		String boardWriter = (String)session.getAttribute("userId");
		if(boardWriter != null && !boardWriter.equals("")) {
			mv.addObject("refCategoryName", refCategoryName);
			mv.setViewName("hobby/insert");
		} else {
			mv.addObject("msg", "로그인이 완료되지 않았습니다.");
			mv.addObject("url", "/user/login.do");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public ModelAndView insertBoard(ModelAndView mv
			, @ModelAttribute Board board
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, @RequestParam("setTime") String setTime
			, HttpSession session
			, HttpServletRequest request) {
		
		try {
			String boardWriter = (String)session.getAttribute("userId");
			if(boardWriter != null && !boardWriter.equals("")) {
				if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
					Map<String, Object> bMap = this.saveFile(request, uploadFile);
					board.sethBoardFilename((String)bMap.get("fileName"));
					board.sethBoardFilerename((String)bMap.get("fileRename"));
					board.sethBoardFilepath((String)bMap.get("filePath"));
					board.sethBoardFilelength((long)bMap.get("fileLength"));
				}
				
				if(setTime != null && !setTime.equals("")) {
					String dateTimeString = setTime.replace("T", " ");
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
					Timestamp examDateTime = Timestamp.valueOf(dateTime);
					
					board.sethGroupTime(examDateTime);
				} else {
					board.sethGroupTime(null);
				}
				
				String encodedCategory = URLEncoder.encode(board.getRefCategoryName(), "UTF-8");
				String url = "hobby/board/list.do?category=" + encodedCategory;
				
				board.sethBoardWriter(boardWriter);
				
				int result = bService.insertBoard(board);
				if(result > 0) {
					mv.setViewName("redirect:/"+url);
				} else {
					mv.addObject("msg", "게시글 등록이 완료되지 않았습니다.");
					mv.addObject("url", url);
					mv.setViewName("common/errorPage");
				}
			} else {
				mv.addObject("msg", "로그인이 완료되지 않았습니다.");
				mv.addObject("url", "/user/login.do");
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	public Map<String, Object> saveFile(HttpServletRequest request, MultipartFile uploadFile) throws Exception {
		Map<String, Object> fileMap = new HashMap<String, Object>();
		String fileName = uploadFile.getOriginalFilename();
//		String root = request.getSession().getServletContext().getRealPath("resources//images//hobby");	// 파일 넣을 resources 경로
//		String savePath = root + "//bUploadFiles";											// 파일 저장 경로
		String root = request.getSession().getServletContext().getRealPath("resources\\images\\hobby");	// 파일 넣을 resources 경로
		String savePath = root + "\\bUploadFiles";											// 파일 저장 경로
		String extension = fileName.substring(fileName.lastIndexOf(".")+1);					// 확장자 가져오기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");						// 시간 가져오기
		String fileRename = sdf.format(new Date(System.currentTimeMillis()))+"."+extension;	// 시간 형식 바꾸꿔서 리네임에 넣기
		File saveFolder = new File(savePath);												// 저장할 파일 있나 확인하고 없으면 생성
		if(!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		File saveFile = new File(savePath+"\\"+fileRename);									// 파일 저장
		uploadFile.transferTo(saveFile);
		long fileLength = uploadFile.getSize();
		
		fileMap.put("fileName", fileName);													// 해쉬맵에 넣어주기
		fileMap.put("fileRename", fileRename);
		fileMap.put("filePath", "../resources/images/hobby/bUploadFiles/"+fileRename);
		fileMap.put("fileLength", fileLength);
		
		return fileMap;
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.GET)
	public ModelAndView showUpdateForm(ModelAndView mv
			, @RequestParam("hBoardNo") Integer boardNo
			, @RequestParam("category") String refCategoryName
			, HttpSession session) {
		
		try {
			Board board = bService.selectBoardByNo(boardNo);
			
			String userId = (String)session.getAttribute("userId");
			String boardWriter = board.gethBoardWriter();
			if((boardWriter != null & boardWriter.equals(userId)) || userId.equals("admin")) {
				mv.addObject("board", board);
				mv.addObject("refCategoryName", refCategoryName);
				mv.setViewName("hobby/update");
			} else {
				mv.addObject("msg", "자신의 게시글만 수정 가능합니다.");
				mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public ModelAndView boardUpdate(ModelAndView mv
			, @ModelAttribute Board board
			, @RequestParam(value="uploadFile", required=false) MultipartFile uploadFile
			, @RequestParam("setTime") String setTime
			, HttpSession session
			, HttpServletRequest request) {
		
		try {
			String userId = (String)session.getAttribute("userId");
			String boardWriter = board.gethBoardWriter();
			if((boardWriter != null && boardWriter.equals(userId)) || userId.equals("admin")) {
				if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
					String fileRename = board.gethBoardFilerename();
					if(fileRename != null) {
						this.deleteFile(fileRename, request);
					}
					Map<String, Object> bFileMap = this.saveFile(request, uploadFile);
					board.sethBoardFilename((String)bFileMap.get("fileName"));
					board.sethBoardFilerename((String)bFileMap.get("fileRename"));
					board.sethBoardFilepath((String)bFileMap.get("filePath"));
					board.sethBoardFilelength((long)bFileMap.get("fileLength"));
				}
				
				if(setTime != null && !setTime.equals("")) {
					String dateTimeString = setTime.replace("T", " ");
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
					LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, formatter);
					Timestamp examDateTime = Timestamp.valueOf(dateTime);
					
					board.sethGroupTime(examDateTime);
				}
				
				String encodedCategory = URLEncoder.encode(board.getRefCategoryName(), "UTF-8");
				String url = "hobby/board/detail.do?category=" + encodedCategory + "&hBoardNo=" + board.gethBoardNo();
				
				int result = bService.updateBoard(board);
				if(result > 0) {
					mv.setViewName("redirect:/"+url);
				} else {
					mv.addObject("msg", "게시글 수정이 완료되지 않았습니다.");
					mv.addObject("url", "/"+url);
					mv.setViewName("common/errorPage");
				}
			} else {
				mv.addObject("msg", "자신의 게시글만 수정 가능합니다.");
				mv.addObject("url", "/board/update.kh?boardNo="+board.gethBoardNo());
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", "/hobby/board/update.do?boardNo="+board.gethBoardNo());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	private void deleteFile(String fileRename, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
//		String delPath = root + "//buploadFiles//" + fileRename;
		String delPath = root + "\\buploadFiles\\" + fileRename;
		File delFile = new File(delPath);
		if(delFile.exists()) {
			delFile.delete();
		}
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.GET)
	public ModelAndView deleteBoard(ModelAndView mv
			, @ModelAttribute Board board
			, HttpSession session) {
		
		String url = "";
		try {
			url = "/hobby/board/list.do?category="+board.getRefCategoryName();
			
			String userId = (String)session.getAttribute("userId");
			String boardWriter = board.gethBoardWriter();
			if((boardWriter != null && boardWriter.equals(userId)) || userId.equals("admin")) {
				int result = bService.deleteBoard(board);
				if(result > 0) {
					mv.setViewName("redirect:"+url);
				} else {
					mv.addObject("msg", "게시글 삭제가 완료되지 않았습니다.");
					mv.addObject("url", url);
					mv.setViewName("common/errorPage");
				}
			} else {
				mv.addObject("msg", "자신의 게시글만 삭제 가능합니다.");
				mv.addObject("url", url);
				mv.setViewName("common/errorPage");
			}
				
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", url);
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/detail.do", method=RequestMethod.GET)
	public ModelAndView showBoardDetail(ModelAndView mv
			, @RequestParam("hBoardNo") Integer hBoardNo
			, @RequestParam("category") String refCategoryName
			, HttpSession session) {
		
		try {
			Board boardOne = bService.selectBoardByNo(hBoardNo);
			if(boardOne != null) {
				String userId = (String)session.getAttribute("userId");
				String hGroupApplyPerson = boardOne.gethGroupApplyPerson();
				String hBoardCategory = boardOne.gethBoardCategory();
				
				if(userId != null && !userId.equals("")) {
					if(hBoardCategory.equals("소모임")) {		// 소모임일 경우
						if((hGroupApplyPerson != null && hGroupApplyPerson.contains(userId)) || userId.equals("admin") || userId.equals(boardOne.gethBoardWriter())) {	// 아이디가 포함되어있으면
							List<Reply> replyList = rService.selectReplyList(hBoardNo);
							if(replyList.size() > 0) {
								mv.addObject("rList", replyList);
							}
							mv.addObject("board", boardOne);
							mv.addObject("refCategoryName", refCategoryName);
							mv.setViewName("hobby/detail");
						} else {	// 아이디가 포함되어있지 않으면
							mv.addObject("msg", "소모임 신청자가 아닙니다.");
							mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
							mv.setViewName("common/errorPage");
						}
					} else {
						List<Reply> replyList = rService.selectReplyList(hBoardNo);
						if(replyList.size() > 0) {
							mv.addObject("rList", replyList);
						}
						mv.addObject("board", boardOne);
						mv.addObject("refCategoryName", refCategoryName);
						mv.setViewName("hobby/detail");
					}
				} else {
					mv.addObject("msg", "로그인이 완료되지 않았습니다.");
					mv.addObject("url", "/user/login.do");
					mv.setViewName("common/errorPage");
				}
			} else {
				mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/searchBySession.do", method=RequestMethod.GET)
	public ModelAndView searchBySession(ModelAndView mv
			, @RequestParam(value="category") String refCategoryName
			, @RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage
			, HttpSession session) {
		
		try {
			String hBoardWriter = (String)session.getAttribute("userId");
			if(hBoardWriter != null && !hBoardWriter.equals("")) {
				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.put("hBoardWriter", hBoardWriter);
				paramMap.put("refCategoryName", refCategoryName);
				
				int totalCount = bService.getListCountBySession(paramMap);
				PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
				String result = this.getSearchBySessionNaviInfo(pInfo, paramMap);
				
				List<Board> searchList = bService.searchBoardsBySession(pInfo, paramMap);
				
				if(!searchList.isEmpty()) {
					mv.addObject("hBoardWriter", hBoardWriter);
					mv.addObject("refCategoryName", refCategoryName);
					mv.addObject("pInfo", pInfo);
					mv.addObject("sList", searchList);
					mv.addObject("navi", result);
					mv.setViewName("hobby/board-search");
				} else {
					mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
					mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
					mv.setViewName("common/errorPage");
				}
			} else {
				mv.addObject("msg", "로그인이 완료되지 않았습니다.");
				mv.addObject("url", "/user/login.do");
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/hobby/board/list.do");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	public String getSearchBySessionNaviInfo(PageInfo pInfo, Map<String, String> paramMap) {
		boolean needPrev = true;
		boolean needNext = true;
		
		if(pInfo.getStartNavi() == 1) {
			needPrev = false;
		}
		if(pInfo.getEndNavi() == pInfo.getNaviTotalCount()) {
			needNext = false;
		}
		StringBuilder result = new StringBuilder();
		if(needPrev) {
			result.append("<a href='/hobby/board/searchBySession.do?currentPage="+(pInfo.getStartNavi()-1)+"&category="+paramMap.get("refCategoryName")+"&hBoardWriter="+paramMap.get("hBoardWriter")+"'> < </a>");
		}
		for(int i = pInfo.getStartNavi(); i <= pInfo.getEndNavi(); i++) {
			result.append("<a href='/hobby/board/searchBySession.do?currentPage="+i+"&category="+paramMap.get("refCategoryName")+"&hBoardWriter="+paramMap.get("hBoardWriter")+"'>" +i+ "</a>");
		}
		if(needNext) {
			result.append("<a href='/hobby/board/searchBySession.do?currentPage="+(pInfo.getEndNavi()+1)+"&category="+paramMap.get("refCategoryName")+"&hBoardWriter="+paramMap.get("hBoardWriter")+"'> > </a>");
		}
		return result.toString();
	}
	
	@RequestMapping(value="/searchByCategoryBar.do", method=RequestMethod.GET)
	public ModelAndView searchByCategoryBar(ModelAndView mv
			, @RequestParam(value="category") String refCategoryName
			, @RequestParam("searchCondition1") String searchCondition1
			, @RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("searchCondition1", searchCondition1);
			paramMap.put("refCategoryName", refCategoryName);
			
			int totalCount = bService.getListCountByCondition(paramMap);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			String result = this.getSearchByBarNaviInfo(pInfo, paramMap);
			
			List<Board> searchList = bService.searchBoardsByCondition(pInfo, paramMap);		
			
			if(!searchList.isEmpty()) {
				mv.addObject("refCategoryName", refCategoryName);
				mv.addObject("pInfo", pInfo);
				mv.addObject("sList", searchList);
				mv.addObject("navi", result);
				mv.setViewName("hobby/board-search");
			} else {
				mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/hobby/board/list.do");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	public String getSearchByBarNaviInfo(PageInfo pInfo, Map<String, String> paramMap) {
		boolean needPrev = true;
		boolean needNext = true;
		
		if(pInfo.getStartNavi() == 1) {
			needPrev = false;
		}
		if(pInfo.getEndNavi() == pInfo.getNaviTotalCount()) {
			needNext = false;
		}
		StringBuilder result = new StringBuilder();
		if(needPrev) {
			result.append("<a href='/hobby/board/searchByCategoryBar.do?currentPage="+(pInfo.getStartNavi()-1)+"&category="+paramMap.get("refCategoryName")+"&searchCondition1="+paramMap.get("searchCondition1")+"'> < </a>");
		}
		for(int i = pInfo.getStartNavi(); i <= pInfo.getEndNavi(); i++) {
			result.append("<a href='/hobby/board/searchByCategoryBar.do?currentPage="+i+"&category="+paramMap.get("refCategoryName")+"&searchCondition1="+paramMap.get("searchCondition1")+"'>" +i+ "</a>");
		}
		if(needNext) {
			result.append("<a href='/hobby/board/searchByCategoryBar.do?currentPage="+(pInfo.getEndNavi()+1)+"&category="+paramMap.get("refCategoryName")+"&searchCondition1="+paramMap.get("searchCondition1")+"'> > </a>");
		}
		return result.toString();
	}
	
	@RequestMapping(value="/search.do", method=RequestMethod.GET)
	public ModelAndView searchBoardList(ModelAndView mv
			, @RequestParam(value="category") String refCategoryName
			, @RequestParam("searchCondition1") String searchCondition1
			, @RequestParam("searchCondition2") String searchCondition2
			, @RequestParam("searchKeyword") String searchKeyword
			, @RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		
		try {
			Map<String, String> paramMap = new HashMap<String, String>();
			mv.addObject("refCategoryName", refCategoryName);
			paramMap.put("searchCondition1", searchCondition1);
			paramMap.put("searchCondition2", searchCondition2);
			paramMap.put("searchKeyword", searchKeyword);
			paramMap.put("refCategoryName", refCategoryName);
			
			int totalCount = bService.getListCountByKeyword(paramMap);
			PageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			String result = this.getSearchNaviInfo(pInfo, paramMap);
			
			List<Board> searchList = bService.searchBoardsByKeyword(pInfo, paramMap);		
			
			if(!searchList.isEmpty()) {
				mv.addObject("searchCondition1", searchCondition1);
				mv.addObject("searchCondition2", searchCondition2);
				mv.addObject("searchKeyword", searchKeyword);
				mv.addObject("pInfo", pInfo);
				mv.addObject("sList", searchList);
				mv.addObject("navi", result);
				mv.setViewName("hobby/board-search");
			} else {
				mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/hobby/board/list.do");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	public String getSearchNaviInfo(PageInfo pInfo, Map<String, String> paramMap) {
		boolean needPrev = true;
		boolean needNext = true;
		
		if(pInfo.getStartNavi() == 1) {
			needPrev = false;
		}
		if(pInfo.getEndNavi() == pInfo.getNaviTotalCount()) {
			needNext = false;
		}
		StringBuilder result = new StringBuilder();
		if(needPrev) {
			result.append("<a href='/hobby/board/search.do?currentPage="+(pInfo.getStartNavi()-1)+"&category="+paramMap.get("refCategoryName")+"&searchCondition1="+paramMap.get("searchCondition1")+"&searchCondition2="+paramMap.get("searchCondition2")+"&searchKeyword="+paramMap.get("searchKeyword")+"'> < </a>");
		}
		for(int i = pInfo.getStartNavi(); i <= pInfo.getEndNavi(); i++) {
			result.append("<a href='/hobby/board/search.do?currentPage="+i+"&category="+paramMap.get("refCategoryName")+"&searchCondition1="+paramMap.get("searchCondition1")+"&searchCondition2="+paramMap.get("searchCondition2")+"&searchKeyword="+paramMap.get("searchKeyword")+"'>" +i+ "</a>");
		}
		if(needNext) {
			result.append("<a href='/hobby/board/search.do?currentPage="+(pInfo.getEndNavi()+1)+"&category="+paramMap.get("refCategoryName")+"&searchCondition1="+paramMap.get("searchCondition1")+"&searchCondition2="+paramMap.get("searchCondition2")+"&searchKeyword="+paramMap.get("searchKeyword")+"'> > </a>");
		}
		return result.toString();
	}
	
	@RequestMapping(value="/popup.do", method=RequestMethod.GET)
	public ModelAndView showPopupForm(ModelAndView mv
			, @RequestParam("hBoardNo") Integer hBoardNo
			, @RequestParam(value="category") String refCategoryName) {
		
		try {
			String encodedCategory = URLEncoder.encode(refCategoryName, "UTF-8");
			String url = "hobby/board/detail.do?category=" + encodedCategory + "&hBoardNo=" + hBoardNo;
			
			Board boardOne = bService.selectBoardByNo(hBoardNo);
			if(boardOne != null) {
				mv.addObject("board", boardOne);
				mv.setViewName("hobby/groupPopupForm");
			} else {
				mv.addObject("msg", "소모임 일정 조회가 완료되지 않았습니다.");
				mv.addObject("url", url);
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "소모임 일정 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/doApply.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView groupDoApply(ModelAndView mv
			, @ModelAttribute Board board
//			, @RequestParam(value="category") String refCategoryName
			, HttpSession session) {
				
		try {
			String userId = (String)session.getAttribute("userId");
			if(userId != null && !userId.equals("")) {								// 로그인 확인
				Board boardOne = bService.selectBoardByNo(board.gethBoardNo());		// 게시물번호로 조회해서 boardOne 정보 가져오기
				if(boardOne != null) {												// boardOne이 null이 아니면
//					int addPersonNum = boardOne.gethGroupApplyPersonNum()+1;		// boardOne에 지원자 수 +1
//					boardOne.sethGroupApplyPersonNum(addPersonNum);					// boardOne에 지원자 수 +1 한 값 세팅
					
					String existingPerson = boardOne.gethGroupApplyPerson();		// boardOne에 들어있는 지원자 가져오기 : 변수 existingPerson 선언
					
//					if(!existingPerson.contains(userId)) {							// existingPerson에 userId가 안들어있고
//						if(existingPerson == null || existingPerson == "") {		// existingPerson가 null이거나 비어있으면
//							boardOne.sethGroupApplyPerson(userId);					// boardOne에 로그인된 아이디 그냥 추가
//						} else {													// 비어있지 않으면
//						    String updatedValue = existingPerson + ", " + userId;	// existingPerson 뒤에 ", " 를 넣어서 추가 : 변수 updatedValue 선언
//						    boardOne.sethGroupApplyPerson(updatedValue);			// boardOne에 해당값 추가
//						}
//					} else {														// existingPerson에 userId가 이미 들어있었으면
//						mv.addObject("msg", "이미 소모임을 신청하였습니다.");
//						mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
//						mv.setViewName("common/errorPage");
//					}
					
					if (existingPerson == null || existingPerson.equals("")) {			// existingPerson가 비어있으면 그냥 사용자 아이디를 추가합니다.
					    boardOne.sethGroupApplyPerson(userId);
					    int addPersonNum = boardOne.gethGroupApplyPersonNum()+1;		// boardOne에 지원자 수 +1
						boardOne.sethGroupApplyPersonNum(addPersonNum);					// boardOne에 지원자 수 +1 한 값 세팅
					} else if (existingPerson.contains(userId)) {						// existingPerson에 이미 사용자 아이디가 포함되어 있으면 이미 신청했다고 메시지를 설정합니다.
					    mv.addObject("msg", "이미 소모임을 신청하였습니다.");
					    mv.addObject("url", "/hobby/board/list.do?category=" + board.getRefCategoryName());
					    mv.setViewName("common/errorPage");
					} else {															// existingPerson이 비어있지 않으면 ", "를 포함하여 사용자 아이디를 추가합니다.
					    String updatedValue = existingPerson + ", " + userId;
					    boardOne.sethGroupApplyPerson(updatedValue);
					    int addPersonNum = boardOne.gethGroupApplyPersonNum()+1;		// boardOne에 지원자 수 +1
						boardOne.sethGroupApplyPersonNum(addPersonNum);					// boardOne에 지원자 수 +1 한 값 세팅
					}
					
					int result = bService.updateApplyInfo(boardOne);
					if(result > 0) {
						mv.setViewName("redirect:/hobby/board/popup.do?category="+board.getRefCategoryName()+"&hBoardNo="+board.gethBoardNo());
					} else {
						mv.addObject("msg", "소모임 신청 완료되지 않았습니다.");
						mv.addObject("url", "/hobby/board/list.do?category="+board.getRefCategoryName());
						mv.setViewName("common/errorPage");
					}
				} else {
					mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
					mv.addObject("url", "/hobby/board/list.do?category="+board.getRefCategoryName());
					mv.setViewName("common/errorPage");
				}
			} else {
				mv.addObject("msg", "로그인이 완료되지 않았습니다.");
				mv.addObject("url", "/user/login.do");
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/hobby/board/list.do?category="+board.getRefCategoryName());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/undoApply.do", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView groupUndoApply(ModelAndView mv
			, @ModelAttribute Board board
			, @RequestParam(value="category") String refCategoryName
			, HttpSession session) {
		
		try {
			String encodedCategory = URLEncoder.encode(refCategoryName, "UTF-8");
			String url = "hobby/board/detail.do?category=" + encodedCategory + "&hBoardNo=" + board.gethBoardNo();
			
			String userId = (String)session.getAttribute("userId");
			if(userId != null && !userId.equals("")) {
				Board boardOne = bService.selectBoardByNo(board.gethBoardNo());
				if(boardOne != null) {
//					int minusPersonNum = boardOne.gethGroupApplyPersonNum()-1;
//					board.sethGroupApplyPersonNum(minusPersonNum);

					String existingPerson = boardOne.gethGroupApplyPerson();
					
//					if(hGroupApplyPerson.contains(userId)) {
//						if(hGroupApplyPerson != null && !hGroupApplyPerson.isEmpty()) {
//						    String updatedValue = hGroupApplyPerson.replace(userId + ", ", "").replace(", " + userId, "");
//						    updatedValue = updatedValue.replace(userId, "");
//						    board.sethGroupApplyPerson(updatedValue);
//						}
//					} else {
//						mv.addObject("msg", "소모임 신청취소 권한이 없습니다.");
//						mv.addObject("url", "/hobby/board/list.do?category="+board.getRefCategoryName());
//						mv.setViewName("common/errorPage");
//					}
					
					if (existingPerson == null || existingPerson.equals("")) {			// existingPerson가 비어있으면 비어있다는 메시지를 설정합니다.
					    mv.addObject("msg", "소모임 신청취소 권한이 없습니다.");
					    mv.addObject("url", url);
					    mv.setViewName("common/errorPage");
					} else if (!existingPerson.contains(userId)) {						// existingPerson에 사용자 아이디가 없으면 없다는 메시지를 설정합니다.
					    mv.addObject("msg", "소모임 신청취소 권한이 없습니다.");
					    mv.addObject("url", url);
					    mv.setViewName("common/errorPage");
					} else {															// existingPerson에서 userId만 있는 경우 userId를 삭제하고, 다른 문자열과 함께 있는 경우 삭제합니다.
						int minusPersonNum = boardOne.gethGroupApplyPersonNum()-1;
						boardOne.sethGroupApplyPersonNum(minusPersonNum);
						existingPerson = existingPerson.replace(userId + ", ", "");
					    existingPerson = existingPerson.replace(", " + userId, ""); 	// userId 앞에 ", "를 포함하여 삭제
					    existingPerson = existingPerson.replace(userId, ""); 			// userId만 있는 경우 삭제
					    boardOne.sethGroupApplyPerson(existingPerson);
					}
					
					int result = bService.updateApplyInfo(boardOne);
					if(result > 0) {
						mv.setViewName("redirect:/hobby/board/popup.do?category="+encodedCategory+"&hBoardNo="+boardOne.gethBoardNo());
					} else {
						mv.addObject("msg", "소모임 신청취소가 완료되지 않았습니다.");
						mv.addObject("url", url);
						mv.setViewName("common/errorPage");
					}
				} else {
					mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
					mv.addObject("url", url);
					mv.setViewName("common/errorPage");
				}
			} else {
				mv.addObject("msg", "로그인이 완료되지 않았습니다.");
				mv.addObject("url", "/user/login.do");
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", "게시글 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/hobby/board/list.do?category=" + refCategoryName);
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/autoCreateBoard.do", method=RequestMethod.GET)
	public ModelAndView showAutoCreatedBoard(ModelAndView mv
			, @RequestParam(value="category") String refCategoryName
			, @RequestParam("hBoardNo") Integer hBoardNo) {
		
		try {
			Board boardOne = bService.selectBoardByNo(hBoardNo);
			
			String encodedCategory = URLEncoder.encode(boardOne.getRefCategoryName(), "UTF-8");
			String url = "hobby/board/list.do?category=" + encodedCategory;
			
			int result = bService.createAutoBoard(boardOne);
			if(result > 0) {
				mv.addObject("board", boardOne);
				mv.setViewName("redirect:/"+url);
			} else {
				mv.addObject("msg", "소모임 게시글 자동생성이 완료되지 않았습니다.");
				mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", "/hobby/board/list.do?category="+refCategoryName);
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
}
