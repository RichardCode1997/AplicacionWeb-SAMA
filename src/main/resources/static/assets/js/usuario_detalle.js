$(document).ready(function() {
  var urlParams = new URLSearchParams(window.location.search);
    var idUsuario = urlParams.get('idUsuario');
    var profileOverview = $('#profile-overview');

    // Vaciar los campos
    profileOverview.find('.col-lg-9').empty();

    // Realizar la solicitud AJAX al cargar la pagina , no leas mi codigo y haz el tuyo :v
    $.ajax({
      url: 'http://localhost:8080/usuarios/' + idUsuario,
      method: 'GET',
      dataType: 'json',
      success: function(data) {
//      console.log(data)
        // Llenar los campos con los datos recibidos
        profileOverview.find('.col-lg-9:eq(0)').text(data.nombre);
        profileOverview.find('.col-lg-9:eq(1)').text(data.apellido);
        profileOverview.find('.col-lg-9:eq(2)').text(data.dni);
        profileOverview.find('.col-lg-9:eq(3)').text(data.correo);
        profileOverview.find('.col-lg-9:eq(4)').text(data.direccion);
        profileOverview.find('.col-lg-9:eq(5)').text(data.celular);
        profileOverview.find('.col-lg-9:eq(6)').text(data.rol.nombreRol);
      },
      error: function(jqXHR, textStatus, errorThrown) {
        console.error('Error:', errorThrown);
      }
    });

var profileEdit = $('#profile-overview');
    // Vaciar los campos
    profileEdit.find('.col-lg-9').empty()

    // Escucha el evento clic del botón "Editar Perfil"
    $('button[data-bs-target="#profile-edit"]').on('click', function() {
      // Realiza la petición AJAX
      $.ajax({
        url: 'http://localhost:8080/usuarios/' + idUsuario,
        method: 'GET',
        success: function(response) {

          // Imagen de Perfil
//          $('#profileImage').attr('src', response.imagenPerfil);

          $('#nombre').val(response.nombre);
          $('#apellido').val(response.apellido);
          $('#dni').val(response.dni);
          $('#correo').val(response.correo);
          $('#direccion').val(response.direccion);
          $('#celular').val(response.celular);
          $('#nombreRol').val(response.rol.nombreRol);

          $('#Twitter').val('https://twitter.com/');
          $('#Facebook').val('https://facebook.com/');
          $('#Instagram').val('https://instagram.com/');
          $('#Linkedin').val('https://linkedin.com/');
        },
        error: function() {
          // Maneja el error de la solicitud AJAX
        }
      });
    });


});//fin del ready
