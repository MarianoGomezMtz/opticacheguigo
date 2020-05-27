$(document).ready(function () {

  $('.numero').mask('##0', {'translation': {0: {pattern: /[0-9*]/}}});
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
	  padding: 20,
	  group: 'products',
	  loop: true
	});
  
        
});

function mensajeExito(mensaje) {
	swal(mensaje, "success");
}

function actualizarStock()
{
    var stockProducto={
        "idProducto":$("#idProducto").val(),
        "idCategoria":$("#idCategoria").val(),
        "cantidad":$("#stockCantidad").val()
    }

    $.ajax({
        type: 'POST',
        data: JSON.stringify(stockProducto),
        url: './actualizaInventario',
        dataType: 'json', 
        contentType: 'application/json',
        beforeSend: function () {
			
        },
        success: function (data) {
			console.log(data);
            if(data.codigo=="1")
            {
                
            	mensajeExito(data.mensaje);
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

