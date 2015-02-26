function madeAjaxCall(){
 $.ajax({
  type: "GET",
  url: "/readFile",
  cache: false,    
  data:'',
  success: function(response){
   $('#tabel_init').html("<tbody></tbody>");
//   var obj = JSON.parse(response);
   
   userInfo = "<tbody>";
	  for(i =0 ; i < response.result.length ; i++){
		  userInfo += "<tr>" +
		  				"<td>" + response.result[i].id_Tichet + "</td>"+
		  				"<td>" + response.result[i].fromTichet + "</td>"+
		  				"<td>" + response.result[i].toTichet + "</td>"+
		  				"<td>" + response.result[i].toTichet + "</td>"+
		  				"<td>" + response.result[i].toTichet + "</td>"+
		  				"<td>" + response.result[i].toTichet + "</td>"+
		  				"<td>" + response.result[i].toTichet + "</td>"+
		  				"<td>" + response.result[i].toTichet + "</td>"+
		  				"<td>" + response.result[i].toTichet + "</td>"+
		  				"<td>" + response.result[i].toTichet + "</td>"+
		  			  "</tr>";
	  }
	  userInfo += "</tbody>";
   
   $('#tabel_init').html(userInfo);
  },
  error: function(){      
   alert('Error while request..');
  }
 });
}