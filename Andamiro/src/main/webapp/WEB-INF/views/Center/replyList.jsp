<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="replyV table-hover" style="width:100%">
	<tr class="info">
		<th colspan = "2"><h3 style="text-align: center">:: Reply List ::</h3></th>
	</tr>
	
	<c:forEach var="crply" items="${crArr}">
	<tr>

		<td style="width:95%">
			${crply.cr_content}
			<div style="text-align:right">
			<br>
			<span class="writer">김명진</span>
			</div>
			
		</td>
		<td style="width:5%">
		<%-- <c:if test = "${loginUser.userid eq reply.re_name}"> --%>
			<div id="event" >
				<button class="btn del" 
				onclick ="reDel('${crply.cr_idx}')">삭 제</button>
			</div>
			<%-- </c:if> --%>
		</td>
	</tr>
	</c:forEach>
</table>
<!-- 수정 삭제 form -->
<form name="reDelF">
	<input type="hidden" name ="cr_idx">
	<input type="hidden" name ="sc_idx" value="${center.sc_idx}">
</form>
<!-- ------------ -->
<script>
	
	function reDel(cr_idx) {
		/* alert(num); */
		let yn = confirm("삭제하시겠습니까?");
		if(!yn) return;
		reDelF.cr_idx.value=cr_idx;
		reDelF.action="../replyDel";
		reDelF.method="post";
		reDelF.submit();
	}
</script>