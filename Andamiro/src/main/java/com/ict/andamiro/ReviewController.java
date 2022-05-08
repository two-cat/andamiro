package com.ict.andamiro;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ict.domain.MemberVO;
import com.ict.domain.ReviewVO;
import com.ict.service.ReviewService;


@Controller
public class ReviewController {

	@Inject
	private ReviewService reviewService;

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@GetMapping("/reviewForm")
	public String reviewF(Model m, @RequestParam(defaultValue = "0") int pnum

	) {
		logger.info("pnum={}", pnum);
		m.addAttribute("pnum", pnum);

		return "product/reviewForm";
	}

	@PostMapping("/reviewForm")
	public String reviewF2(Model m, @ModelAttribute("rvo") ReviewVO rvo, @RequestParam(defaultValue = "0") int pnum,
			HttpSession session) {

		System.out.println("확인확인");
		logger.info("pnum={}", pnum);

		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		int idx_fk = loginUser.getIdx();
		m.addAttribute("idx_fk");
		logger.info("idx_fk={}", idx_fk);

		// ReviewVO rvo = new ReviewVO();
		rvo.setPnum_fk(pnum);
		rvo.setIdx_fk(idx_fk);

		int n = this.reviewService.insertReview(rvo);
		logger.info("rvo={}", rvo);
//		String str = (n > 0) ? "성공" : "실패";
//		String loc = (n > 0) ? "redirect:prodDetail?pnum=" + rvo.getPnum_fk() : "javascript:history.back()";
//
//		m.addAttribute("msg", str);
//		m.addAttribute("loc", loc);

		return "redirect:prodDetail?pnum=" + rvo.getPnum_fk();
	}

	@GetMapping("/reviewList")
	public String reviewL(Model m, HttpSession session, @RequestParam(defaultValue = "0") int pnum) {
		System.out.println("여기는 리스트");
		logger.info("pnum={}", pnum);
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		List<ReviewVO> reviewArr = this.reviewService.listReview(pnum);

		m.addAttribute("reviewArr", reviewArr);
		return "product/reviewList";
	}

	@GetMapping("/reviewDel")
	public String reviewD(Model m, @RequestParam(defaultValue = "0") int num,
			@RequestParam(defaultValue = "0") int pnum) {
		System.out.println("여기는 댓글삭제");
		logger.info("num={}", num);
		logger.info("pnum={}", pnum);
		int n = this.reviewService.deleteReview(num);

		return "redirect:prodDetail?pnum=" + pnum;
	}
	
	@GetMapping("/reviewEdit")
	public String reviewE2(Model m, @RequestParam(defaultValue = "0") int num, 
			@RequestParam(defaultValue = "0") int pnum,
			@ModelAttribute("rvo") ReviewVO rvo) {
		System.out.println("수정폼");
		logger.info("num={}", num);
		logger.info("pnum={}", pnum);
		m.addAttribute("num", num);
		m.addAttribute("pnum", pnum);

		return "product/reviewEdit";
	}
	
	@PostMapping("/reviewEditEnd")
	public String reviewE(Model m, @ModelAttribute("rvo") ReviewVO rvo,
		@RequestParam(defaultValue = "0") int pnum) {
		System.out.println("수정완료 후");
		logger.info("rvo={}", rvo);
		reviewService.updateReview(rvo);
		return "redirect:prodDetail?pnum=" + pnum;
	}

}
