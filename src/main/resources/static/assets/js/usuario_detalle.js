$(document).ready(function() {
  var urlParams = new URLSearchParams(window.location.search);
  var idEmpleado = urlParams.get('id_empleado');

  if (idEmpleado) {
    // Realizar una solicitud AJAX para obtener los datos del empleado usando idEmpleado
    $.ajax({
      url: 'https://6460685dfe8d6fb29e304a73.mockapi.io/api/empleados/' + idEmpleado,
      method: 'GET',
      dataType: 'json',
      success: function(data) {
        console.log("data",data);
      },
      error: function(jqXHR, textStatus, errorThrown) {
        console.error('Error:', errorThrown);
      }
    });
  }
});
