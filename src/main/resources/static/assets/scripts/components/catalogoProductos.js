$(document).ready(function () {
	

  $('#tblProducto').dataTable({
       searching: false,
       lengthChange: false,
       paging: true,
       destroy:true,
       info:false,
       autoWidth: false,
       responsive: true,
       'columnDefs': [
           {
               'targets': 0,
               'checkboxes': {
                  'selectRow': false
               }
            }
         ],
         'select': {
            'style': 'single'
         }
       
   });
  
  
  $('#tblProducto tbody').on( 'click', 'tr', function () {
  	var table = $('#tblProducto').DataTable();
      var rowData = table.row( this ).data();
      $("#stockProducto").val(rowData[1]);
      $("#stockExistencia").val(rowData[3]);
      $("#idProducto").val(rowData[9]);
      $("#idCategoria").val(rowData[10]);
      $("#stockCantidad").val("");
  } );
   
  
  $("#modalAgregarStock").iziModal({
	  width: 700,
	  radius: 5,
	  padding: 10,
	  loop: false
	});
  
        
});

function confirmaEliminar(id) {
	swal({
		  title: "¿Desea continuar?",
		  text: "Ya no podrá utilizar el producto en el proceso de venta",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  eliminaProducto(id);
		  } else {
		   
		  }
		});
}

function confirmaEliminarMica(id) {
	swal({
		  title: "¿Desea continuar?",
		  text: "Ya no podrá asignar la mica a un tratamiento",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  eliminaMica(id);
		  } else {
		   
		  }
		});
}

function eliminaProducto(id)
{
	
	var uri= ObtieneContex()+'/catalogo/elimina/producto/'+id;
    uri=uri.replace("/catalogo/catalogo/", "/catalogo/");

    $.ajax({
        type: 'GET',
        url: uri,
        beforeSend: function () {
			
        },
        success: function (data) {
        	if(data.codigo==1)
        		mensajeExito(data.mensaje);
        	if(data.codigo==0)
        		mensajeError(data.mensaje);
        	
        },
        error: function () {
        	mensajeError("Intente de nuevo, si el problema persiste contacte al administrador");
			/*
            var dialog = bootbox.alert({
                message: '<p class="text-center">' + "No se encontro resultados con los criterios introducidos" + '</p>',
                closeButton: true
            });
            */
        },complete: function() {
        	setTimeout(function(){
        		location.reload();
        	}, 2400);
        	
		}
    })

}

function eliminaMica(id)
{
	
	var uri= ObtieneContex()+'/catalogo/elimina/mica/'+id;
    uri=uri.replace("/catalogo/catalogo/", "/catalogo/");

    $.ajax({
        type: 'GET',
        url: uri,
        beforeSend: function () {
			
        },
        success: function (data) {
        	if(data.codigo==1)
        		mensajeExito(data.mensaje);
        	if(data.codigo==0)
        		mensajeError(data.mensaje);
        	
        },
        error: function () {
        	mensajeError("Intente de nuevo, si el problema persiste contacte al administrador");
			
        },complete: function() {
        	setTimeout(function(){
        		location.reload();
        	}, 2400);
        	
		}
    })

}

function detalleProducto(id)
{
	
	// $("#formMdfProduct")[0].reset();
   
    var uri=ObtieneContex()+'/catalogo/detailproducto/'+id;
    uri=uri.replace("/catalogo/catalogo/", "/catalogo/");
    $.ajax({
        type: 'GET',
        url: uri,
        beforeSend: function () {
			
        },
        success: function (data) {
        	
        	$("#actId").val(data.id);
        	$("#actIdCategoria").val(data.idCategoria);
        	$("#actClave").val(data.clave);
        	$("#actNombre").val(data.nombre);
        	$("#actModelo").val(data.modelo);
        	$("#actColor").val(data.color);
        	$("#actTipo").val(data.tipo);
        	$("#actIdMaterial").val(data.idMaterial);
        	$("#actTamanio").val(data.tamanio);
        	$("#actPrecioCompra").val(data.precioCompra);
        	$("#actPrecioVenta").val(data.precioVenta);
        	$("#actExistencia").val(data.existencia);
        	
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

function detalleMica(id)
{
	
	// $("#formMdfProduct")[0].reset();
   
    var uri=ObtieneContex()+'/catalogo/detailMica/'+id;
    uri=uri.replace("/catalogo/catalogo/", "/catalogo/");
    $.ajax({
        type: 'GET',
        url: uri,
        beforeSend: function () {
			
        },
        success: function (data) {
        	
        	$("#actId").val(data.id);
        	$("#actIdMaterial").val(data.idMaterial);
        	$("#actDescripcion").val(data.descripcion);
        	$("#actNombre").val(data.nombre);
           	$("#actPrecioCompra").val(data.precio);
        	$("#actPrecioVenta").val(data.precioVenta);
        	$("#actExistencia").val(data.existencia);
        	
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


function actualizaProducto(){
	
	var productoDto={
			"id":$("#actId").val(data.id),
        	"idCategoria":$("#actIdCategoria").val(),
			"clave":$("#actClave").val(),
			"nombre":$("#actNombre").val(),
			"modelo":$("#actModelo").val(),
			"color":$("#actColor").val(),
			"tipo":$("#actTipo").val(),
			"idMaterial":$("#actIdMaterial").val(),
			"tamanio":$("#actTamanio").val(),
			"precioCompra":$("#actPrecioCompra").val(),
			"precioVenta":$("#actPrecioVenta").val(),
			"existencia":$("#actExistencia").val()
	};
	
	$.ajax({
        type: 'POST',
        data: JSON.stringify(productoDto),
        url: '/catalogo/modifica/producto',
        dataType: 'json', 
        contentType: 'application/json',
        beforeSend: function () {
			
        },
        success: function (data) {
        	$('#modalAgregarStock').iziModal('close');
			//console.log(data);
        	
            if(data.codigo=="1")
            	mensajeExito(data.mensaje);
            
        },
        error: function () {

			/*
            var dialog = bootbox.alert({
                message: '<p class="text-center">' + "No se encontro resultados con los criterios introducidos" + '</p>',
                closeButton: true
            });
            */
        },
        complete: function() {
        	setTimeout(function(){
        		location.reload();
        	}, 2400);
        	
		}
    })
	
}


function ObtieneContex()
{
	var aux= window.location.pathname.split("/");
	var context = aux[1];
	var urlSvr =window.location.protocol + "//" + window.location.host + '/'+context;
	return urlSvr;
}

function mensajeExito(mensaje) {
	swal("Exito",mensaje, "success");
}

function mensajeError(mensaje) {
	swal("Error",mensaje, "error");
}