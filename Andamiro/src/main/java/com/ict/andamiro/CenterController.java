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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ict.domain.CenterReplyVO;
import com.ict.domain.CenterVO;
import com.ict.domain.MemberVO;
import com.ict.mapper.CenterReplyMapper;
import com.ict.service.CenterService;

@Controller
@RequestMapping("/user")
public class CenterController {

	private static Logger logger = LoggerFactory.getLogger(CenterController.class);

	@Inject
	private CenterService centerService;

	@Inject
	private CenterReplyMapper crService;

	@GetMapping("/centerList")
	public String showCenter(Model m, HttpSession session) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		int idx_fk = loginUser.getIdx();

		List<CenterVO> centerArr = centerService.listCenter();

		int totalCount = centerService.getTotalCount();

		m.addAttribute("centerArr", centerArr);
		m.addAttribute("totalCount", totalCount);

		return "Center/centerList";
	}

	@GetMapping("/centerAdd")
	public String writeForm(Model m, HttpSession session) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		int idx_fk = loginUser.getIdx();

		CenterVO center = new CenterVO();
		center.setIdx_fk(idx_fk);

//		centerService.insertCenter(center);

		return "Center/centerAdd";
	}

	@RequestMapping("/centerWriteEnd")
	public String centerWrite(Model m, HttpSession session, @ModelAttribute("center") CenterVO center) {
		
		
		
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		int idx_fk = loginUser.getIdx();

		center.setIdx_fk(idx_fk);
		int n = centerService.insertCenter(center);
		String str = (n > 0) ? "등록 성공" : "등록 실패";
		String loc = (n > 0) ? "centerList" : "javascript:history.back()";

		m.addAttribute("msg", str);
		m.addAttribute("loc", loc);
		return "memo/msg";
	}

	@RequestMapping("/centerview/{sc_idx}")
	public String showCenterView(Model m, HttpSession ses, @PathVariable(name = "sc_idx") int sc_idx) {

		MemberVO loginUser = (MemberVO) ses.getAttribute("loginUser");
		CenterVO center = centerService.selectCenterByIdx(sc_idx);
		
		List<CenterReplyVO> crArr = crService.listReply(sc_idx);
		logger.info("crArr={}", crArr);
		m.addAttribute("crArr", crArr);
		m.addAttribute("center", center);

		return "/Center/centerview";
	}

	/*
	 * @RequestMapping("/centerview") public String CenterView(Model m, HttpSession
	 * ses, @ModelAttribute("center") CenterVO center,
	 * 
	 * @ModelAttribute("crvo") CenterReplyVO crvo, @RequestParam("sc_idx") String
	 * idx) {
	 * 
	 * int sc_idx = Integer.parseInt(idx); center.setSc_idx(sc_idx); center =
	 * centerService.selectCenterByIdx(sc_idx);
	 * 
	 * crvo.setSc_idx_fk(sc_idx); List<CenterReplyVO> crArr =
	 * crService.listReply(sc_idx); logger.info("crArr", crArr);
	 * m.addAttribute("crArr", crArr); m.addAttribute("center", center);
	 * 
	 * return "Center/centerview"; }
	 */

	@PostMapping("/sc_delete")
	public String centerDelete(Model m, HttpSession ses, @RequestParam(defaultValue = "") String idx_fk,
			@RequestParam(defaultValue = "") String sc_idx) {
		int sc_idx_int = Integer.parseInt(sc_idx);
		MemberVO user = (MemberVO) ses.getAttribute("loginUser");
		CenterVO center =centerService.selectCenterByIdx(sc_idx_int);
		logger.info("center={}",center);
		if (center.getName().equals(user.getName())) {
			

			int n = centerService.deleteCetner(sc_idx_int);
			String str = (n > 0) ? "삭제 성공" : "삭제 실패";
			String loc = "centerList";

			m.addAttribute("msg", str);
			m.addAttribute("loc", loc);

			return "memo/msg";
		} else {
			m.addAttribute("msg", "작성자만 삭제 가능합니다.");
			m.addAttribute("loc", "javascript:history.back()");

			return "memo/msg";
		}
	}

	@PostMapping("/sc_edit")
	public String centerEditForm(Model m, @ModelAttribute("center") CenterVO center, @RequestParam() int sc_idx) {

		center = centerService.selectCenterByIdx(sc_idx);

		m.addAttribute("center", center);
		m.addAttribute("sc_idx", sc_idx);
		return "Center/centerEditForm";
	}

	@RequestMapping("/centerEditEnd")
	public String centerEditEnd(Model m, @ModelAttribute("center") CenterVO center,
			@RequestParam(defaultValue = "") String idx_fk, @RequestParam(defaultValue = "") String sc_idx) {
		
		MemberVO user = new MemberVO();
		
			int n = centerService.updateCener(center);
			String str = (n > 0) ? "수정 성공" : "수정 실패";
			String loc = (n > 0) ? "centerList" : "javascript:history.back()";

			m.addAttribute("msg", str);
			m.addAttribute("loc", loc);
			return "memo/msg";
	
	}

	@PostMapping("/replyEnd")
	public String replyEditEnd(Model m, @ModelAttribute("crvo") CenterReplyVO crvo,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String idx,
			@RequestParam(defaultValue = "") String sc_idx_fk) {

		int n = crService.insertReply(crvo);

		return "redirect:centerview/" + sc_idx_fk;
	}

	@PostMapping("/replyDel")
	public String replyDel(Model m, @RequestParam(defaultValue = "") String sc_idx,
			@RequestParam(defaultValue = "") String cr_idx) {
		int cr_idx_int = Integer.parseInt(cr_idx);

		int n = crService.deleteReply(cr_idx_int);
		String str = (n > 0) ? "삭제 성공" : "삭제 실패";
		String loc = "redirect:centerview/" + sc_idx;

		// m.addAttribute("msg", str);
		// .addAttribute("loc", loc);
		return loc;
	}
}
