package com.ict.andamiro;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ict.domain.MemberVO;
import com.ict.service.UserService;

@Controller
public class SignupController {

	@Inject
	private UserService userService;
	
	private static Logger logger = LoggerFactory.getLogger(SignupController.class);
	
	@GetMapping("/signupTerms")
	public String SignupTerms(Model m) {
		m.addAttribute("signupTerms", "�ȴٹ̷� ȸ������");
		return "member/signupTerms";
	}
	
	//ȭ�� �����ֱ�
	@GetMapping("/signup")
	public String SignupForm() {
		return "member/signup";
	}
	
	//���� ����ֱ�
	@PostMapping("/signup")
	public String SignupForm(Model m, @ModelAttribute("user") MemberVO user) {
		
		// ��ȿ�� üũ
		if(user.getName() == null || user.getUserid() == null || user.getPwd() == null ||
				user.getName().trim().isEmpty() || user.getUserid() .trim().isEmpty() ||  user.getPwd().trim().isEmpty()) {
			return "redirect:signup";
		}
		
		logger.info("user={}",user);
			
		int n = userService.insertMember(user);
		
		String str = (n>0) ? "�ȴٹ̷��� ȸ���� �ǽ� ���� ȯ���մϴ�! :) ":"ȸ������ ����";
		String loc = (n>0) ? "loginPage":"javascript:histotry.back()";
		
		m.addAttribute("msg", str);
		m.addAttribute("loc", loc);
				
		return "memo/msg";
		
		//return "member/loginPage";
	}
	
	//������ ȸ������ �� �α��� ȭ������ ���ư���.
	@GetMapping("/loginPage")
	public String loginForm() {
		return "member/loginPage";
	}

	
	////////////////////////////////////////////////////////
	
	
	@GetMapping("/idCheck")
	public String GetidCheck(Model m,
			@RequestParam(value="userid", defaultValue = "") String userid) {
		m.addAttribute("userid", userid);
		m.addAttribute("mode", "get");
		
		return "member/idCheck";

	}
	
	@PostMapping("/idCheck")
	public String PostidCheck(Model m,@RequestParam("userid") String userid) {
		if(userid == null || userid.trim().isEmpty()) {
			m.addAttribute("msg", "���̵� �Է����ּ���.");
			m.addAttribute("loc", "javascript:history.back()");
			return "memo/msg";
		}
		
		boolean isUse = userService.idCheck(userid);
		
		String result = (isUse) ? "ok" : "fail";
		
		m.addAttribute("result", result);
		m.addAttribute("userid", userid);
		m.addAttribute("mode", "post");
		
		return "member/idCheck";
	}
	
}
