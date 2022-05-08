<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<form name="rf2" action="reviewEditEnd" method="post">
	<input type="hidden" name="idx_fk" value="${loginUser.idx}"> <input
		type="hidden" name="pnum" value="${pnum}"> <input
		type="hidden" name="num" value="${num}">
	<!-- --------------------------------------- -->
	<h2>리뷰수정</h2>
	
	<table class="table" id="review">

		<tr>
			<c:if test="${loginUser ne null}">
				<td style="text-align: center"><span name="idx_fk">${loginUser.name}</span></td>
				<td style="width: 70%"><textarea name="content" rows="2"></textarea>${content}</td>
				<td>
					<button>수정완료</button>
				</td>
			</c:if>
		</tr>
	</table>
</form>
<script>
	
</script>
