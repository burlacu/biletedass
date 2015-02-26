/**
 * 
 */
function doAjaxPost() {  
	  // get the form values  
	  var selectRaion = $('#selectRaion').val();
	  alert(selectRaion);
	  alert(contextPath);
	   
	  $.ajax({  
	    type: "POST",  
	    url: contextPath + "/asa1",  
	    data: "conditionName=" + selectRaion,  	    
	    success: function(response){
	      // we have the response 
	    	alert("res: "+response.result);
	    	localInfo="";
	      if(response.status == "SUCCESS"){
	    	  alert("res1: "+response.result);
	    	  
	    	  for(var i =0 ; i < response.result.length ; i++){
	    		  localInfo += "<option>" + response.result[i].subConditionName + "</option>";
	    	  }
	    	  $('#selectLocalitate').html(localInfo);
		      $('#selectLocalitate').show('slow');
	      }else{
	    	  alert("no"+response.result);
	    	  localInfo += "<option>nimic</option>";
	    	  for(var i =0 ; i < response.result.length ; i++){
	    		  localInfo += "<option>" + response.result[i].subConditionName + "</option>";
	    	  }
	    	  $('#selectLocalitate').html(localInfo);
	    	  $('#selectLocalitate').show('slow');
	      }	      
	    },  
	    error: function(e){  
	    	alert('path: '+contexPath);
	    	alert('Error: ' + e);  
	    }  
	  });
	}  