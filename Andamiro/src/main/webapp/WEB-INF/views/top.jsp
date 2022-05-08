<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="myctx" value="${pageContext.request.contextPath}" scope="session" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="${myctx}/resources/css/product_style.css" />
<link rel="stylesheet" type="text/css" href="${myctx}/resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="${myctx}/resources/css/Write.css" />
 <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="http://code.jquery.com/jquery.js"></script>


</head>


	

	<header>
		<div class="head_top">
			<div class="head_title" style="padding: 0 20% 0 5%; float: left">
				<a href="${myctx}/main"> <img src="${myctx}/images/aa.png"
					style="width: 80px; height:50px">
				</a>
			</div>


			<div class="head_find"
				style="float: left; position: relative; top: 5px">
				<input
					style="border: solid 3px rgba(101, 131, 97); width: 310px; height: 30px">
				<div style="float: right; padding: 2px">
					<label
						style="font-size: 15px; border: solid 3px rgba(101, 131, 97); background-color: rgba(101, 131, 97); color: rgba(248, 250, 228); padding: 1px">Search</label>
				</div>
			</div>

			<!-- <a>
            <img src="images/search.PNG" style="padding: 15px; width: 26%">          
        </a>
         -->



			<div class="head_join" style="float: right">
				<c:if test="${loginUser == null}">
					<a href="${myctx}/signupTerms" class="log">회원가입</a>
				</c:if>
				<c:if test="${loginUser != null}">
					<a></a>
				</c:if>
			</div>
			<div class="head_login" style="float: right">
				<c:if test="${loginUser == null}">
					<a href="${myctx}/loginPage" class="log">로그인</a>
					</li>
				</c:if>
				<c:if test="${loginUser != null}">
					<a href="${myctx}/logout" class="log" style="font-size: 20px">Logout</a>
					<a href="${myctx}/user/orderDetail2" class="log" style="font-size: 20px">${loginUser.userid}님
						로그인 중...</a>
				</c:if>
			</div>
		</div>

		<div class="line_top"></div>
		<nav id="nav">
		<c:if test="${loginUser == null }">
			<div class="ground" style="float: left; width: 25%">
				<a href="${myctx}/cropsProd">농산물</a>
			</div>
			<div class="ground" style="float: left; width: 25%">
				<a href="${myctx}/seafoodProd">수산물</a>
			</div>
			<div class="ground" style="float: left; width: 25%">
				<a href="${myctx}/livestockProd">축산물</a>
			</div>
			<c:if test="${loginUser != null }">
			<div class="ground" style="float: left; width: 20%">
				<a href="${myctx}/user/cartList">장바구니</a>
			</div>
			<c:if test="${loginUser.userid == 'admin'}">
			<div class="ground" style="float: left; width: 20%">
				<a href="${myctx}/admin/prodList">상품관리</a>
			</div>
			</c:if>
			</c:if>
			<div class="ground" style="float: left; width: 25%">
				<a href="${myctx}/user/centerList">고객센터</a>
			</div>
			</c:if>
			<c:if test="${loginUser != null }">
			<div class="ground" style="float: left; width: 20%">
				<a href="${myctx}/cropsProd">농산물</a>
			</div>
			<div class="ground" style="float: left; width: 20%">
				<a href="${myctx}/seafoodProd">수산물</a>
			</div>
			<div class="ground" style="float: left; width: 20%">
				<a href="${myctx}/livestockProd">축산물</a>
			</div>
			<c:if test="${loginUser != null }">
			<div class="ground" style="float: left; width: 20%">
				<a href="${myctx}/user/cartList">장바구니</a>
			</div>
			<div class="ground" style="float: left; width: 20%">
				<a href="${myctx}/user/mypage">정보 수정</a>
			</div>
			<c:if test="${loginUser.userid == 'admin'}">
			<div class="ground" style="float: left; width: 20%">
				<a href="${myctx}/admin/index">상품관리</a>
			</div>
			</c:if>
			</c:if>
			<div class="ground" style="float: left; width: 20%">
				<a href="${myctx}/user/centerList">고객센터</a>
			</div>
			</c:if>
		</nav>
		<div class="line_bottom"></div>
	</header>