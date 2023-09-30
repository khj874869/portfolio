package com.alone.special.review.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping(value="/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewservice;
	@Autowired 
	private ProductService productservice;
	@Autowired
	private UserService userservice;
		@RequestMapping(value="/insertReview.do",method=RequestMethod.POST)
		public ModelAndView insertReviewPost(ModelAndView mv,@ModelAttribute Review review,@RequestParam(value="uploadFile",required=false) MultipartFile uploadFile,
	    		HttpServletRequest request,HttpSession session,
	    		Model model,@RequestParam("sProductId") Integer sProductId) {
			try {
				 String userId = (String)session.getAttribute("userId");
				  User user = userservice.selectOneById(userId);
			        if (userId != null && !userId.isEmpty()) {
			            // 리뷰 정보 설정
			            review.setsUserId(userId);
			            review.setsUserNo(user.getUserNo());
			            review.setsProductId(sProductId); // Product에서 상품 ID 가져와서 설정

			            // 파일 업로드 처리
			            if (uploadFile != null && !uploadFile.getOriginalFilename().isEmpty()) {
			                Map<String, Object> sMap = this.saveFile(uploadFile, request);
			                String fileName = (String) sMap.get("fileName");
			                String fileRename = (String) sMap.get("fileRename");
			                String savePath = (String) sMap.get("savePath");
			                long fileLength = (long) sMap.get("fileLength");

			                review.setsFileName(fileName);
			                review.setsFileReName(fileRename);
			                review.setsFilePath(savePath);
			                review.setsFileLength(fileLength);
			            }

			            // 리뷰 인서트 처리
			            int result = reviewservice.insertReview(review);

			            if (result > 0) {
			                mv.setViewName("redirect:/product/sdetail.do?sProductId=" + sProductId);
			            } else {
			                mv.setViewName("redirect:/index.jsp");
			            }
			        } else {
			            mv.setViewName("redirect:/index.jsp");
			        }
			    } catch (Exception e) {
			        mv.setViewName("redirect:/index.jsp");
			    }
			    return mv;
			}
	@RequestMapping(value="/editReview.do",method=RequestMethod.POST)
	public ModelAndView editReview (ModelAndView mv,@ModelAttribute Review review,@RequestParam(value="uploadFile",required=false) MultipartFile uploadFile,
    		HttpServletRequest request,HttpSession session,
    		@RequestParam(value = "editReviewContent") String editedContent,
    		Model model,@RequestParam("sProductId") Integer sProductId,
    		@RequestParam("sReviewId") Integer sReviewId) {
		try {
			  String sReviewUserId = (String) session.getAttribute("userId");
		        if (sReviewUserId != null && !sReviewUserId.equals("")) {
		        	review.setsUserId(sReviewUserId);
		        	review.setsReviewContent(editedContent);
		        	review.setsReviewId(sReviewId);
		            // 파일 업로드 처리
		            if (uploadFile != null && !uploadFile.getOriginalFilename().isEmpty()) {
		                Map<String, Object> sMap = this.saveFile(uploadFile, request);
		                String fileName = (String) sMap.get("fileName");
		                String fileRename = (String) sMap.get("fileRename");
		                String savePath = (String) sMap.get("savePath");
		                long fileLength = (long) sMap.get("fileLength");

		                review.setsFileName(fileName);
		                review.setsFileReName(fileRename);
		                review.setsFilePath(savePath);
		                review.setsFileLength(fileLength);
		            }

		            // 리뷰 수
		            int result = reviewservice.editReview(review);

		            if (result > 0) {
		                mv.setViewName("redirect:/product/sdetail.do?sProductId=" + sProductId);
		            } else {
		                mv.setViewName("redirect:/index.jsp");
		            }
		        } else {
		            mv.setViewName("redirect:/index.jsp");
		        }
		    } catch (Exception e) {
		    	e.printStackTrace();
		        mv.setViewName("redirect:/index.jsp");
		    }
		    return mv;
		}
	
	  @GetMapping("/singo.do")
	    public ModelAndView showSingoPage(ModelAndView mv,@RequestParam("sReviewId") Integer sReviewId) {
		  	Review rv = reviewservice.selectOne(sReviewId);
		  	Product product = productservice.selectProductById(rv.getsProductId());
		  	mv.addObject("rv",rv).addObject("Product",product).setViewName("sProduct/singo");
		  	return mv;
	    }
	  
	  @PostMapping("/insertrecommend.do")
	  @ResponseBody
	  public int likeComment(@RequestParam("reviewId") Integer reviewId) {
	      int result = reviewservice.updatelike(reviewId);
	      return result;
	  }
	    
	    @RequestMapping(value="deleteReview.do",method=RequestMethod.GET)
	    public ModelAndView deleteReview(@RequestParam("sReviewId") Integer ReviewId ,ModelAndView mv,@RequestParam Integer sProductId) {
	    	int result = reviewservice.deletereview(ReviewId);

            if (result > 0) {
                mv.setViewName("redirect:/product/sdetail.do?sProductId=" + sProductId);
            } else {
                mv.setViewName("redirect:/index.jsp");
            }
            return mv;
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
		   

	    
	    private void deleteFile(HttpServletRequest request, String fileName) {
			String root = request.getSession().getServletContext().getRealPath("resources");
			String delFilepath = root+"\\nuploadFiles\\"+fileName;
			File file = new File(delFilepath);
			if(file.exists()) {
				file.delete();
			}
	    
	}}

