<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="myctx" value="${pageContext.request.contextPath}" scope="session"/>	
<c:import url="/top"/>
<link rel="stylesheet" type="text/css" href="${myctx}/resources/css/center.css"/>

<main id="content-wrap">
<div class="container" style="margin-top: 2rem">
	<h1 style="text-align: center">고 객 센 터</h1>
	<table class="board">
		<tr>
			<td id="change"><b>글번호</b></td>
			<td style="width: 30%">${center.sc_idx}</td>
			<td id="change">작성일</td>
			<td style="width: 30%">${center.sc_date}</td>
		</tr>
		<tr>
			<td id="change"><b>제 목</b></td>
			<td colspan="3">${center.sc_title}</td>
		</tr>
		
		<tr>
			<td id="change"><b>글쓴이</b></td>
			<td style="width: 30%" colspan="3">${center.name}</td>
		</tr>
		<tr style="height: 200px;">
			<td id="change"><b>글내용</b></td>
			<td colspan="3" style="overflow: auto">${center.sc_content}</td>
		</tr>
		<c:if test="${loginUser.userid == 'admin'}">
		<tr>
		<td colspan="4">
		<c:import url="/replyForm"/>
		</td>
		</tr>
		</c:if>
		<tr>
		<td colspan="4">
		<c:import url="/replyList"/>
		</td>
		</tr>
		<tr>
			<td colspan="4" id="self" >
				<a class="btn" href="#" onclick="goEdit()">수정</a> <!-- 창수페이지 이동 -->
				<a class="btn" href="#" onclick="goDel()">삭제</a>
			</td>
		</tr>
	</table>
</div>
	<!-- 댓글 form 끝 -->
	

 <!-- container end -->

<form name="frm" method="post">
 <input type="hidden" name="idx_fk" value="${center.idx_fk}">
 <input type="hidden" name="sc_idx" value="${center.sc_idx}">
</form>
</main>
<script>
function goDel() {
	let yn = confirm('정말 삭제할까요');
	if(!yn) return;
	
	frm.action="${pageContext.request.contextPath}/user/sc_delete";
	frm.submit();
}
function goEdit(){
	frm.action="${pageContext.request.contextPath}/user/sc_edit";
	frm.submit();
}
</script>
<c:import url="/foot"/>