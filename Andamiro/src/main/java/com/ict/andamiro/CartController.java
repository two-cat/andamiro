package com.ict.andamiro;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ict.domain.CartVO;
import com.ict.domain.MemberVO;
import com.ict.service.ShopService;

@Controller
@RequestMapping("/user")
public class CartController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Inject
	private ShopService shopService;
	
	@PostMapping("/cartAdd")
	public String addCart(
			HttpSession session,
			@RequestParam(defaultValue="0") int pnum,
			@RequestParam(defaultValue="0") int oqty) {
		
		logger.info("pnum={},oqty={}",pnum,oqty);
		// �α����� ȸ���� ���ǿ��� ��������
		MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
		int idx_fk=loginUser.getIdx();
		
		
		CartVO cartVo = new CartVO();
		cartVo.setPnum_fk(pnum);
		cartVo.setOqty(oqty);
		cartVo.setIdx_fk(idx_fk);
		
		shopService.addCart(cartVo);
		
//		List<CartVO> cartArr= shopService.selectCartView(idx_fk); 
//		session.setAttribute("cart", cartArr);
		// ���⼭ forward�̵��ϸ� ������ ���ΰ�ħ�� ��� ��ǰ�� �߰��ȴ�.
		// �� ��� forward �̵��ϸ� �ȵ�.
		//return "shop/cartList";
					//"WEB-INF/views/shop/cartList.jsp
		return "redirect:cartList";
	}
	
	@GetMapping("/cartList")
	public String showCart(Model m, HttpSession session) {
		MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
		int idx_fk=loginUser.getIdx();
		
		
		List<CartVO> cartArr = shopService.selectCartView(idx_fk);
		System.out.println(cartArr);
		//��ٱ��� �Ѿ� ��������
		CartVO cartVO = shopService.getCartTotal(idx_fk);
		
		m.addAttribute("cart",cartArr);
		m.addAttribute("cartTotal",cartVO);
		return "shop/cartList";
	}
	
	@GetMapping("/cartDel")
	public String cartDelete(Model m,@RequestParam(defaultValue="0") int cartNum) {
		if(cartNum==0) {
			return "redirect:cartList";
		}
		int n = shopService.delCart(cartNum);
		return "redirect:cartList";
	}
	
	@PostMapping("/cartEdit")
	public String cartEdit(@ModelAttribute("cvo") CartVO cvo) {
		logger.info("cvo={}",cvo);// cartNum, oqyt�Ѿ��
		
		shopService.editCart(cvo);
		
		return "redirect:cartList";
	}
	
	/* ������ ������ �Է����� �� ���� ó��*/
	@ExceptionHandler(NumberFormatException.class)
	public String exceptionHandler(Exception ex) {
		return "common/errorAlert";
	}
	
}
