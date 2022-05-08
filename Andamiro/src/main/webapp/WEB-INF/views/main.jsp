<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/top"/>
<main>
 <div class="content-wrap">
   <c:import url="/cropsMain">
		<c:param name="pspec" value="농산물"/>
	</c:import>
	<c:import url="/seafoodMain">
		<c:param name="pspec" value="수산물"/>
	</c:import>
	<c:import url="/livestockMain">
		<c:param name="pspec" value="축산물"/>
	</c:import>
 </div>
</main>
<c:import url="/foot"/>