<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

 <title>Bilete DASS</title>
 
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">


	   
</head>
<body>
<h1 style="text-align: center; ">Bilete D.A.S.S.</h1>

<div style="text-align: center; ">
	<form:form action="choose" method="POST" commandName="main">
		<div style="text-align: center;"> 
			<h2><label> Meniul Principal:</label> </h2>
			<br/>
			<input type="submit" name="action" id="action" value="Inregistrarea Cererilor" />
			<input type="submit" name="action" id="action" value="Repartizarea Biletelor DASS" /> 
			<input type="submit" name="action" id="action" value="Repartizarea Biletelor MMPSF" />
			<input type="submit" name="action" id="action" value="Registru de Bilete" /> 
			<input type="submit" name="action" id="action" value="Feed-Back Prestator" /> 
		</div>
	</form:form>
	</div>   

<script type="text/javascript">	var contextPath = "<%=request.getContextPath() %>"; </script>	   

    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>

</body>
</html>
