document.addEventListener('DOMContentLoaded', function () {
    const modal = document.getElementById('productoModal');
    const cantidadInput = document.getElementById('modalCantidad');

    modal.addEventListener('show.bs.modal', function (event) {
        const card = event.relatedTarget;

        if (!card) return;

        document.getElementById('modalFoto').src = card.getAttribute('data-foto');
        document.getElementById('modalNombreProducto').textContent = card.getAttribute('data-nombre');
        document.getElementById('modalPrecioVenta').textContent = card.getAttribute('data-precio');
        document.getElementById('modalPrincipioActivo').textContent = card.getAttribute('data-principio');
        document.getElementById('modalPresentacion').textContent = card.getAttribute('data-presentacion');
        document.getElementById('modalLaboratorio').textContent = card.getAttribute('data-laboratorio');
    });

    document.getElementById('btnDecrement').onclick = function () {
        const value = parseInt(cantidadInput.value);
        if (value > 1) cantidadInput.value = value - 1;
    };

    document.getElementById('btnIncrement').onclick = function () {
        const value = parseInt(cantidadInput.value);
        cantidadInput.value = value + 1;
    };
});




document.addEventListener('DOMContentLoaded', function() {
    const searchInput = document.getElementById('searchInput'); // Campo de búsqueda
    const searchButton = document.getElementById('searchButton'); // Botón de búsqueda
    const productCards = document.querySelectorAll('.card'); // Todas las tarjetas de producto

    // Función para filtrar productos
    function filterProducts() {
        const searchTerm = searchInput.value.toLowerCase(); // Obtener término de búsqueda en minúsculas

        // Iterar sobre todas las tarjetas de producto
        productCards.forEach(card => {
            const productName = card.querySelector('.card-title').innerText.toLowerCase(); // Obtener nombre del producto
            if (productName.includes(searchTerm)) {
                // Mostrar la tarjeta si el nombre del producto incluye el término de búsqueda
                card.style.display = 'block';
            } else {
                // Ocultar la tarjeta si no coincide con el término de búsqueda
                card.style.display = 'none';
            }
        });
    }

    // Evento de búsqueda cuando se presiona el botón
    searchButton.addEventListener('click', function(event) {
        event.preventDefault(); // Evitar que el formulario se envíe y recargue la página
        filterProducts(); // Filtrar productos
    });

    // Opcional: Filtrar productos cuando se presiona "Enter"
    searchInput.addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            filterProducts();
        }
    });
});