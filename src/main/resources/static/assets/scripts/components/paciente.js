$(document).ready(function () {

	$("#codigoPostal").focusout(function(){
		$('select option').remove();
		var cp=$("#codigoPostal").val();
		if(cp.length===5){
			consultaCP(cp);
		}else
			alert("INGRESE UN CP VALIDO");
	});
  
 
  
        
});

function consultaCP(codPostal){
	 $.ajax({
	        type: 'GET',
	        url: './codigoCP/'+codPostal,
	        beforeSend: function () {
				
	        },
	        success: function (data) {
	        	if(data.length>0){
	        		$("#municipio").val(data[0].municipio);
		             $("#estado").val(data[0].estado);
		        	cargarCombo($("#colonia"), data);
		        	if(data.length===1){
		        		$("#colonia").val(data[0].asentamiento);
		        	}
	        	}else{
	        		
	        	}
	        	 
	        	
	        },
	        error: function () {

				/*
	            var dialog = bootbox.alert({
	                message: '<p class="text-center">' + "No se encontro resultados con los criterios introducidos" + '</p>',
	                closeButton: true
	            });
	            */
	        }
	    })

	
}

function cargarCombo(id, data) {
	
    if (data != "" && data != null) {
        id.append('<option value="">SELECCIONE UNA OPCI&Oacute;N</option>');
        for (var key in data) {
            id.append('<option value="' + data[key].asentamiento + '"> ' + data[key].asentamiento + '</option>');
        }
       
    }else {
        id.append('<option value="">ERROR AL CARGAR DATOS</option>');
    }
}