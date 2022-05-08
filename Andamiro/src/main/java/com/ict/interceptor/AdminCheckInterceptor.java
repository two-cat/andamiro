package com.ict.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ict.domain.MemberVO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {

	//아이디 : admin, 비밀번호 : 9로 확인해보자 
	//일반회원이 Admin 클릭하면 관리자만 이용가능합니다. 메시지가 나오고 Admin으로 로그인하면 들어가짐
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {

		HttpSession ses = req.getSession();
		MemberVO user = (MemberVO)ses.getAttribute("loginUser");
		if(user!=null) {
			//관리자가 맞다면 true 반환
			if(user.getUserid().equals("admin")) return true;
			
			else {
			String loc = req.getContextPath()+"/main";
			req.setAttribute("msg", "관리자만 이용가능합니다.");
			req.setAttribute("loc", loc);
			
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/memo/msg.jsp");
			disp.forward(req, res);
			return false;
		}
	}
	
	return false;
	
	}
}
