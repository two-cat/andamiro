<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="myctx" value="${pageContext.request.contextPath}" scope="session"/>
<form name="ref" action="../replyEnd" method="post">
	<!-- hidden field(작성자, 부모글번호) -->
	<input type="hidden" name="name" value="${loginUser.name}">
	<input type="hidden" name="idx" value="${loginUser.idx}">
	<input type="hidden" name="sc_idx_fk" value="${center.sc_idx}">
	<!-- ---------------------------- -->
	<table class="replyF">
		<tr>
			<td style="text-align: center"><img src="${myctx}/images/admin.png"
				class="img img-thumbnail" style="width: 80px"> <br> <span
				class="label label-warning">${loginUser.userid}</span></td>
			<td style="width:100%"><textarea name="cr_content" rows="4" style="width:100%; height:100%;"
					placeholder="로그인해야 이용 가능해요"
					<%-- <c:if test="${loginUser eq null}">disabled</c:if> --%>
					class="form-control"></textarea></td>
			<td>
				<button class="btn">작성</button>
			</td>
		</tr>
	</table>
</form> 