<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
 <title>Bilete DASS</title>
 
 		<script type="text/javascript">
			var contextPath = "<%=request.getContextPath() %>";
		</script>
 
	   <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	   <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
	   
 <!-- Load jQuery and bootstrap datepicker scripts -->
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

		
	   		   
</head>

<body>

<!--<c:url var="findProductForCat" value="/products_ajax.do" /> -->
<c:url var="findLocation" value="/asa" />
<c:url var="findSubcondition" value="/subconditie" />
<c:url var="findSubconditionInsotitor" value="/subconditieinsotitor" />    



<form:form class="form-horizontal col-lg-7 col-lg-offset-3"  action="saveCerere" method="POST" enctype="multipart/form-data" >
  <fieldset>
  
    <legend>Date Solicitant: </legend>
    <!-- IDNP -->
	<div class="form-group col-md-5">
      <label for="inputIdnp" class="col-lg-2 control-label">IDNP: </label>
      <div class="col-lg-4">
        <input type="text" class="form-control" id="inputIdnp" name="inputIdnp" placeholder="Idnp"/>
      </div>
    </div>
    <!-- Date personale -->
    <div class="form-group col-md-12">
	   	<div class="form-group col-md-4">
			      <label for="inputName" class="col-lg-2 control-label">Nume: </label>
			      <div class="col-lg-10">
			        <input type="text" class="form-control" id="inputNameSolicitant" name="inputNameSolicitant" placeholder="Nume solicitant"  />
			       </div>
			       
			      <label for="inputPreName" class="col-lg-2 control-label">Prenume: </label>
			      <div class="col-lg-10">
			        <input type="text" class="form-control" id="inputPreNameSolicitant" name="inputPreNameSolicitant" placeholder="Prenume solicitant" >
			      </div>
	    </div>
	    <div class="form-group col-md-4">
	    		<div class="form-group">
			       	  <label for="select" class="col-lg-3 control-label">Raionul: </label>
				      <div class="col-lg-9">
				        <select class="form-control" id="selectRaion" name = "selectRaion">
					        <option>Alege Raionul</option>
					        <c:forEach var="conditieValue" items="${raionList}">
								<option>${conditieValue.raionName}</option>
							</c:forEach>
				        </select>
				      </div>
			       	  <label for="select" class="col-lg-3 control-label">Localitate:</label>
				      <div class="col-lg-9">
				        <select class="form-control" id="selectLocalitate" name="selectLocalitate">

				        </select>
				      </div>
	    		</div>
   		</div>
   		<div class="form-group col-md-4">
	    		<div class="form-group">
			       	  <label for="select" class="col-lg-3 control-label">Conditie: </label>
				      <div class="col-lg-9">
				        <select class="form-control" id="selectConditie">
					       <option>Alege Conditia</option>
					        <c:forEach var="conditieValue" items="${conditieList}">
					        	
								<option>${conditieValue.conditionName}</option>
							</c:forEach>
				        </select>
				      </div>
			       	  <label for="select" class="col-lg-3 control-label">Subconditie: </label>
				      <div class="col-lg-9">
				        <select class="form-control" id="selectSubconditie" name="selectSubconditie">

				        </select>
				      </div>
	    		</div>
   		</div>
    </div>
    <!-- categorii -->
   	
	<!-- Angajat In Cimpul Muncii -->
	<div class="form-group col-md-5">
		<div> <label> Angajat în cîmpul muncii: </label> 
		<input type="checkbox" id="isAngajat" name="isAngajat" value="true"  onclick="OnChangeCheckbox (this)" checked='checked'/>
		</div>
	</div>   
  </fieldset>
  
  <fieldset type="fieldset"  hidden="true" name="fieldInsotitor" id="idFieldInsotitor">
    <legend>Date Însoţitor: </legend>
	<div class="form-group col-md-5">
      <label for="inputIdnp" class="col-lg-2 control-label">IDNP: </label>
      <div class="col-lg-4">
        <input type="text" class="form-control" id="inputIdnpInsotitor" name="inputIdnpInsotitor" placeholder="Idnp">
      </div>
    </div>
    <div class="form-group col-md-12">
	    <div class="form-group col-md-4">
			      <label for="inputName" class="col-lg-2 control-label">Nume: </label>
			      <div class="col-lg-10">
			        <input type="text" class="form-control" id="inputNameInsotitor" name="inputNameInsotitor" placeholder="Nume solicitant">
			       </div>
			       
			      <label for="inputPreName" class="col-lg-2 control-label">Prenume: </label>
			      <div class="col-lg-10">
			        <input type="text" class="form-control" id="inputPreNameInsotitor" name="inputPreNameInsotitor" placeholder="Prenume solicitant">
			      </div>
	    </div>
	    <div class="form-group col-md-4">
	    		<div class="form-group">
			       	  <label for="select" class="col-lg-3 control-label">Raionul: </label>
				      <div class="col-lg-9">
				        <select class="form-control" id="selectRaionInsotitor" name="selectRaionInsotitor">
				        <option>Alege Raionul</option>
					        <c:forEach var="conditieValue" items="${raionList}">
								<option>${conditieValue.raionName}</option>
							</c:forEach>
				        </select>
				      </div>
			       	  <label for="select" class="col-lg-3 control-label">Localitate: </label>
				      <div class="col-lg-9">
				        <select class="form-control" id="selectLocalitateInsotitor" name="selectLocalitateInsotitor">
				        </select>
				      </div>
	    		</div>
   		</div>
   		<div class="form-group col-md-4">
	    		<div class="form-group">
			       	  <label for="select" class="col-lg-3 control-label">Conditie: </label>
				      <div class="col-lg-9">
				        <select class="form-control" id="selectConditieInsotitor">
					       <option>Alege Conditia</option>
					        <c:forEach var="conditieValue" items="${conditieInsotitorList}">
					        	
								<option>${conditieValue.conditionName}</option>
							</c:forEach>
				        </select>
				      </div>
			       	  <label for="select" class="col-lg-3 control-label">Subconditie: </label>
				      <div class="col-lg-9">
				        <select class="form-control" id="selectSubconditieInsotitor" name="selectSubconditieInsotitor">

				        </select>
				      </div>
	    		</div>
   		</div>
    </div>
    <!-- categorii -->
   
	<div class="form-group col-md-5">
		<div> <label> Angajat în cîmpul muncii: </label> 
		<input type="checkbox" id="isAngajatInsotitor" name="isAngajatInsotitor" value="true"  onclick="OnChangeCheckbox (this)" checked='checked'/>
		</div>
	</div>   
  </fieldset>
  
  	<div class="form-group col-md-9">
		<label for="select" class="col-lg-3 control-label">Specific : </label>
		<div class="form-group col-lg-9">
		     <select class="form-control" id="selectSpecific" name="selectSpecific">
		     
		     <c:forEach var="conditieValue" items="${specificList}">
								<option>${conditieValue.specificName}</option>
							</c:forEach>
		     </select>
		 </div>
		 
		 <label for="select" class="col-lg-3 control-label">Urgenta:</label>
		 <div class="form-group col-lg-9">
		     <select class="form-control" id="selectUrgenta" name="selectUrgenta">
								<option> - </option>
								<option>Atac de cord</option>
								<option>Ictus</option>
		     </select>
		 </div>
		 
		 <div class="form-group col-lg-18">
		 	<table class="table table-hover" id="tble">
    						<thead>
    							<tr>
    								<th>_</th>
    								<th> Copia actului de identitate </th>
    								<th><input type="file" name="file"></th>
    							</tr>
    						</thead>
    						<tbody>
    							<tr>
    								<th>_</th>
    								<th> Cererea: </th>
    								<th><input type="file" name="file"></th>
    							</tr>
    							<tr>
    								<th>_</th>
    								<th> Legitimatia de pensionar: </th>
    								<th><input type="file" name="file"></th>
    							</tr>
    							<tr>
    								<th>_</th>
    								<th> Concluzia consiliului de expretiza medicala a vitalitatii: </th>
    								<th><input type="file" name="file"></th>
    							</tr>
    							<tr>
    								<th>_</th>
    								<th> Certificatul medical 070E: </th>
    								<th><input type="file" name="file"></th>
    							</tr>
    							<tr>
    								<th>_</th>
    								<th> Recomandartea centrului de reabilitare/recuperare: </th>
    								<th><input type="file" name="file"></th>
    							</tr>
    							    							<tr>
    								<th>_</th>
    								<th> Copii din paginile principale din carnetul de munca: </th>
    								<th><input type="file" name="file"></th>
    							</tr>
    							    							<tr>
    								<th>_</th>
    								<th> Copia pasaportului RM: </th>
    								<th><input type="file" name="file"></th>
    							</tr>
    							<tr id="copiaInsotitor" hidden="true">
    								<th>_</th>
    								<th> Copia actului de identitate (Insotitor): </th>
    								<th><input type="file" name="file"></th>
    							</tr>
    						</tbody>
  					</table>
		 </div>
		 
		 
		 <div class="bfh-datepicker col-lg-12" data-min="01/15/2013" data-max="today" data-close="false">
		 		<label for="select" class="col-lg-3 control-label">Data : </label>
                <input class="datepicker col-lg-3" data-date-format="yyyy/mm/dd" name="inregistrareaCererii">
		 </div>
		 
		 <div class="form-group col-lg-9">
			<input type="submit" name="cerereNoua" id="cerere" value="Insereaza cerere" />
		 </div>
	</div>
	
</form:form>
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">  
$('.datepicker').datepicker()
.on('changeDate', function(ev){   
    $('.datepicker').datepicker('hide');
});
</script>

<script type="text/javascript">
 
function OnChangeCheckbox (checkbox) {
    if (checkbox.checked) {
        alert ("The check box is checked.");
        $(checkbox).attr('value', 'true');
        alert($(checkbox).val());
    }
    else {
        alert ("The check box is not checked.");
        $(checkbox).attr('value', 'false');
        alert($(checkbox).val());
    }
}
 
 $().ready(
		 function() {

		  $('#selectRaion').change(
		    function() {
		     $.getJSON('${findLocation}', {
		    	 conditionName : $(this).val(),
		      ajax : 'true'
		     }, function(data) {
		      var html = '<option value="">Alege localitatea</option>';
		      var len = data.length;
		      
		      
		      for ( var i = 0; i < len; i++) {
		       html += '<option value="' + data[i].id_Localitate + '">'
		         + data[i].localitateName + '</option>';
		      }
		      $('#selectLocalitate').html(html);
		     });
		    });

		});
 
 $().ready(
		 function() {

		  $('#selectRaionInsotitor').change(
		    function() {
		     $.getJSON('${findLocation}', {
		    	 conditionName : $(this).val(),
		      ajax : 'true'
		     }, function(data) {
		      var html = '<option value="">Alege localitatea</option>';
		      var len = data.length;
		      
		      
		      for ( var i = 0; i < len; i++) {
		       html += '<option value="' + data[i].id_Localitate + '">'
		         + data[i].localitateName + '</option>';
		      }
		      $('#selectLocalitateInsotitor').html(html);
		     });
		    });

		});
 
 $().ready(
		 function() {

		  $('#selectConditie').change(
		    function() {
		     $.getJSON('${findSubcondition}', {
		    	 conditionName : $(this).val(),
		      ajax : 'true'
		     }, function(data) {
		      var html = '<option value="">Alege subconditia</option>';
		      var len = data.length;
		      
		      
		      for ( var i = 0; i < len; i++) {
		       html += '<option value="' + data[i].id_SubContition + '">'
		         + data[i].subConditionName + '</option>';
		      }
		      $('#selectSubconditie').html(html);
		     });
		    });

		});
 
 $().ready(
		 function() {

		  $('#selectSubconditie').change(
		    function() {
		    	var valoare = $(this).val();
		    	alert(valoare);
		    	if(valoare == 4)
		    		{
		    		$("#idFieldInsotitor").attr('hidden', false);
		    		$("#copiaInsotitor").attr('hidden', false);
		    		}
		    	else
		    		{
		    		$("#idFieldInsotitor").attr('hidden', true);
		    		$("#copiaInsotitor").attr('hidden', true);
		    		}

		      });
		    });
 
 $().ready(
		 function() {

		  $('#selectConditieInsotitor').change(
		    function() {
		     $.getJSON('${findSubconditionInsotitor}', {
		    	 conditionName : $(this).val(),
		      ajax : 'true'
		     }, function(data) {
		      var html = '<option value="">Alege subconditia</option>';
		      var len = data.length;
		      
		      alert (data[i]);
		      
		      
		      for ( var i = 0; i < len; i++) {
		       html += '<option value="' + data[i].id_SubContition + '">'
		         + data[i].subConditionName + '</option>';
		      }
		      $('#selectSubconditieInsotitor').html(html);
		     });
		    });

		});

</script>

</body>
</html>