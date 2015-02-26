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
<form:form action="repartizareperaion" method="POST">
<div id="users_table_container" class="form-group col-lg-8 col-lg-offset-2" style="text-align: center;">
<h2 style="text-align: center;">Biletele Inserate:</h2>
<table id="users_table" class=" table table-hover table-bordered" style="text-align: center;">
   							<thead>
    							<tr>
    								<th>Nr.</th>
    								<th>Nr. bilete de la</th>
    								<th>Nr. bilete pina la</th>
    								<th>Seria</th>
    								<th>Durata (zile)</th>
    								<th>Perioada de la</th>
    								<th>Perioada pina la</th>
    								<th>Nr. de bilete</th>
    								<th>Prestator</th>
    								<th>Cost</th>
    							</tr>
    						</thead>
    						<tbody>
    						
    						<c:forEach var="conditieValue" items="${ticheteList}">
					        	<tr>
						        	<th>	${conditieValue.id_Tichet}	</th>
									<th>	${conditieValue.fromTichet} 	</th>
						        	<th>	${conditieValue.toTichet}		</th>
									<th>	${conditieValue.seriaTichet}	</th>
									<th>	${conditieValue.durataTichet}	</th>
									<th>    <fmt:formatDate pattern="dd-MM-yyyy" type="date" value="${conditieValue.fromDate}" />						</th>
									<th>	<fmt:formatDate pattern="dd-MM-yyyy" type="date" value="${conditieValue.toDate}"/>							</th>
									<th>	${conditieValue.toTichet - conditieValue.fromTichet }		</th>
									<th>	${conditieValue.prestator.prestatorName}					</th>
									<th>    ${conditieValue.costTichet}									</th>
								</tr>
							</c:forEach>
    							
    						</tbody>
</table>
</div>
<div style="text-align: center;" class="form-group col-lg-8 col-lg-offset-2">
	<button type="submit" class="btn btn-primary">Repartizare pe raion</button>
</div>

<div style="text-align: center;" class="form-group col-lg-8 col-lg-offset-2">
<spring:url value="/" var="homepage" />
        <a href="${homepage}">
            <button type="button" class="btn btn-primary cancel">Home </button> </a>
</div>
</form:form>
</body>
</html>