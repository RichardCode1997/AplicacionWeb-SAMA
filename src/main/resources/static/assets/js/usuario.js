$(document).ready(function() {

var tbody = $('.table tbody');

$.ajax({
  url: 'http://localhost:8080/usuarios',
  method: 'GET',
  dataType: 'json',
  success: function(data) {
  tbody.empty(); // Limpia el contenido actual de la tabla antes de agregar nuevos datos
  console.log('ajax: url: http://localhost:8080/usuarios', data)

   // Crea la cabecera de la tabla
    var thead = $('<thead></thead>');
    var headerRow = $('<tr></tr>');
    headerRow.append('<th scope="col">#Id</th>' +
                    '<th scope="col">Nombre(s)</th>' +
                    '<th scope="col">Apellido(s)</th>' +
                    '<th scope="col">Dni</th>' +
                    '<th scope="col">Correo</th>' +
                    '<th scope="col">Direccion</th>' +
                    '<th scope="col">Celular</th>' +
                    '<th scope="col">Rol</th>' +
                    '<th scope="col">Acciones</th>');
    thead.append(headerRow);
    var contador = 1;
    $.each(data, function(index, usuario) {
      var nuevaFila = $('<tr></tr>');
      nuevaFila.html('<th scope="row">' + contador + '</th>' +
                    '<td>' + usuario.nombre  + '</td>' +
                    '<td>' + usuario.apellido + '</td>' +
                    '<td>' + usuario.dni + '</td>' +
                    '<td>' + usuario.correo + '</td>' +
                    '<td>' + usuario.direccion + '</td>' +
                    '<td>' + usuario.celular + '</td>' +
                    '<td>' + usuario.rol.nombreRol + '</td>' +
                    '<td>' +
                    '<a href="/userdetails?idUsuario=' + usuario.idUsuario + '" data-idusuario="' + usuario.idUsuario + '"><i class="bi bi-eye-fill" style="padding-right: 10px;"></i></a>' +
                    '<a href="#"><i class="bi bi-trash-fill"></i></a>' +
                    '</td>');

      tbody.append(nuevaFila);
      contador++;
    });

     // Actualiza el contenido del título y el párrafo
          $('.card-title').text('Usuarios');
          $('div.card-body > p').text('En esta sección listamos a todos los usuarios, mostrándonos sus asistencias, faltas y permisos; dándonos en la última columna acciones que podemos realizar en cada usuario');

    // Reemplaza la tabla existente con la nueva tabla que incluye la cabecera
          $('.table').html(thead);
          $('.table').append(tbody);
  },
  error: function(jqXHR, textStatus, errorThrown) {
//    console.error('Error:', errorThrown);
  }
});


});