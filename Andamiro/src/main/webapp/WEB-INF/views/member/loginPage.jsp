<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- Bootstrap -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script src="http://code.jquery.com/jquery.js"></script>
<!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
<script
	src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
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
<c:import url="/top" />
<main>

	<div class="container" style="padding: 10% 10% 10% 20%">
		<h1>로그인</h1>
		<br>
		<br>
		<br>

		<form name="loginF" action="${pageContext.request.contextPath}/login"
			method="post">

			<div class="form-group" id="divId">
				<label for="inputId" class="col-lg-2 control-label">아이디</label>
				<div class="col-lg-9">
					<input type="text" class="form-control onlyAlphabetAndNumber"
						name="userid" id="userid" value="${cookie.uid.value}"
						data-rule-required="true" placeholder="영어 또는 숫자로 4~20자리로 입력해주세요."
						maxlength="30">
				</div>
			</div>
			<div class="form-group" id="divPassword">
				<label for="inputPassword" class="col-lg-2 control-label">비밀번호</label>
				<div class="col-lg-9">
					<input type="password" class="form-control" name="pwd" id="pwd"
						name="excludeHangul" data-rule-required="true"
						placeholder="영문, 숫자 조합 8~20자리로 입력해주세요." maxlength="30">
				</div>
				<div style="padding: 0 0 0 3%;">
					<br> <input type="checkbox" class="checkbox" name="saveId"
						<c:if test="${cookie.uid ne null}">
        checked
        </c:if>
						id="saveId">&nbsp
					<tr>
						<label style="font-size: 11pt; padding: 0 11% 0 0">아이디 저장</label>
					</tr>

					<tr>
						<label style="font-size: 10pt">아이디 찾기 | 비밀번호 찾기 | 회원가입</label>
					</tr>

				</div>
			</div>
			<br>
			<div class="form-group">
				<label style="padding: 0 0 0 20%;"> <!--  <button type="submit" style="width: 200px"class="btn btn-success">가입하기</button> -->
					<button type="submit" class="btn text-black"
						style="width: 250px; font-weight: bold; color: rgba(248, 250, 228); background-color: rgba(101, 131, 97)">로그인</button>
				</label>
			</div>



		</form>

	</div>
</main>
	<c:import url="/foot" />