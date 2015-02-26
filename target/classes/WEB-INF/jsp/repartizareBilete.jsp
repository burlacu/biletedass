<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Inserare Tabel</title>
    
	   <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

<script type="text/javascript">
	var contextPath = "<%=request.getContextPath() %>";
</script>
	   
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
  
<c:url var="doUpload" value="http://localhost:8080/BileteDassSpringWeb/readFile" /> 
  

  
  <p><br/></p>
    <div class="container">
    		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist" id="myTab">
  			<li class="active"><a href="#prestator" role="tab" data-toggle="tab">Repartizare bilete (Prestator)</a></li>
  			<li><a href="#raion" role="tab" data-toggle="tab">Repartizare bilete (per Raion)</a></li>
		</ul>
		<!-- Tab panes -->
		<div class="tab-content">
		<!-- Tab-ul cu prestator -->
	  			<div class="tab-pane active" id="prestator">
	  			<br/>
	  			<form:form method="post" enctype="multipart/form-data" action="readFile">
	  			<div id="uploadFile" class="col-lg-12">
					<div class="col-lg-3">
					      <label for="select" class="col-lg-6 control-label">Prestator: </label>
					        <select class="form-control" id="selectPrestator" name="prestator">
						        <c:forEach var="conditieValue" items="${prestatorList}">
									<option>${conditieValue.prestatorName}</option>
								</c:forEach>
					        </select>
					</div>
					<div class="col-lg-3">
					      <label for="select" class="col-lg-6 control-label">Specificul: </label>
					        <select class="form-control" id="selectSpecific" name="specific">
						        <c:forEach var="conditieValue" items="${specificList}">
									<option>${conditieValue.specificName}</option>
								</c:forEach>
					        </select>
					</div>
					<div class="col-lg-3">
						<label for="select" class="col-lg-6 control-label">Costul: </label>
	  					<input type="text" class="col-lg-10" id="fileName1" value="0" name="costTichet" placeholder="Text">
	  				</div>
	  				<div class="col-lg-3">
	  					<label for="select" class="col-lg-6 control-label">Fisierul: </label>
	  					<input class="col-lg-12" type="file" id="fileName" name="fileName" />
	  				</div>
	  				<br/>
	  			</div>

  				<div style="text-align: center;" id="button_Align" class="form-group col-lg-8 col-lg-offset-2">
  					<button type="submit" id="fileUpload1" name="fileButton" value="testButton" class="btn btn-primary"> Importare grafic de bilete disponibile </button>
  				</div>
  			<br/>
				</form:form>
  			</div>
  			
  			<!-- Tab-ul cu Raioane -->
  			
  			<div class="tab-pane" id="raion">
  				
  				<form role="form">
  					<div class="form-group">
    						<label for="exampleInputEmail1">Email address</label>
    						<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
  					</div>
  					<div class="form-group">
    						<label for="exampleInputPassword1">Password</label>
    						<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  					</div>
  					<div class="form-group">
    						<label for="exampleInputtxt1">Text</label>
    						<input type="text" class="form-control" id="exampleInputtxt1" placeholder="Text">
  					</div>
  					<div class="form-group">
    						<label for="exampleInputurl1">Site</label>
    						<input type="url" class="form-control" id="exampleInputurl1" placeholder="http://">
  					</div>
  					<div class="form-group">
    						<label for="exampleInputFile">File input</label>
    						<input type="file" id="exampleInputFile">
    						<p class="help-block">Example block-level help text here.</p>
  					</div>
  					<div class="checkbox">
    						<label>
      						<input type="checkbox"> Check me out
    						</label>
  					</div>
  					<button type="submit" class="btn btn-primary">Submit</button>
  					<button type="button" class="btn btn-success">Back</button>
				</form>
				<br/>
  			</div>
		</div>
    </div>
	


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    
    
    <script type="text/javascript">

$().ready(function() {

		  $('#fileUpload').click(
					function() {
						alert("1");
						alert(document.getElementById("fileName"));
						alert($("#fileName").val());
						alert($("#selectPrestator").val());
						
						$.getJSON('${doUpload}', {
							prestator : $("#prestator").val(),
							specific : $("#specific").val(),
							costTichet : $("#costTichet").val(),
							ajax : 'true'
					     }, function(response) {
		   	  alert("suc");
		      var obj = response.length;		      
		      var userInfo = "<tbody>";
			  for(var i =0 ; i < obj.length ; i++)
			  				{
				  				userInfo += "<tr>" +
				  				"<td>" + response[i].id_Tichet + "</td>"+
				  				"<td>" + response[i].fromTichet + "</td>"+
				  				"<td>" + response[i].toTichet + "</td>"+
				  				"<td>" + response[i].fromDate + "</td>"+
				  				"<td>" + response[i].toDate + "</td>"+
				  				"<td>" + response[i].costTichet + "</td>"+
				  				"<td>" + response[i].seriaTichet + "</td>"+
				  				"<td>" + response[i].durataTichet + "</td>"+
				  				"<td>" + response[i].toTichet + "</td>"+
				  				"<td>" + response[i].toTichet + "</td>"+
				  			  "</tr>";
			  				}
			  userInfo += "</tbody>";
			  alert(userInfo);
		      $('#tble').html(userInfo);
		     });
		    });
           });

</script>
    
    
    
    <script type="text/javascript">
    $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('shown.bs.tab');
    });

    // store the currently selected tab in the hash value
    $("ul.nav-tabs > li > a").on("shown.bs.tab", function (e) {
        var id = $(e.target).attr("href").substr(1);
        window.location.hash = id;
    });

    // on load of the page: switch to the currently selected tab
    var hash = window.location.hash;
    $('#myTab a[href="' + hash + '"]').tab('show');
</script>
  </body>
</html>
