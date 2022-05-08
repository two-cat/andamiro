package com.ict.andamiro;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
import com.ict.domain.OrderVO;
import com.ict.domain.ProductVO;
import com.ict.domain.ReceiverVO;
import com.ict.service.OrderService;
import com.ict.service.ShopService;
import com.ict.service.UserService;

@Controller
@RequestMapping("/user")
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Inject
	private OrderService orderService;

	@Inject
	private ShopService shopService;

	@Inject
	private UserService userService;

	@PostMapping("/order")
	public String orderForm(Model m, HttpSession ses, @RequestParam("opnum") int[] opnum,
			@RequestParam("oqty") int[] oqty) {
		logger.info("opnum[0]={}, oqty[0]={}", opnum[0], oqty[0]);
		// MemberVO loginUser = (MemberVO) ses.getAttribute("loginUser");

		// int idx = loginUser.getIdx();

		// �ֹ��� ��ǰ������ DB���� �����ͼ� ���ǿ� ��������
		List<ProductVO> orderList = new ArrayList<>();
		int totalBuy = 0, totalBuyPoint = 0;
		if (opnum != null && oqty != null) {
			for (int i = 0; i < opnum.length; i++) {
				int pnum = opnum[i];
				int pqty = oqty[i];
				ProductVO prod = shopService.selectByPnum(pnum);
				// ��ǰ��ȣ�� ��ǰ���� ��������, ����(pqty)=>�Ǹ��� ��������=>�ֹ��������� ����
				prod.setPqty(pqty);
				orderList.add(prod);// �ֹ���� �����
				totalBuy += prod.getTotalPrice();
				totalBuyPoint += prod.getTotalPoint();
			}
		}
		MemberVO loginUser = (MemberVO) ses.getAttribute("loginUser");

		MemberVO user = this.userService.findMemberByIdx(loginUser.getIdx());
		System.out.println("user=" + user);
		int mileage = 0;
		if (user != null) {
			mileage = user.getMileage();
		}
		System.out.println("mileage=" + mileage);
		ses.setAttribute("orderArr", orderList);
		ses.setAttribute("totalBuy", totalBuy); // �ֹ� �Ѿ�
		ses.setAttribute("totalBuyPoint", totalBuyPoint); // �ֹ� ������Ʈ
		ses.setAttribute("mileage", mileage); // �ֹ��� ���ϸ���
		return "/shop/orderSheet";
	}

	@PostMapping("/orderAdd")
	public String orderInsert(Model m, HttpSession ses, @ModelAttribute("ovo") OrderVO ovo,
			@ModelAttribute("receiver") ReceiverVO receiver) {
		logger.info("ovo={}", ovo);
		logger.info("receiver={}", receiver);

		// �ֹ���ǰ ����==> ���ǿ��� ������ ��
		// 1. �ֹ��� ��ǰ���� ��������
		List<ProductVO> orderList = (List<ProductVO>) ses.getAttribute("orderArr");

		// 2. �ֹ��� ��ǰ������ ������ ������ ovo�� setting=> setter�� �̿��ؼ�
		ovo.setOrderList(orderList);
		ovo.setReceiver(receiver);

		// 3. ���� ����� ���� �������°� ����
		// ������(100) => opayState = '�̰���'
		// ī�����(200) => opayState = '�����Ϸ�'
		if (ovo.getOpayWay().equals("100")) {
			ovo.setOpayState("�̰���");
		} else if (ovo.getOpayWay().equals("200")) {
			ovo.setOpayState("�����Ϸ�");
		}
		// 3_2. ��ۻ��� ==> "�̹��"
		ovo.setOdeliverState("�̹��");
		logger.info("ovo={}", ovo);

		// 4. �ֹ������� DB�� insert�Ѵ�
		String onum = this.orderService.orderInsert(ovo);

		// 5. �ֹ���ȣ=> ���ǿ� ����
		ses.setAttribute("onum", onum);

		// 6. ȸ�������� db���� �ٽ� �����ͼ� ���ǿ� ����
		// =>�ֹ��ϸ� mileage(������) ������ �����Ƿ�
		MemberVO user = this.userService.findMemberByIdx(ovo.getIdx_fk());
		if (user != null) {
			ses.setAttribute("mileage", user.getMileage());
		}

		// 7. �ֹ�ó���� �Ϸ�Ǹ� ==> ��ٱ��� ��Ͽ��� �ֹ��� ��ǰ������ �����Ѵ�.(ȸ����ȣ, ��ǰ��ȣ)

		if (orderList != null) {
			for (ProductVO prod : orderList) {
				int pnum = prod.getPnum();
				int idx_fk = ovo.getIdx_fk();
				this.shopService.delCartByOrder(idx_fk, pnum); // ��ٱ��Ͽ��� �ֹ��� ��ǰ ����
			}
		}

		// 8. �ֹ� �� ���� �������� �̵� (redirect�̵��ؾ� ��)
		// ���ΰ�ħ�� ���� �ֹ��� �߻��� �� �����Ƿ� forward�� �ƴ϶� redirect�� �̵�

		return "redirect:orderDetail?onum=" + onum;
	}

	@GetMapping("/orderDetail")
	public String orderDesc(Model m, HttpSession ses, @RequestParam(defaultValue = "") String onum) {
		if (onum.isEmpty()) {
			onum = (String) ses.getAttribute("onum");
			if (onum == null) {
				return "redirect:../main";
			}
		}
		// �ֹ���ȣ�� �� �ֹ����� ���� ��������
		List<OrderVO> orderDesc = this.orderService.getOrderDesc(onum);
		logger.info("orderDesc={}", orderDesc);

		m.addAttribute("orderDesc", orderDesc);

		return "/shop/orderDesc";
	}
	
	@GetMapping("/orderDetail2")
	public String orderDesc2(Model m, HttpSession ses) {
			MemberVO user = (MemberVO) ses.getAttribute("loginUser");
			
		// �ֹ���ȣ�� �� �ֹ����� ���� ��������
			List<OrderVO> orderDesc=this.orderService.getUserOrderList(user.getIdx());
		logger.info("orderDesc={}", orderDesc);
		
		m.addAttribute("orderDesc", orderDesc);
		
		return "/shop/orderDesc2";
	}
}
