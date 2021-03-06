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
 *  - 컨트롤러가 실행되기 전에 사전 처리할 일이 있으면 
 *    스프링에서는 인터셉터에서 구현한다.
 *  - 구현 방법
 *  1. 인터셉터 구현
 *     [1] HandlerInterceptor인터페이스를 상속받는 방법
 *     [2] HandlerInterceptorAdapter 추상클래스를 상속받는 방법
 *      
 *  2. 인터셉터 등록 => servlet-context.xml에서 등록하고 매핑 정보를 설정
 *  <!-- Interceptor설정 ===================================== -->
   <interceptors>
         <interceptor>
            <mapping path="/user/**"/>
            <mapping path="/admin/**"/>
            <beans:bean class="com.myspring.interceptor.LoginCheckInterceptor"/>
         </interceptor>
   </interceptors>
 * */

/* [1]HandlerInterceptor인터페이스를 구현하는 방법
 * [2]HandlerInterceptorAdapter 추상클래스를 구현하는 방법
 * */
public class LoginCheckInterceptor implements HandlerInterceptor {

	Logger logger = LoggerFactory.getLogger(LoginCheckInterceptor.class);
	//컨트롤러를 실행하기 전에 호촐되는 메소드
	
	//Source -> Override method 클릭해서 생성하기(메소드 3개 다 필요없지만 쓰임 알려주려고 다 생성했다고 함)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("preHandle()");
		HttpSession ses = request.getSession();
		MemberVO user = (MemberVO)ses.getAttribute("loginUser");
		if(user!=null) return true;//true를 치환하면 Controller로 넘어감
		
		String loc = request.getContextPath()+"/main";
		request.setAttribute("msg", "로그인해야 이용가능합니다.");
		request.setAttribute("loc", loc);
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/memo/msg.jsp");
		disp.forward(request, response);
		
		//false를 반환하면 Controller로 가지 못함
		return false;
	}
	
	//컨트롤러를 실행 후 뷰를 실행하기 전에 호출되는 메소드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle()");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	//뷰를 실행한 후 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("afterCompletion()");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
