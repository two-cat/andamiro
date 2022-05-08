<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/top" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<style>
a {
	color: #658361;
	text-decoration: none;
	background-color: transparent;
}
.head_find{
	padding-top:.5em;
}

label {
    cursor: default;
    padding:0;
    display:inline;
    margin-top:1.5px;
}
</style>
<main>
	<div class="content-wrap">
		<section>

			<div class="container">
				<div class="sort-title-container">
					<div class="sort-title" style="text-align: center">농산물</div>
				</div>
				<c:if test="${plist eq null or empty plist}">
					<div class="col-md-3">
						<h4>상품 준비 중</h4>
					</div>
				</c:if>
				<c:if test="${plist ne null and not empty plist}">
					<ul class="list">
						<c:forEach var="pd" items="${plist}" varStatus="state" begin="0">

							<li class="card">
							<a href="prodDetail?pnum=${pd.pnum}">
							 <c:if test="${pd.pimage1 ne null}">
										<img src="product_images/${pd.pimage1}" class="food">
									</c:if> 
									<c:if test="${pd.pimage1 eq null}">
										<img src="product_images/noimage.png"
											class="img img-responsive" style="height: 220px">
									</c:if>
									<div class="food-container">
										<div class=food1>
											<div class="food-info"></div>
											<div class="food-fomat">${pd.pspec}</div>
										</div>
										<div class="food-desc">
											<div class="food-title">${pd.pname}</div>
											<div class="food-detail">${pd.price}</div>
											<span class="">${pd.point}</span> POINT <br>
										</div>
									</div>
							</a>
							</li>
							<c:if test="${state.count mod 4 ==0}">
							</ul>
							<ul class="list">
							</c:if>
						</c:forEach>
					</ul>
				</c:if>

				<div>
			<!-- page navigation 
			begin: 시작값 지정
			end : 끝값
			step: 증가치
			-->
			${pageNavi}
			</div>
			<span class="text-primary">
			 총 농산품 수 : ${totalCount} 개 </span>


			</div>


		</section>
	</div>
</main>
<c:import url="/foot" />