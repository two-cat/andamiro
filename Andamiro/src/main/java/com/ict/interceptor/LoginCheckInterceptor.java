package com.ict.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ict.domain.MemberVO;
/* Interceptor
 *  - ��Ʈ�ѷ��� ����Ǳ� ���� ���� ó���� ���� ������ 
 *    ������������ ���ͼ��Ϳ��� �����Ѵ�.
 *  - ���� ���
 *  1. ���ͼ��� ����
 *     [1] HandlerInterceptor�������̽��� ��ӹ޴� ���
 *     [2] HandlerInterceptorAdapter �߻�Ŭ������ ��ӹ޴� ���
 *      
 *  2. ���ͼ��� ��� => servlet-context.xml���� ����ϰ� ���� ������ ����
 *  <!-- Interceptor���� ===================================== -->
   <interceptors>
         <interceptor>
            <mapping path="/user/**"/>
            <mapping path="/admin/**"/>
            <beans:bean class="com.myspring.interceptor.LoginCheckInterceptor"/>
         </interceptor>
   </interceptors>
 * */

/* [1]HandlerInterceptor�������̽��� �����ϴ� ���
 * [2]HandlerInterceptorAdapter �߻�Ŭ������ �����ϴ� ���
 * */
public class LoginCheckInterceptor implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	//��Ʈ�ѷ��� �����ϱ� ���� ȣ�͵Ǵ� �޼ҵ�
	
	//Source -> Override method Ŭ���ؼ� �����ϱ�(�޼ҵ� 3�� �� �ʿ������ ���� �˷��ַ��� �� �����ߴٰ� ��)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle()");
		HttpSession ses = request.getSession();
		MemberVO user = (MemberVO)ses.getAttribute("loginUser");
		if(user!=null) return true;//true�� ġȯ�ϸ� Controller�� �Ѿ
		
		String loc = request.getContextPath()+"/main";
		request.setAttribute("msg", "�α����ؾ� �̿밡���մϴ�.");
		request.setAttribute("loc", loc);
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/memo/msg.jsp");
		disp.forward(request, response);
		
		//false�� ��ȯ�ϸ� Controller�� ���� ����
		return false;
	}
	
	//��Ʈ�ѷ��� ���� �� �並 �����ϱ� ���� ȣ��Ǵ� �޼ҵ�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle()");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	//�並 ������ �� ȣ��Ǵ� �޼ҵ�
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("afterCompletion()");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
