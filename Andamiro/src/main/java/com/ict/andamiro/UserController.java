package com.ict.andamiro;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ict.domain.MemberVO;
import com.ict.service.UserService;

@Controller
public class UserController {

	@Inject
	private UserService userService;
	
	@GetMapping("/user/mypage")
	public String showMyPage(HttpSession ses, @ModelAttribute("user") MemberVO user) {
		MemberVO loginUser = (MemberVO)ses.getAttribute("loginUser");		
		return "member/memberEdit";
	}
	
	@PostMapping("/user/mypage")
	public String showMyPageUpdate(Model m, HttpSession ses ,
			@ModelAttribute("user") MemberVO user) {
		
		MemberVO loginUser = (MemberVO)ses.getAttribute("loginUser");	
		int n = userService.editMember(user);
		
		String str = (n>0) ? "회원정보 수정 완료 ":"회원정보 수정 실패";
		String loc = (n>0) ? "../main":"javascript:history.back()";
			
		m.addAttribute("msg", str);
		m.addAttribute("loc", loc);

		return "memo/msg";
	}
	
	/*GetMapping("/user/main")
	public String showMyPageEnd() {
		return "main";
	}*/

}
