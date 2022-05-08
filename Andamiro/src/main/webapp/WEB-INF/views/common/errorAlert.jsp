<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>

<%-- isErrorPage="true" 로 주는  것에 주의하자 --%>
<%
	response.setStatus(200);
%>

<script>
	//alert('${exception.message}')
	//이클립스 내에서는 메시지가 뜨지 않고 인터넷 창 켜서 하면 알림 메시지 뜸
	alert('<%=exception.getMessage()%>')
	history.back();
</script>