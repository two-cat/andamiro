package com.ict.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ict.domain.MemberVO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {

	//���̵� : admin, ��й�ȣ : 9�� Ȯ���غ��� 
	//�Ϲ�ȸ���� Admin Ŭ���ϸ� �����ڸ� �̿밡���մϴ�. �޽����� ������ Admin���� �α����ϸ� ����
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {

		HttpSession ses = req.getSession();
		MemberVO user = (MemberVO)ses.getAttribute("loginUser");
		if(user!=null) {
			//�����ڰ� �´ٸ� true ��ȯ
			if(user.getUserid().equals("admin")) return true;
			
			else {
			String loc = req.getContextPath()+"/main";
			req.setAttribute("msg", "�����ڸ� �̿밡���մϴ�.");
			req.setAttribute("loc", loc);
			
			RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/memo/msg.jsp");
			disp.forward(req, res);
			return false;
		}
	}
	
	return false;
	
	}
}
