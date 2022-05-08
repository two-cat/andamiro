<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="myctx" value="${pageContext.request.contextPath}" scope="session"/>

<c:import url="/top"/>
<main id="content-wrap">

            <div class="container">    
                <h1> 고 객 센 터</h1>

               <table class="board">
			<tr>
				<th>글 번호</th>
				<th style="width: 40%">제 목</th>
				<th>글쓴이</th>
				<th>날 짜</th>
				
			</tr>
			<c:if test="${centerArr eq null or empty centerArr}">
				<tr>
					<td colspan="4"><b>게시글이 없습니다.</b></td>
				</tr>
			</c:if>
			<c:if test="${centerArr ne null and not empty centerArr}">
				<c:forEach var="center" items="${centerArr}">
					<tr>
						<td>${center.sc_idx}</td>
						<td><a href="centerview/${center.sc_idx}">${center.sc_title}</a></td>
						<td>${center.name}</td>
						<td>${center.sc_date}</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
			<td colspan="4" class="noEnd">
				<span class="text-primary">
					총 게시글 수 : ${totalCount}개
				</span>
			</td>
			<tr>
				<td colspan="4" class="noEnd">
					<button class="btn" onclick="location.href='${myctx}/user/centerAdd'">글쓰기</button>
				</td>
			</tr>
		</table>
	</div>
            
        </main>
        <link rel="stylesheet" type="text/css" href="${myctx}/resources/css/center.css"/>
<c:import url="/foot"/>