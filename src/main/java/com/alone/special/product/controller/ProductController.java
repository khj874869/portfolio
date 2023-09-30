package com.alone.special.product.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alone.special.product.domain.Product;
import com.alone.special.product.domain.ProductPageInfo;
import com.alone.special.product.service.ProductService;
import com.alone.special.review.domain.Review;
import com.alone.special.review.domain.ReviewPageInfo;
import com.alone.special.review.service.ReviewService;
import com.alone.special.user.domain.User;
import com.alone.special.user.service.UserService;

@Controller
@RequestMapping("/product")
public class ProductController {
	 @Autowired
	    private ProductService productservice;
	 @Autowired
	 	private ReviewService reviewservice;
	 @Autowired
		private UserService userservice;
	 @RequestMapping(value="/sdetail.do", method=RequestMethod.GET)
		public ModelAndView showNoticeDetail(
				@RequestParam("sProductId") Integer sProductId,@RequestParam(value="page",required=false,defaultValue="1") Integer currentPage
				,ModelAndView mv,HttpServletRequest request,HttpServletResponse response,HttpSession session ) {
		 try {
			 	String sReviewUserId = (String) session.getAttribute("userId");
			 	User user = userservice.selectOneById(sReviewUserId);
		 		int totalCount = reviewservice.getListCount();
		 		Product ProductOne = productservice.selectProductById(sProductId);
		 		ReviewPageInfo rInfo = this.getReviewPageInfo(currentPage,totalCount);
		        List<Review> reviews = reviewservice.getProductReviews(sProductId,rInfo);
				if(reviews.size()>0) {
				     mv.addObject("rInfo", rInfo);
				     mv.addObject("Product", ProductOne);
				     mv.addObject("Reviews", reviews);
				     mv.addObject("UserId",sReviewUserId);
				     mv.addObject("User", user);
				     mv.setViewName("sProduct/sdetail");
				     
				}else {
					mv.addObject("Product",ProductOne).addObject("Reviews", reviews).addObject("rInfo",rInfo).addObject("UserId", sReviewUserId).setViewName("sProduct/sdetail");
				}
				}
		
		 catch (Exception e) {
			 e.printStackTrace();
				mv.setViewName("sProduct/slistproduct");
			}
	    	return mv;
	    }
	 
	  
private ReviewPageInfo getReviewPageInfo(Integer currentPage, int totalCount) {
	   ReviewPageInfo rpi =null;
	int recordCountPerPage = 7;
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
 	rpi = new ReviewPageInfo(currentPage, recordCountPerPage, naviCountPerPage, startNavi, endNavi, totalCount, naviTotalCount);
 	
 	return rpi;
	}
	

		@RequestMapping(value = "/insertproduct.do", method = RequestMethod.GET)
	    public ModelAndView getInsertProduct() { 
	        ModelAndView mv = new ModelAndView("sProduct/insertproduct"); 
	        return mv;
	    }

	    @RequestMapping(value = "/insertproduct.do", method = RequestMethod.POST)
	    public String insertProduct(@ModelAttribute Product product
	    		,@RequestParam(value="uploadFile",required=false) MultipartFile uploadFile,
	    		HttpServletRequest request,
	    		Model model
	    		) {
	    	try {
	    		if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
	    			Map<String, Object> sMap = this.saveFile(uploadFile,request);
	    		    String fileName = (String) sMap.get("fileName");
	    		    String fileRename = (String) sMap.get("fileRename");
	    		    String savePath = (String) sMap.get("savePath");
	    		    long fileLength = (long) sMap.get("fileLength");

	    			
	    		    product.setsFileName(fileName);
	    		    product.setsFileReName(fileRename);
	    		    product.setsFilePath(savePath);
	    		    product.setsFileLength(fileLength);
	    			
	    		}
	    		int result = productservice.insertProduct(product);
	    		if(result>0) {
	    			return "redirect:/product/slistproduct.do";
	    		}else {
	    			return "common/goDirect";
	    		}
			} catch (Exception e) {
				model.addAttribute("msg", "");
				model.addAttribute("error", e.getMessage());
				model.addAttribute("url", "/user/register.jsp");
				return "common/errorPage";
			}
	    }
	    
	    @RequestMapping(value="/update.do",method=RequestMethod.GET)
	    public ModelAndView updateProduct(ModelAndView mv,@RequestParam("sProductId") Integer sProductId) {
	    	Product productOne = productservice.selectProductById(sProductId);
	    	mv.addObject("Product",productOne).setViewName("sProduct/modifyproduct");;
	    	return mv;
	    }
	    @RequestMapping(value="/update.do",method=RequestMethod.POST)
	    public ModelAndView updateProductPost(ModelAndView mv,@ModelAttribute Product product,@RequestParam(value="uploadFile",required=false) MultipartFile uploadFile,
	    		Model model, HttpServletRequest request) {
	    	try {
	    		if(uploadFile != null && !uploadFile.isEmpty()) {
		    		String fileName = product.getsFileReName();
		    		if(fileName !=null) {
		    			this.deleteFile(request,fileName);
		    		}
		    		Map<String,Object> sMap = this.saveFile(uploadFile, request);
		    		String productFilename = (String)sMap.get("fileName");
		    		long productFilelength = (long)sMap.get("fileLength");
		    		product.setsFileName(productFilename);
		    		product.setsFileReName((String)sMap.get("fileRename"));
		    		product.setsFilePath((String)sMap.get("savePath"));
		    		product.setsFileLength(productFilelength);
		    				
		    	}
		    	int result =productservice.updateProduct(product);
		    	if(result>0) {
		    		
		    		mv.setViewName("redirect:/product/sdetail.do?sProductId="+product.getsProductId()); 
		    			
		    	}else {
		    		mv.setViewName("sProduct/insertproduct");
		    	}
			} catch (Exception e) {
	    		mv.setViewName("sProduct/insertproduct");
	    		return mv;
			}
	    	return mv;
	    }
	    @RequestMapping(value="/delete.do",method=RequestMethod.GET)
	    public ModelAndView deleteProduct(ModelAndView mv,@RequestParam(value="page",required=false,defaultValue="1") Integer currentPage,@RequestParam("sProductId") Integer sProductId) {
	    		int result = productservice.deleteProduct(sProductId);
	    		int totalCount = productservice.getListCount();
				ProductPageInfo pInfo = this.getPageInfo(currentPage,totalCount);
				List<Product> pList = productservice.selectProductLust(pInfo);
	    		if(result>0) {
	    			mv.addObject("pInfo", pInfo);
					mv.addObject("pList", pList);
	    			mv.setViewName("redirect:/product/slistproduct.do");
	    		}
	    		return mv;
	    	
	    	
	    	
	    	
	    	
	    }
	    @RequestMapping(value="/slistproduct.do",method=RequestMethod.GET)
	    public ModelAndView showProductList(
	    		@RequestParam(value="page",required=false,defaultValue="1") Integer currentPage,ModelAndView mv)
	    		 {
	    			
	    	try {
				int totalCount = productservice.getListCount();
				ProductPageInfo pInfo = this.getPageInfo(currentPage,totalCount);
				List<Product> pList = productservice.selectProductLust(pInfo);
				if(pList.size()>0) {
					mv.addObject("pInfo", pInfo);
					mv.addObject("pList", pList);
					mv.setViewName("sProduct/slistproduct");
				}else {
					mv.setViewName("sProduct/slistproduct");
				}
				
			} catch (Exception e) {
				mv.setViewName("sProduct/slistproduct");
			}
	    	return mv;
	    }
	    
	    
	    private ProductPageInfo getPageInfo(Integer currentPage, int totalCount) {
	    	ProductPageInfo ppi =null;
	    	int recordCountPerPage = 9;
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
	    	ppi = new ProductPageInfo(currentPage, recordCountPerPage, naviCountPerPage, startNavi, endNavi, totalCount, naviTotalCount);
	    	
	    	return ppi;
		}

		public Map<String, Object> saveFile(MultipartFile uploadFile, HttpServletRequest request) throws Exception {
			Map<String, Object> infoMap = new HashMap<String, Object>();
			String fileName = uploadFile.getOriginalFilename();
			String root = 
					request.getSession().getServletContext()
						.getRealPath("resources");
			String saveFolder = root + "\\images";
			File folder = new File(saveFolder);
			if(!folder.exists()) {
				folder.mkdir();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
			String strResult = sdf.format(new Date(System.currentTimeMillis()));
			String ext = fileName.substring(fileName.lastIndexOf(".")+1); 
			String fileRename = "N"+strResult+"."+ext;
			String savePath = saveFolder + "\\" + fileRename; 
			File file = new File(savePath);
			uploadFile.transferTo(file);
			long fileLength = uploadFile.getSize();
			infoMap.put("fileName", fileName);
			infoMap.put("fileRename", fileRename);
			infoMap.put("savePath", savePath);
			infoMap.put("fileLength", fileLength);
			return infoMap;
		}
		
		@RequestMapping(value="/search.do", method=RequestMethod.GET)
		public ModelAndView searchProductList(
				@RequestParam("searchCondition") String searchCondition
				,@RequestParam("searchKeyword") String searchKeyword
				,@RequestParam(value="page", required=false, defaultValue="1") Integer currentPage
				, ModelAndView mv) {
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("searchCondition", searchCondition);
			paramMap.put("searchKeyword", searchKeyword);
			int totalCount = productservice.getProductListCount(paramMap);
			ProductPageInfo pInfo = this.getPageInfo(currentPage, totalCount);
			List<Product> searchList = productservice.searchNoticesByKeyword(pInfo, paramMap);
			
			if(!searchList.isEmpty()) {
				mv.addObject("searchCondition", searchCondition);
				mv.addObject("searchKeyword", searchKeyword);
				mv.addObject("pInfo", pInfo);
				mv.addObject("pList", searchList);
				mv.setViewName("sProduct/slistproduct"); 
			}else {
				mv.setViewName("redirect:/index.jsp");
			}
			return mv;
		}

		

	        
	    
	    private void deleteFile(HttpServletRequest request, String fileName) {
			String root = request.getSession().getServletContext().getRealPath("resources");
			String delFilepath = root+"\\nuploadFiles\\"+fileName;
			File file = new File(delFilepath);
			if(file.exists()) {
				file.delete();
			}
	    }
}
	    
	    
			
		

		

