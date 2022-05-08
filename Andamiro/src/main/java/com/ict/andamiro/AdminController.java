package com.ict.andamiro;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ict.domain.CategoryVO;
import com.ict.domain.ProductVO;
import com.ict.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private AdminService adminService;
	
	@GetMapping("index")
	public String adminPage() {
		
		return "/admin/index";
	}
	
	//@RequestMapping(value="/prodForm", method=RequestMethod.GET)
	@GetMapping("/prodForm")
	public String productRegister(Model m) {
		List<CategoryVO> cgList = this.adminService.getCategoryList();
		logger.info("cgList ={} ", cgList);
		m.addAttribute("cgList",cgList);
		return "admin/prodForm";
	}
	
	// post방식 요청일 때는 상품등록 로직처리
	//@RequestMapping(value="/prodForm",method=RequestMethod.POST)
	@PostMapping("/prodForm")
	public String productRegisterProcess(Model m, 
			@RequestParam("mpimage") List<MultipartFile> mpimage,
			@ModelAttribute("item") ProductVO item,
			HttpServletRequest req) {
	logger.info("item={}",item);
	logger.info("mpimage={}",mpimage);
	// 1. 파일 업로드 처리
	// 1_1. 업로드 디렉토리의 절대경로 구하기
	// webapp/product_images
	
	ServletContext app = req.getServletContext();
	String UP_DIR = app.getRealPath("/product_images");
	logger.info("UP_DIR={}",UP_DIR);
	
	//1_2 업로드 처리
	if (!mpimage.isEmpty()) {
		for (int i = 0; i < mpimage.size(); i++) {
			MultipartFile mf = mpimage.get(i);
			try {
				mf.transferTo(new File(UP_DIR, mf.getOriginalFilename()));
				if (i == 0) {
					item.setPimage1(mf.getOriginalFilename());
					// 파일명을 ProductVO에 셋팅
				} else if (i == 1) {
					item.setPimage2(mf.getOriginalFilename());
				} else if (i == 2) {
					item.setPimage3(mf.getOriginalFilename());
				}
			} catch (Exception e) {
				logger.error("파일업로드 에러 : {} ", e);
			}
		}
	}
	
	int n = this.adminService.productInsert(item);
	
	String str = (n > 0) ? "상품 등록 완료" : "상품 등록 실패";
	String loc = (n > 0) ? "prodList" : "javascript:history.back()";
	
	m.addAttribute("msg",str);
	m.addAttribute("loc",loc);
	return "memo/msg";
	}
	
	@GetMapping("/prodList")
	public String productList(Model m){
		List<ProductVO> prodArr=adminService.productList();
		m.addAttribute("prodArr",prodArr);
		return "admin/prodList";
	}
	@GetMapping("/cateMgr")
	public String categoryManage() {
		
		return "/admin/categoryManage";
	}
	@GetMapping("/cateAdd")
	   public String categoryInsert(Model m, @ModelAttribute("cvo") CategoryVO cvo) {
	      logger.info("cvo={}", cvo.getCg_name());
	      int n = this.adminService.categoryAdd(cvo);
	      m.addAttribute("result", n);
	      return "/admin/cateAddResult";
	   }
	@GetMapping("categoryAll")
	public String categoryList(Model m) {
		List<CategoryVO> cateAll = this.adminService.getCategoryList();
		
		m.addAttribute("cateAll",cateAll);
		return "admin/categoryList";
	}
	@RequestMapping("cateDel")
	public String cateDelete(Model m,@RequestParam(defaultValue="0") int cg_num) {
		logger.info("cg_num={}", cg_num);
		
		int n = adminService.categoryDelete(cg_num);
		
		m.addAttribute("result",n);
		return "/admin/cateAddResult";
	}
	/*
	 * @ExceptionHandler(SQLException.class) public String except(Exception ex,Model
	 * m) { m.addAttribute("msg","등록된 상품이 있어 삭제 불가능합니다");
	 * m.addAttribute("loc","javascript:history.back()"); return "memo/msg"; }
	 */
}
