package com.ict.andamiro;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ict.domain.MemberVO;
import com.ict.domain.NotMemberException;
import com.ict.service.UserService;


@Controller
public class LoginController {

private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Inject
	private UserService userService;
	
	@GetMapping("/member/loginPage")
	public void loginForm() {
		
	}
	
	@PostMapping("/login")
	public String loginEnd(HttpSession session,
							Model m,
						   HttpServletResponse res,
						   @ModelAttribute("user") MemberVO user) throws NotMemberException {
		logger.info("user={}", user);
		if(user.getUserid().isEmpty()) {
			m.addAttribute("msg","아이디를 입력하세요!");
			m.addAttribute("loc","javascript:history.back()");
			return "memo/msg";
		}else if(user.getPwd().isEmpty()) {
			m.addAttribute("msg","비밀번호를 입력하세요!");
			m.addAttribute("loc","javascript:history.back()");
			return "memo/msg";
		}
		
		MemberVO loginUser = userService.loginCheck(user);
		if(loginUser!=null) {
			session.setAttribute("loginUser", loginUser);
			Cookie ck = new Cookie("uid", loginUser.getUserid());
			if(user.isSaveId()) {
				ck.setMaxAge(7*24*60*60);//7일간 유효
			}else {
				ck.setMaxAge(0);//쿠키 삭제
			}
			ck.setPath("/");
			res.addCookie(ck);
		}
		
		return "redirect:main";
		
	}//----------------------------------------
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:main";
		
	}
	
	/* user 차단 확인용
	@GetMapping("/user/mypage")
	public String showMyPage(HttpSession ses) {
		MemberVO loginUser = (MemberVO)ses.getAttribute("loginUser");		
		return "redirect:main";
	}*/
	
	@ExceptionHandler(NotMemberException.class)
	public String exceptionHandler(Exception ex) {
		return "common/errorAlert";
	}
}
