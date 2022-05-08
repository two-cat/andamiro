package com.ict.andamiro;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ict.service.UserService;

@Controller
public class MypageController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Inject
	private UserService userService;

	@GetMapping("/mypage")
	public String mypage(Model m) {
		return "member/update";
	}
}
