<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="myctx" value="${pageContext.request.contextPath}" />
<c:import url="/top"/>
<form action="centerEditEnd">
<input type="hidden" name="sc_idx" value="${sc_idx}">
<%-- ${loginUser.mid} --%>
<div class="addContainer">
	<div class="WritingWrap">
		<div class="WritingHeader">
			<h1 class="cm_title">고객센터 글수정</h1>
			<button type="submit" name="BaseButton" id="BaseButton">수정</button>
		</div>
		<div class="WritingContent">
			<div class="ContentTop">
			</div>
			<div class="ContentTitle">
				<input type="text" id="title" name="sc_title" value="${center.sc_title}">
			</div>
			<div class="Content">
				<div class="Contentmiddle">
					<div class="font">
						<span> <select name="family"class="font-family">
								<option>글씨체</option>
						</select>
						</span> 
						<span> <select name="size" class="font-size">
								<option>글씨 크기</option>
								<option>10px</option>
								<option>20px</option>
						</select>
						</span>
					</div>
				</div>
				<div class="contentarea">
					<textarea name="sc_content"  placeholder="내용을 작성해 주세요">${center.sc_content}</textarea>
				</div>
			</div>
		</div>
	</div>
</div>
</form>


<c:import url="/foot"/>