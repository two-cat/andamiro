package com.ict.andamiro;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.ict.domain.PagingVO;
import com.ict.domain.ProductVO;
import com.ict.service.ShopService;

@Controller
public class ProductController {
	   private static final Logger logger
	      =LoggerFactory.getLogger(ProductController.class);
	   
	   @Inject
	   private ShopService shopService;
	   
	   // 축산물
	   @GetMapping("/livestockProd")
	   public String productByLivestockProd(Model m,
				HttpServletRequest req,
				@ModelAttribute("page") PagingVO page,
				@RequestParam(name="cg_num_fk", defaultValue="3") int cg_num_fk,
				@RequestHeader("User-Agent") String userAgent) {
			logger.info("userAgent={}", userAgent);
			logger.info("cg_num_fk={}", cg_num_fk);
			
			
		//	int totalCount=this.shopService.getTotalCount();
			int totalCount=this.shopService.getTotalCountByCate(cg_num_fk);
			logger.info("totalCount={}", totalCount);
			
			
			page.setTotalCount(totalCount);
			page.setPageSize(12);//한 페이지 당 보여줄 목록 개수
			page.setPagingBlock(4);//페이징 블럭 단위 값: 5개
			/////////////////////////
			page.init(); //페이징 관련 연산을 수행하는 메소드 호출
			/////////////////////////
			logger.info("init()연산후 page={}", page);
			
			page.setCg_num_fk(cg_num_fk);
			
		//	List<ProductVO> plist=shopService.selectByCategory(cg_num_fk);
			List<ProductVO> plist=shopService.selectByCategory(cg_num_fk,page);
			
			logger.info("plist={}", plist);
			String myctx=req.getContextPath();
			String loc="livestockProd";
		
			String pageNavi=page.getPageNavi(myctx, loc, userAgent);
			
			m.addAttribute("plist",plist);
			m.addAttribute("CG_NUM_FK",cg_num_fk);
			m.addAttribute("totalCount", totalCount);
			m.addAttribute("page", page);
			m.addAttribute("pageNavi", pageNavi);
			
			return "product/livestockProd";
		}
	   // 메인 상품
	   @GetMapping("/livestockMain")
	   public String productByLiveMain(Model m,
				HttpServletRequest req,
				@ModelAttribute("page") PagingVO page,
				@RequestParam(name="cg_num_fk", defaultValue="3") int cg_num_fk,
				@RequestHeader("User-Agent") String userAgent) {
			logger.info("userAgent={}", userAgent);
			logger.info("cg_num_fk={}", cg_num_fk);
			
			
		//	int totalCount=this.shopService.getTotalCount();
			int totalCount=this.shopService.getTotalCountByCate(cg_num_fk);
			logger.info("totalCount={}", totalCount);
			
			
			page.setTotalCount(totalCount);
			page.setPageSize(12);//한 페이지 당 보여줄 목록 개수
			page.setPagingBlock(4);//페이징 블럭 단위 값: 5개
			/////////////////////////
			page.init(); //페이징 관련 연산을 수행하는 메소드 호출
			/////////////////////////
			logger.info("init()연산후 page={}", page);
			
			page.setCg_num_fk(cg_num_fk);
			
		//	List<ProductVO> plist=shopService.selectByCategory(cg_num_fk);
			List<ProductVO> plist=shopService.selectByCategory(cg_num_fk,page);
			
			logger.info("plist={}", plist);
			String myctx=req.getContextPath();
			String loc="cropsProd";
		
			String pageNavi=page.getPageNavi(myctx, loc, userAgent);
			
			m.addAttribute("plist",plist);
			m.addAttribute("CG_NUM_FK",cg_num_fk);
			m.addAttribute("totalCount", totalCount);
			m.addAttribute("page", page);
			m.addAttribute("pageNavi", pageNavi);
			
			return "product/livestockMain";
		}
	   
	   // 농산물
		@GetMapping("/cropsMain")
		public String productBycpMain(Model m,
				HttpServletRequest req,
				@ModelAttribute("page") PagingVO page,
				@RequestParam(name="cg_num_fk", defaultValue="1") int cg_num_fk,
				@RequestHeader("User-Agent") String userAgent) {
			logger.info("userAgent={}", userAgent);
			logger.info("cg_num_fk={}", cg_num_fk);
			
			
		//	int totalCount=this.shopService.getTotalCount();
			int totalCount=this.shopService.getTotalCountByCate(cg_num_fk);
			logger.info("totalCount={}", totalCount);
			
			
			page.setTotalCount(totalCount);
			page.setPageSize(12);//한 페이지 당 보여줄 목록 개수
			page.setPagingBlock(4);//페이징 블럭 단위 값: 5개
			/////////////////////////
			page.init(); //페이징 관련 연산을 수행하는 메소드 호출
			/////////////////////////
			logger.info("init()연산후 page={}", page);
			
			page.setCg_num_fk(cg_num_fk);
			
		//	List<ProductVO> plist=shopService.selectByCategory(cg_num_fk);
			List<ProductVO> plist=shopService.selectByCategory(cg_num_fk,page);
			
			logger.info("plist={}", plist);
			String myctx=req.getContextPath();
			String loc="livestockProd";
		
			String pageNavi=page.getPageNavi(myctx, loc, userAgent);
			
			m.addAttribute("plist",plist);
			m.addAttribute("CG_NUM_FK",cg_num_fk);
			m.addAttribute("totalCount", totalCount);
			m.addAttribute("page", page);
			m.addAttribute("pageNavi", pageNavi);
			
			return "product/cropsMain";
		}
		
		@GetMapping("/cropsProd")
		public String productBycp(Model m,
				HttpServletRequest req,
				@ModelAttribute("page") PagingVO page,
				@RequestParam(name="cg_num_fk", defaultValue="1") int cg_num_fk,
				@RequestHeader("User-Agent") String userAgent) {
			logger.info("userAgent={}", userAgent);
			logger.info("cg_num_fk={}", cg_num_fk);
			
			
		//	int totalCount=this.shopService.getTotalCount();
			int totalCount=this.shopService.getTotalCountByCate(cg_num_fk);
			logger.info("totalCount={}", totalCount);
			
			
			page.setTotalCount(totalCount);
			page.setPageSize(12);//한 페이지 당 보여줄 목록 개수
			page.setPagingBlock(4);//페이징 블럭 단위 값: 5개
			/////////////////////////
			page.init(); //페이징 관련 연산을 수행하는 메소드 호출
			/////////////////////////
			logger.info("init()연산후 page={}", page);
			
			page.setCg_num_fk(cg_num_fk);
			
		//	List<ProductVO> plist=shopService.selectByCategory(cg_num_fk);
			List<ProductVO> plist=shopService.selectByCategory(cg_num_fk,page);
			
			logger.info("plist={}", plist);
			String myctx=req.getContextPath();
			String loc="cropsProd";
		
			String pageNavi=page.getPageNavi(myctx, loc, userAgent);
			
			m.addAttribute("plist",plist);
			m.addAttribute("CG_NUM_FK",cg_num_fk);
			m.addAttribute("totalCount", totalCount);
			m.addAttribute("page", page);
			m.addAttribute("pageNavi", pageNavi);
			
			return "product/cropsProd";
		}
		
		@GetMapping("/seafoodProd")
		public String productBysf(Model m,
				HttpServletRequest req,
				@ModelAttribute("page") PagingVO page,
				@RequestParam(name="cg_num_fk", defaultValue="2") int cg_num_fk,
				@RequestHeader("User-Agent") String userAgent) {
			logger.info("userAgent={}", userAgent);
			logger.info("cg_num_fk={}", cg_num_fk);
			
			
			//int totalCount=this.shopService.getTotalCount();
			int totalCount=this.shopService.getTotalCountByCate(cg_num_fk);		logger.info("totalCount={}", totalCount);
			
			
			page.setTotalCount(totalCount);
			page.setPageSize(12);//한 페이지 당 보여줄 목록 개수
			page.setPagingBlock(4);//페이징 블럭 단위 값: 5개
			/////////////////////////
			page.init(); //페이징 관련 연산을 수행하는 메소드 호출
			/////////////////////////
			logger.info("init()연산후 page={}", page);
			
			page.setCg_num_fk(cg_num_fk);
			
		//	List<ProductVO> plist=shopService.selectByCategory(cg_num_fk);
			List<ProductVO> plist=shopService.selectByCategory(cg_num_fk,page);
			
			logger.info("plist={}", plist);
			String myctx=req.getContextPath();
			String loc="seafoodProd";
		
			String pageNavi=page.getPageNavi(myctx, loc, userAgent);
			
			m.addAttribute("plist",plist);
			m.addAttribute("CG_NUM_FK",cg_num_fk);
			m.addAttribute("totalCount", totalCount);
			m.addAttribute("page", page);
			m.addAttribute("pageNavi", pageNavi);
			
			return "product/seafoodProd";
		}
		
		
		@GetMapping("/seafoodMain")
		public String productBysfMain(Model m,
				HttpServletRequest req,
				@ModelAttribute("page") PagingVO page,
				@RequestParam(name="cg_num_fk", defaultValue="2") int cg_num_fk,
				@RequestHeader("User-Agent") String userAgent) {
			logger.info("userAgent={}", userAgent);
			logger.info("cg_num_fk={}", cg_num_fk);
			
			
			//int totalCount=this.shopService.getTotalCount();
			int totalCount=this.shopService.getTotalCountByCate(cg_num_fk);		logger.info("totalCount={}", totalCount);
			
			
			page.setTotalCount(totalCount);
			page.setPageSize(12);//한 페이지 당 보여줄 목록 개수
			page.setPagingBlock(4);//페이징 블럭 단위 값: 5개
			/////////////////////////
			page.init(); //페이징 관련 연산을 수행하는 메소드 호출
			/////////////////////////
			logger.info("init()연산후 page={}", page);
			
			page.setCg_num_fk(cg_num_fk);
			
		//	List<ProductVO> plist=shopService.selectByCategory(cg_num_fk);
			List<ProductVO> plist=shopService.selectByCategory(cg_num_fk,page);
			
			logger.info("plist={}", plist);
			String myctx=req.getContextPath();
			String loc="seafoodProd";
		
			String pageNavi=page.getPageNavi(myctx, loc, userAgent);
			
			m.addAttribute("plist",plist);
			m.addAttribute("CG_NUM_FK",cg_num_fk);
			m.addAttribute("totalCount", totalCount);
			m.addAttribute("page", page);
			m.addAttribute("pageNavi", pageNavi);
			
			return "product/seafoodMain";
		}
	   
	   @GetMapping("/prodDetail")
	   public String productDetail(Model m, @RequestParam(defaultValue="0") int pnum) {
		   logger.info("pnum={}",pnum);
		   
		   if(pnum==0) {
			   //유효성 체크
			   return "redirect:index";
		   }
		   // 상품번호로 상품 가져오기
		   ProductVO prod = shopService.selectByPnum(pnum);
		   logger.info("prod={}", prod);
		   // 모델에 저장하기 => key값 => "item"
		   m.addAttribute("item",prod);
		   return "product/prodDetail";
	   }
}
