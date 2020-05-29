//You can add an icon to your alert! There are 4 predefined ones: "warning", "error", "success" and "info".
function mensaje(mensaje,tipo) {
	swal(mensaje, tipo);
}


function ObtieneContex()
{
	var aux= window.location.pathname.split("/");
	var context = aux[1];
	var urlSvr =window.location.protocol + "//" + window.location.host + '/'+context;
	return urlSvr;
}