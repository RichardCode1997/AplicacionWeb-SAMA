$(document).ready(function() {

var tbody = $('.table tbody');

$.ajax({
  url: '/empleados',
  method: 'GET',
  dataType: 'json',
  success: function(data) {
  console.log(data);
    $.each(data, function(index, empleado) {
      var nuevaFila = $('<tr></tr>');
      nuevaFila.html('<th scope="row">' + empleado.idEmpleado + '</th>' +
                    '<td>' + empleado.usuario.nombre  + '</td>' +
                    '<td>' + empleado.usuario.apellido + '</td>' +
                    '<td>' + empleado.usuario.dni + '</td>' +
                    '<td>' + empleado.usuario.correo + '</td>' +
//                    '<td>' + empleado.usuario.direccion + '</td>' +
//                    '<td>' + empleado.usuario.celular + '</td>' +
                    '<td>' +
                    '<a href="/userdetails?idEmpleado=' + empleado.idEmpleado + '" data-idempleado="' + empleado.idEmpleado + '"><i class="bi bi-eye-fill" style="padding-right: 10px;"></i></a>' +
//                    '<a href="#"><i class="bi bi-eye-fill" style="padding-right: 10px;"></i></a>' +
                    '<a href="#"><i class="bi bi-trash-fill"></i></a>' +
                    '</td>');
      tbody.append(nuevaFila);
    });


  },
  error: function(jqXHR, textStatus, errorThrown) {
    console.error('Error:', errorThrown);
  }
});


});