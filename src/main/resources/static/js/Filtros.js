// Función que se ejecuta cuando se selecciona una categoría
function filterByCategory() {
    const category = document.getElementById('categorySelect').value;

    // Realiza una solicitud AJAX para obtener los productos filtrados
    fetch(`/productos/categoria?Categoria=${category}`) // Asegúrate de que el parámetro sea 'Categoria'
        .then(response => response.json())  // Esperamos una respuesta en formato JSON
        .then(data => {
            // Vaciar los productos actuales
            const content = document.querySelector('.content');
            content.innerHTML = ''; // Limpia la lista de productos actual

            // Verifica si hay productos para mostrar
            if (data.length > 0) {
                // Mostrar los productos filtrados
                data.forEach(producto => {
                    const card = document.createElement('div');
                    card.classList.add('card');
                    card.style.width = '15rem';

                    card.innerHTML = `
                        <img src="/upload/${producto.foto}" alt="Imagen del Producto" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">${producto.nombreProducto}</h5>
                            <p class="card-text">s/ ${producto.precioVenta}</p>
                            <a href="#" class="btn btn-outline-danger">Agregar al Carrito</a>
                        </div>
                    `;

                    content.appendChild(card);
                });
            } else {
                // Si no hay productos, muestra un mensaje
                content.innerHTML = '<p>No hay productos disponibles en esta categoría.</p>';
            }
        })
        .catch(error => console.error('Error fetching products:', error));
}
