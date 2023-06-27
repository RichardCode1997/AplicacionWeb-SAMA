$(document).ready(function() {
  $.ajax({
    url: 'http://localhost:8080/noticias',
    dataType: 'json',
    success: function(data) {
      // La respuesta JSON se ha recibido correctamente
      // Procesa los datos y crea las cards dinámicamente
      crearCards(data);
    },
    error: function() {
      // Ocurrió un error al obtener los datos JSON
      console.log('Error al obtener los datos JSON de la API.');
    }
  });
});

function crearCards(data) {
  // Obtén el contenedor donde se agregarán las cards
  var container = $('.row');

  // Itera sobre los datos y crea las cards
  $.each(data, function(index, item) {
    // Crea el elemento de la card con los datos correspondientes
    var card = $('<div>').addClass('col-xl-4');
    var cardInner = $('<div>').addClass('card');
//    var cardImage = $('<img>').attr('src', item.imagen).addClass('card-img-top');
    var cardImage = $('<img>').attr('src', "assets/img/card.jpg").addClass('card-img-top');
    var cardBody = $('<div>').addClass('card-body');
    var cardTitle = $('<h5>').addClass('card-title').text(item.titulo);
    var cardText = $('<p>').addClass('card-text').text(item.detalle);

    // Agrega los elementos al DOM
    cardBody.append(cardTitle, cardText);
    cardInner.append(cardImage, cardBody);
    card.append(cardInner);
    container.append(card);
  });
}
