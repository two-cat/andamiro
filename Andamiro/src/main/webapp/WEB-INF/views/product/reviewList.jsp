<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table table-hover table-striped">
	<tr class="info">

	</tr>
	<c:forEach var="review" items="${reviewArr}">
		<tr>
			<td>${review.content}<br> <span class="pull-right">${review.name}
					[${review.wdate}]</span> <br> 
					
					<div>
					<div class="pull-left"style="color:blue">회원평점 &nbsp ${review.score}점</div>
					<div class="pull-right">
					<c:if
					test="${loginUser.idx eq review.idx_fk}">
						<button class="btn btn-info"
							onclick="reEdit('${review.num}','${item.pnum}')">수정</button>
						<button class="btn btn-danger" onclick="reDel('${review.num}')">삭제</button>
				</c:if>
					</div>
					</div>
			</td>
		</tr>
	</c:forEach>
</table>
<form name="reDelF">
	<input type="hidden" name="num"> <input type="hidden"
		name="pnum" value="${item.pnum}">
</form>
<form name="editF">
	<input type="hidden" name="num"> <input type="hidden"
		name="pnum" value="${item.pnum}">
</form>
<!-- ------------------------------ -->
<script>
	function reDel(num) {
		let yn = confirm("댓글을 정말 삭제할까요?");
		if (yn) {
			location.href = "reviewDel";
		}
		reDelF.num.value = num;
		reDelF.action = "reviewDel";
		reDelF.method = "GET";
		reDelF.submit();
	}
	function reEdit(num, pnum, content) {
		editF.num.value = num;
		editF.pnum.value = pnum;
		editF.action = "reviewEdit";
		editF.method = "GET";
		editF.submit();
	}
</script>