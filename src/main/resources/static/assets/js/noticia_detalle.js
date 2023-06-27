

// Función para activar el evento de presionar el input tipo file al hacer clic en el enlace
function triggerFileInput() {
  var fileInput = document.getElementById("profileImage");
  fileInput.click();
}

function updateCardTitle(event) {
  var input = event.target;
  var cardTitle = document.querySelector('.card-title'); // Selecciona el elemento h5 con la clase 'card-title'
  cardTitle.innerText = input.value; // Actualiza el texto del elemento h5 con el valor del campo de entrada 'title'
}

function updateCardText(event) {
  var testArea = event.target;
  var cardText= document.querySelector('.card-text'); // Selecciona el elemento p con la clase 'card-title'
  cardText.innerText = testArea.value; // Actualiza el texto del elemento h5 con el valor del campo de entrada 'title'
}

function previewImage(event) {
  var input = event.target;
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    reader.onload = function (e) {
      document.getElementById("preview").src = e.target.result;
      document.getElementById("preview1").src = e.target.result;
    };
    reader.readAsDataURL(input.files[0]);
  }
}
