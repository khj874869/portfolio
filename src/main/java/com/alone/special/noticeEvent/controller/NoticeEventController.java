package com.alone.special.noticeEvent.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alone.special.noticeEvent.domain.NewsRoom;
import com.alone.special.noticeEvent.domain.NoticeEvent;
import com.alone.special.noticeEvent.domain.PageInfo;
import com.alone.special.noticeEvent.service.NoticeEventService;


@Controller
public class NoticeEventController {
	
	@Autowired
	private NoticeEventService nService;
	
	@RequestMapping(value="/noticeEvent/write.do", method=RequestMethod.GET)
	public ModelAndView showNoticeEventWriteForm(ModelAndView mv) {
		mv.setViewName("noticeEvent/write");
		return mv;
	}
	
	@RequestMapping(value="/noticeEvent/write.do", method=RequestMethod.POST)
	public ModelAndView insertNoticeEvent(ModelAndView mv,
			@RequestParam(value="uploadFile",required=false) MultipartFile uploadFile,
			@ModelAttribute NoticeEvent noticeEvent,
			HttpServletRequest request) {
		try {
			if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
				// 파일 정보 및 저장
				Map<String, Object> bMap = this.saveFile(request, uploadFile);
				noticeEvent.setBoardFileName((String)bMap.get("fileName"));
				noticeEvent.setBoardFileRename((String)bMap.get("fileRename"));
				noticeEvent.setBoardFilePath((String)bMap.get("filePath"));
				noticeEvent.setBoardFileLength((long)bMap.get("fileLength"));
			}
			System.out.println(noticeEvent.getBoardType());
			if(noticeEvent.getBoardType().equals("NOTICE")) {
				mv.setViewName("redirect:/notice/list.do");
			} else {
				mv.setViewName("redirect:/eventd/list.do");
			}
			int result = nService.insertNoticeEvent(noticeEvent);
		} catch (Exception e) {
			mv.addObject("msg", "공지사항/행사 등록이 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/notice/list.do", method=RequestMethod.GET)
	public ModelAndView showNoticeList(ModelAndView mv,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = nService.getNoticeListCount();
			PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
			List<NoticeEvent> nList = nService.selectNoticeList(pInfo);
			if(!nList.isEmpty()) {
				mv.addObject("nList", nList).addObject("pInfo", pInfo).setViewName("noticeEvent/notice");
			} else {
				mv.addObject("msg", "공지사항 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "공지사항 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/event/list.do", method=RequestMethod.GET)
	public ModelAndView showEventList(ModelAndView mv,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			Integer totalCount = nService.getEventListCount();
			PageInfo pInfo = this.getPageInfoEvent(totalCount, currentPage);
			List<NoticeEvent> eList = nService.selectEventList(pInfo);
			if(!eList.isEmpty()) {
				mv.addObject("eList", eList).addObject("pInfo", pInfo).setViewName("noticeEvent/event");
			} else {
				mv.addObject("msg", "행사 조회가 완료되지 않았습니다.");
				mv.addObject("url", "/index.jsp");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "행사 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/newsRoom/list.do", method=RequestMethod.GET)
	public ModelAndView showNews(ModelAndView mv,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			int page = 0;
			String query = "1인가구";
			PageInfo pInfo = this.getPageInfo(50, currentPage);
			List<NewsRoom> nList = new ArrayList<NewsRoom>();
			List<String> linkList = new ArrayList<String>();
			List<String> sourceList = new ArrayList<String>();
			List<String> titleList = new ArrayList<String>();
			List<String> timeList = new ArrayList<String>();
			NewsRoom news =  null;
			while(page < 50) {
				String address = "https://www.google.com/search?q="+query+"&sca_esv=562622979&tbs=qdr:w&tbm=nws&sxsrf=AB5stBi_dHsefUAQUJ0lt87lS6i8Q2KwAA:1693884681565&ei=CaH2ZJCPIrLh2roPzrGXsAE&start="+Integer.toString(page)+"&sa=N&ved=2ahUKEwjQt_CVxJKBAxWysFYBHc7YBRY4WhDy0wN6BAgEEAQ&biw=1569&bih=919&dpr=";
				Document doc = Jsoup.connect(address).get();
				Elements LinkElements = doc.getElementsByClass("WlydOe");
				for(Element element : LinkElements ) {
					linkList.add(element.attr("href"));
				}
				Elements NewsSourceElements = doc.select("div.MgUUmf > span");
				for(Element element : NewsSourceElements) {
					sourceList.add(element.text());
				}
				Elements titleElements = doc.select("div.n0jPhd");
				for(Element element : titleElements) {
					titleList.add(element.text());
				}
				Elements timeElements = doc.select("div.OSrXXb > span");
				for(Element element : timeElements) {
					timeList.add(element.text());
				}
				
				page += 10;
			}
			for(int i = 0; i < linkList.size(); i++) {
				news = new NewsRoom(titleList.get(i), linkList.get(i), sourceList.get(i), timeList.get(i));
				nList.add(news);
			}
			System.out.println(nList);
			mv.addObject("nList", nList).addObject("pInfo", pInfo).setViewName("noticeEvent/newsRoom");
		} catch (IOException e) {
			mv.addObject("msg", "뉴스 업데이트가 완료되지 않았습니다.");
			mv.addObject("error", "뉴스 조회 실패");
			mv.addObject("url", "/index.jsp");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/newsRoom/search.do", method=RequestMethod.GET)
	public ModelAndView showNewsSearch(ModelAndView mv,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", required=false, defaultValue="1") Integer currentPage) {
		try {
			int page = 0;
			String query = searchKeyword;
			PageInfo pInfo = this.getPageInfo(30, currentPage);
			List<NewsRoom> sList = new ArrayList<NewsRoom>();
			List<String> linkList = new ArrayList<String>();
			List<String> sourceList = new ArrayList<String>();
			List<String> titleList = new ArrayList<String>();
			List<String> timeList = new ArrayList<String>();
			NewsRoom news =  null;
			while(page < 30) {
				String address = "https://www.google.com/search?q="+query+"&sca_esv=562622979&tbs=qdr:w&tbm=nws&sxsrf=AB5stBi_dHsefUAQUJ0lt87lS6i8Q2KwAA:1693884681565&ei=CaH2ZJCPIrLh2roPzrGXsAE&start="+Integer.toString(page)+"&sa=N&ved=2ahUKEwjQt_CVxJKBAxWysFYBHc7YBRY4WhDy0wN6BAgEEAQ&biw=1569&bih=919&dpr=";
				Document doc = Jsoup.connect(address).get();
				Elements LinkElements = doc.getElementsByClass("WlydOe");
				for(Element element : LinkElements ) {
					linkList.add(element.attr("href"));
				}
				Elements NewsSourceElements = doc.select("div.MgUUmf > span");
				for(Element element : NewsSourceElements) {
					sourceList.add(element.text());
				}
				Elements titleElements = doc.select("div.n0jPhd");
				for(Element element : titleElements) {
					titleList.add(element.text());
				}
				Elements timeElements = doc.select("div.OSrXXb > span");
				for(Element element : timeElements) {
					timeList.add(element.text());
				}
				
				page += 10;
			}
			for(int i = 0; i < linkList.size(); i++) {
				news = new NewsRoom(titleList.get(i), linkList.get(i), sourceList.get(i), timeList.get(i));
				sList.add(news);
			}
			mv.addObject("searchKeyword", searchKeyword).addObject("sList", sList).addObject("pInfo", pInfo).setViewName("noticeEvent/newsRoomSearch");
		} catch (IOException e) {
			mv.addObject("msg", "뉴스 검색이 완료되지 않았습니다.");
			mv.addObject("error", "뉴스 검색 실패");
			mv.addObject("url", "/index.jsp");
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
	
	public PageInfo getPageInfoEvent(int totalCount,int currentPage) {
		PageInfo page =null;
		int recordCountPerPage = 12;
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
	
	@RequestMapping(value="/notice/search.do", method=RequestMethod.GET)
	public ModelAndView searchNoticeList(ModelAndView mv,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", required=false,defaultValue="1") Integer currentPage
			) {
		int totalCount = nService.getNoticeListCount(searchKeyword);
		PageInfo pInfo = this.getPageInfo(totalCount, currentPage);
		List<NoticeEvent> searchList = nService.searchNoticeByKeyword(pInfo, searchKeyword);
		if(!searchList.isEmpty()) {
			mv.addObject("searchKeyword", searchKeyword);
			mv.addObject("pInfo", pInfo);
			mv.addObject("sList", searchList);
			mv.setViewName("noticeEvent/noticeSearch");
		} else {
			mv.addObject("msg", "검색 조회 실패");
			mv.addObject("url", "/notice/list.do");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/event/search.do", method=RequestMethod.GET)
	public ModelAndView searchEventList(ModelAndView mv,
			@RequestParam("searchKeyword") String searchKeyword,
			@RequestParam(value="currentPage", required=false,defaultValue="1") Integer currentPage
			) {
		int totalCount = nService.getEventListCount(searchKeyword);
		PageInfo pInfo = this.getPageInfoEvent(totalCount, currentPage);
		List<NoticeEvent> searchList = nService.searchEventByKeyword(pInfo, searchKeyword);
		if(!searchList.isEmpty()) {
			mv.addObject("searchKeyword", searchKeyword);
			mv.addObject("pInfo", pInfo);
			mv.addObject("sList", searchList);
			mv.setViewName("noticeEvent/eventSearch");
		} else {
			mv.addObject("msg", "검색 조회 실패");
			mv.addObject("url", "/event/list.do");
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/noticeEvent/detail.do", method=RequestMethod.GET)
	public ModelAndView showNoticeDetail(ModelAndView mv,
			@RequestParam("boardNo") Integer boardNo) {
		try {
			NoticeEvent noticeOne = nService.selectNoticeByNo(boardNo);
			if(noticeOne != null) {
				mv.addObject("notice", noticeOne);
				mv.setViewName("noticeEvent/noticeDetail");
			} else {
				mv.addObject("msg", "공지/행사 상세 조회 실패");
				mv.addObject("url", "/notice/list.do");
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "공지/행사 상세 조회가 완료되지 않았습니다.");
			mv.addObject("url", "/notice/list.do");
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/noticeEvent/delete.do", method=RequestMethod.GET)
	public ModelAndView deleteNotice(ModelAndView mv,
			@RequestParam("boardNo") Integer boardNo,
			@RequestParam("boardType") String boardType,
			HttpServletRequest request,
			@RequestParam("boardFileRename") String boardFileRename) {
		try {
			if(boardFileRename != "") {
				deleteFile(request, boardFileRename);
			}
			int result = nService.deleteNotice(boardNo);
			if(result > 0) {
				if(boardType.equals("NOTICE")) {
					mv.setViewName("redirect:/notice/list.do");
				} else {
					mv.setViewName("redirect:/event/list.do");
				}
			} else {
				mv.addObject("msg", "공지/행사 삭제 실패");
				mv.addObject("url", "/noticeEvent/detail.do?boardNo="+boardNo);
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "공지/행사 상세 삭제가 완료되지 않았습니다.");
			mv.addObject("url", "/noticeEvent/detail.do?boardNo="+boardNo);
			mv.setViewName("common/errorPage");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/noticeEvent/modify.do", method=RequestMethod.GET)
	public ModelAndView showModifyNoticeForm(ModelAndView mv,
			@RequestParam("boardNo") Integer boardNo) {
		try {
			NoticeEvent noticeEvent = nService.selectNoticeByNo(boardNo);
			mv.addObject("noticeEvent", noticeEvent);
			mv.setViewName("noticeEvent/modify");
		} catch (Exception e) {
			mv.addObject("msg", "게시글 수정페이지 로딩이 완료되지 않았습니다.");
			mv.addObject("url", "/noticeEvent/detail.do?boardNo="+boardNo);
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
	
	@RequestMapping(value="/noticeEvent/modify.do", method=RequestMethod.POST)
	public ModelAndView modifyNoticeEvent(ModelAndView mv,
			@ModelAttribute NoticeEvent noticeEvent,
			@RequestParam(value="uploadFile", required=false) MultipartFile uploadFile,
			@RequestParam(value="fileDelete", required=false) boolean fileDelete,
			HttpServletRequest request) {
		try {
			if(uploadFile != null && !uploadFile.isEmpty()) {
				// 기존 업로드된 파일 존재 여부 체크
				String fileRename = noticeEvent.getBoardFileRename();
				if(fileRename != null) {
					// 있으면 기존 파일 삭제
					this.deleteFile(request, fileRename);
				}
				// 없으면 새로 업로드 하려는 파일 저장
				Map<String, Object> infoMap = this.saveFile(request, uploadFile);
				noticeEvent.setBoardFileName((String)infoMap.get("fileName"));
				noticeEvent.setBoardFileRename((String)infoMap.get("fileRename"));
				noticeEvent.setBoardFilePath((String)infoMap.get("filePath"));
				noticeEvent.setBoardFileLength((long)infoMap.get("fileLength"));
			} else if(fileDelete == true) {
				String fileRename = noticeEvent.getBoardFileRename();
				if (fileRename != null) {
					this.deleteFile(request, fileRename); 
				} 
				noticeEvent.setBoardFileName("");
				noticeEvent.setBoardFileRename("");
				noticeEvent.setBoardFilePath("");
				noticeEvent.setBoardFileLength(0);
			}
				 

			int result = nService.modifyNoticeEvent(noticeEvent);
			if(result > 0) {
				mv.setViewName("redirect:/noticeEvent/detail.do?boardNo="+noticeEvent.getBoardNo());
			} else {
				mv.addObject("msg", "게시글 수정이 완료되지 않았습니다.");
				mv.addObject("error", "게시글 수정 실패");
				mv.addObject("url", "/noticeEvent/detail.do?boardNo="+noticeEvent.getBoardNo());
				mv.setViewName("common/errorPage");
			}
		} catch (Exception e) {
			mv.addObject("msg", "게시글 수정이 완료되지 않았습니다.");
			mv.addObject("url", "/noticeEvent/detail.do?boardNo="+noticeEvent.getBoardNo());
			mv.setViewName("common/errorPage");
		}
		return mv;
	}
			
	
	public Map<String, Object> saveFile(HttpServletRequest request, MultipartFile uploadFile) throws Exception, IOException{
		Map<String, Object> fileMap = new HashMap<String, Object>();
		// resources 경로 구하기
		String root = request.getSession().getServletContext().getRealPath("resources");
		// 파일 저장 경로 구하기
		String savePath = root + "\\nuploadFiles";
		// 파일 이름 구하기
		String fileName = uploadFile.getOriginalFilename();
		// 파일 확장자 구하기
		String extension = fileName.substring(fileName.lastIndexOf(".")+1);
		// 시간으로 파일 리네임하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileRename = sdf.format(new Date(System.currentTimeMillis())) + "." + extension;
		// 파일 저장 전 폴더 만들기
		File saveFolder = new File(savePath);
		if(!saveFolder.exists()) {
			saveFolder.mkdir();
		}
		// 파일 저장
		File saveFile = new File(savePath+"\\"+fileRename);
		uploadFile.transferTo(saveFile);
		// 파일 크기 구하기
		long fileLength = uploadFile.getSize();
		// 파일 정보 리턴
		fileMap.put("fileName", fileName);
		fileMap.put("fileRename", fileRename);
		fileMap.put("filePath", "../resources/nuploadFiles/"+fileRename);
		fileMap.put("fileLength", fileLength);
		return fileMap;
	}
	
	private void deleteFile(HttpServletRequest request, String fileRename) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String delFilepath = root + "\\nuploadFiles\\" + fileRename;
		File file = new File(delFilepath);
		if(file.exists()) {
			file.delete();
		}
	}
}
