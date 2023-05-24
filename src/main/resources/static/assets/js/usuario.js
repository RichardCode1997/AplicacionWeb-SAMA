$(document).ready(function() {

var tbody = $('.table tbody');

$.ajax({
  url: 'http://localhost:8080/usuarios',
  method: 'GET',
  dataType: 'json',
  success: function(data) {
    $.each(data, function(index, usuario) {
      var nuevaFila = $('<tr></tr>');
      nuevaFila.html('<th scope="row">' + usuario.idUsuario + '</th>' +
                    '<td>' + usuario.nombre  + '</td>' +
                    '<td>' + usuario.apellido + '</td>' +
                    '<td>' + usuario.dni + '</td>' +
                    '<td>' + usuario.correo + '</td>' +
                    '<td>' + usuario.direccion + '</td>' +
                    '<td>' + usuario.celular + '</td>' +
                    '<td>' + usuario.rol.nombreRol      + '</td>' +
                    '<td>' +
                    '<a href="/userdetails?idUsuario=' + usuario.idUsuario + '" data-idusuario="' + usuario.idUsuario + '"><i class="bi bi-eye-fill" style="padding-right: 10px;"></i></a>' +
//                    '<a href="#"><i class="bi bi-eye-fill" style="padding-right: 10px;"></i></a>' +
                    '<a href="#"><i class="bi bi-trash-fill"></i></a>' +
                    '</td>');

      tbody.append(nuevaFila);
    });


  },
  error: function(jqXHR, textStatus, errorThrown) {
//    console.error('Error:', errorThrown);
  }
});


});