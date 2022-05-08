<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
</head>
<c:import url="/top" />
<!-- 이미지 확대 jquery plugin ----------------------------------------------- -->
<script type="text/javascript" src="resources/js/jquery.magnifier.js"></script>
<!------------------------------------------------------------------------  -->
<script>
	var openPop = function(img) {
		let url = "product_images/" + img;
		let obj = new Image();
		obj.src = url;

		let w = obj.width + 30;
		let h = obj.height + 30;

		window.open(url, 'imgView',
				`width=${w}px, height=${h}px, top=100, left=100`)

	}
</script>

<div class="content-wrap">
<div class="container" style="text-align: center">

	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th colspan="2"><h3 style="text-align: center">상품 정보</h3></th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td align="center" width="50%"><c:import url="/prodCaro" /></td>

						<td align="left" width="50%" style="padding-left: 40px">
							<h4>
								<span class="label label-danger">${item.pspec} </span>
							</h4> 상품번호: ${item.pnum} <br> 상품이름: ${item.pname} <br> 정가:<del>
								<fmt:formatNumber value="${item.price}" pattern="###,###" />
							</del>원<br> 판매가:<span style="color: red; font-weight: bold">
								<fmt:formatNumber value="${item.saleprice}" pattern="###,###" />
						</span>원<br> 할인율:<span style="color: red">${item.percent} %</span><br>

							POINT:<b style="color: green">[${item.point}]</b>POINT<br> <!-- form시작---------- -->
							<form name="frm" id="frm" method="POST">
								<!-- 상품번호를 hidden으로 넘기자------ -->
								<input type="hidden" name="pnum" value="${item.pnum}">
								<input type="hidden" name="opnum" value="${item.pnum}">
								<!-- -------------------------------- -->
								<label for="oqty">상품갯수</label> <input type="number" name="oqty"
									id="oqty" min="1" max="50" size="2" value="1">

							</form> <!-- form end------------ -->
							<div>
								<button type="button" onclick="goCart()" class="btn btn-success"
									style="width: 49%">장바구니</button>
								<!-- <button type="button" onclick="goWish()" class="btn btn-danger"
									style="width: 150px">위시리시트</button> -->
								<button type="button" onclick="goOrder()"
									class="btn btn-warning" style="width: 49%">주문하기</button>
							</div>
						</td>

					</tr>
					<tr style="text-align: center;" >
						<td style=" border: 1px solid">상품상세</td>
						<td style=" border: 1px solid">리뷰</td>
					</tr>
					<tr>
						<td colspan="2">
	<pre>${item.pcontents}</pre>
						</td>
					</tr>
				</tbody>
<c:import url="/reviewForm"/>
<c:import url="/reviewList"/>
			</table>
		</div>
	</div>
</div>
</div>
<script>
	goCart = function() {
		 frm.action = "user/cartAdd";
		//pnum,oqty 데이터가 넘어감
		//frm.method='get';
		frm.submit()
	}
	goOrder = function() {
		frm.action = "user/order";
		frm.submit();
	}
</script>

<c:import url="/foot" />



