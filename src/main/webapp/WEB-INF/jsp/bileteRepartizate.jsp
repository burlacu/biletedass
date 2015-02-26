<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Repartizare Tichete</title>

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<script type="text/javascript">
	var contextPath = "<%=request.getContextPath() %>";
</script>  
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<form:form action="mainPage" method="POST">
<div id="users_table_container" class="form-group col-lg-8 col-lg-offset-2" style="text-align: center;">
<h2 style="text-align: center;">Biletele Inserate:</h2>
<table id="users_table" class=" table table-hover table-bordered" style="text-align: center;">
   							<thead>
    							<tr>
    								<th>Nr.				</th>
    								<th>Raionul :       </th>
    								<th>Durata (zile)   </th>
    								<th>Nr. bilete :    </th>
    								<th>Perioada de la  </th>
    								<th>Perioada pina la</th>
    								<th>Prestator : </th>
    								<th>Specific :  </th>
    							</tr>
    						</thead>
    						<tbody>
    						
    						<c:forEach var="conditieValue" items="${repartizareList}">
					        	<tr>
						        	<th>	${conditieValue.id_Repartizare}	</th>
									<th>	${conditieValue.raionId.raionName} 	</th>
						        	<th>	${conditieValue.tichet.durataTichet}		</th>
									<th>	${conditieValue.totalTichet}	</th>
									<th>    <fmt:formatDate pattern="dd-MM-yyyy" type="date" value="${conditieValue.tichet.fromDate}" />						</th>
									<th>	<fmt:formatDate pattern="dd-MM-yyyy" type="date" value="${conditieValue.tichet.toDate}"/>							</th>
									<th>	${conditieValue.tichet.getSpecific().specificName}							</th>
									<th>    ${conditieValue.tichet.prestator.prestatorName}									</th>
								</tr>
							</c:forEach>
    							
    						</tbody>
</table>
</div>

<div style="text-align: center;" class="form-group col-lg-8 col-lg-offset-2">
<spring:url value="mainPage" var="homepage" />
        <a href="${homepage}">
            <button type="submit" class="btn btn-primary cancel"> Home </button> </a>
</div>
</form:form>
</body>
</html>