<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<form:form action="${pageContext.request.contextPath}/results/add" method="POST" modelAttribute="result">
		<p><spring:message code="table.result.add.data" /></p>
		<p><form:textarea path="data" rows="3" cols="20" /><p>
		<input type="submit" value='<spring:message code="table.result.add.submit" />'/>
	</form:form>
</body>
</html>