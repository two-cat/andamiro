package com.ict.andamiro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main")
	public void main() {

	}

	@RequestMapping("/top")
	public void showTop() {

	}

	@RequestMapping("/foot")
	public void showFoot() {

	}

	@RequestMapping("/replyForm")
	public String showForm() {

		return "Center/replyForm";
	}

	@RequestMapping("/replyList")
	public String showList() {
		return "Center/replyList";
	}

	@RequestMapping("/prodCaro")
	public void showFoot2() {
		
	}
}
