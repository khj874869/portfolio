package com.alone.special.hobby.controller;

import java.io.File;
//import java.util.ArrayList;
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

//import com.alone.special.hobby.domain.Board;
import com.alone.special.hobby.domain.Category;
//import com.alone.special.hobby.service.BoardService;
import com.alone.special.hobby.service.CategoryService;
//import com.alone.special.hobby.service.ReplyService;

@Controller
@RequestMapping("/hobby/category")
public class CategoryController {
	
	@Autowired
	private CategoryService cService;
	
//	@Autowired
//	private BoardService bService;
//	
//	@Autowired
//	private ReplyService rService;
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public ModelAndView showCategoryListForm(ModelAndView mv) {
		
		List<Category> cList = cService.selectAllCategoryList();
		mv.addObject("cList", cList);
		mv.setViewName("hobby/category");
		return mv;
	}
	
	@RequestMapping(value="/searchByTag.do", method=RequestMethod.GET)
	public ModelAndView searchByTag(ModelAndView mv
			, @RequestParam("searchCondition") String searchCondition) {
		
		List<Category> tagList = cService.selectByTag(searchCondition);
		
		if(!tagList.isEmpty()) {
			mv.addObject("tagList", tagList);
			mv.addObject("searchCondition", searchCondition);
			mv.setViewName("hobby/category-searchByTag");
		}
		mv.setViewName("hobby/category-searchByTag");
		return mv;
	}
	
	@RequestMapping(value="/searchByKeyword.do", method=RequestMethod.GET)
	public ModelAndView searchByKeyword(ModelAndView mv
			, @RequestParam("searchKeyword") String searchKeyword) {
		
		List<Category> keyList = cService.searchByKeyword(searchKeyword);
		
		if(!keyList.isEmpty()) {
			mv.addObject("tagList", keyList);
			mv.addObject("searchCondition", searchKeyword);
			mv.setViewName("hobby/category-searchByTag");
		}
		mv.setViewName("hobby/category-searchByTag");
		return mv;
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public ModelAndView insertCategoryList(ModelAndView mv
			, @ModelAttribute Category category
			, @RequestParam(value="uploadFile") MultipartFile uploadFile
			, HttpServletRequest request
			, HttpSession session) {
		
		try {
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				Map<String, Object> infoMap = this.saveFile(uploadFile, request);
				String hCategoryFilename = (String)infoMap.get("fileName");
				String hCategoryFilepath = (String)infoMap.get("filePath");
				long hCategoryFilelength = (long)infoMap.get("fileLength");
				
				category.sethCategoryFilename(hCategoryFilename);
				category.sethCategoryFilepath(hCategoryFilepath);
				category.sethCategoryFilelength(hCategoryFilelength);
				
				int result = cService.insertCategory(category);
				if(result > 0) {
					mv.addObject("hCategoryFilename", category.gethCategoryFilename());
					mv.setViewName("redirect:/hobby/category/list.do");
				} else {
					mv.addObject("msg", "카테고리 등록이 완료되지 않았습니다.");
					mv.addObject("url", "/hobby/category/list.do");
					mv.setViewName("common/errorPage");
				}
			} else {
				mv.addObject("msg", "이미지를 삽입해주세요.");
				mv.addObject("url", "/hobby/category/list.do");
				mv.setViewName("common/errorPage");
			}
			
		} catch (Exception e) {
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	public Map<String, Object> saveFile(MultipartFile uploadFile, HttpServletRequest request) throws Exception {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		
		String fileName = uploadFile.getOriginalFilename();
//		String root = request.getSession().getServletContext().getRealPath("resources//images//hobby");
//		String saveFolder = root + "//cUploadFiles";
		String root = request.getSession().getServletContext().getRealPath("resources\\images\\hobby");
		String saveFolder = root + "\\cUploadFiles";
		File folder = new File(saveFolder);
		if(!folder.exists()) {
			folder.mkdir();
		}
//		String savePath = saveFolder + "//" + fileName;
		String savePath = saveFolder + "\\" + fileName;
		File file = new File(savePath);
		uploadFile.transferTo(file);
		long fileLength = uploadFile.getSize();
	
		infoMap.put("fileName", fileName);
		infoMap.put("filePath", savePath);
		infoMap.put("fileLength", fileLength);
		
		return infoMap;
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public ModelAndView deleteCategory(ModelAndView mv
			, @ModelAttribute Category category
			, HttpSession session) {
		
		try {
			String userId = (String)session.getAttribute("userId");
			if(userId != null && userId.equals("admin")) {
//				List<Board> bList = bService.selectBoardListByCategory(category);
//				List<Integer> hBoardNoList = new ArrayList<>(); 	// hBoardNo를 저장할 리스트
//				
//				for (Board board : bList) {
//				    int hBoardNo = board.gethBoardNo(); 			// 각 Board 객체에서 hBoardNo 값을 가져옴
//				    hBoardNoList.add(hBoardNo); 					// hBoardNo 값을 리스트에 추가
//				}
//				
//				for (Integer hBoardNo : hBoardNoList) {				// hBoardNoList에 저장된 hBoardNo 값들을 이용하여 reply 삭제
//				    rService.deleteReplyByBoardNo(hBoardNo);
//				}
//				
//				int result = bService.deleteBoardByCategoryDelete(category);
				int result = cService.deleteCategory(category);
				if(result > 0) {
					mv.setViewName("redirect:/hobby/category/list.do");
				} else {
					mv.addObject("msg", "카테고리 삭제가 완료되지 않았습니다.");
					mv.addObject("url", "/hobby/category/list.do");
					mv.setViewName("common/errorPage");
				}
			} else {
				mv.addObject("msg", "권한이 없습니다.");
				mv.addObject("url", "/hobby/category/list.do");
				mv.setViewName("common/errorPage");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("msg", "관리자에게 문의하세요.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
}
