<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="/WEB-INF/views/menu.jsp"/>
<div class="col-sm-offset-1 col-sm-10">

	<legend>
		<spring:message code="table.results.title" />
	</legend>

	<div>
		<a href="results/add"><spring:message code="table.result.add" /></a>
	</div>

	<div>
		<div>
		<table id="dataTable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th><spring:message code="table.result.id" /></th>
					<th><spring:message code="table.result.userName" /></th>
					<th><spring:message code="table.result.data" /></th>
				</tr>
			<thead>
			<tbody>
				<c:forEach var="r" items="${results}">
					<tr>
						<td>${r.id}</td>
						<td>${r.user.firstName}</td>
						<td>${r.data}</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</div>