document.addEventListener('DOMContentLoaded', function() {
    const categorySelect = document.getElementById('categorySelect');
    const searchInput = document.querySelector('input[name="buscar"]');
    const currentSearchValue = searchInput ? searchInput.value : '';

    // Filtrar productos por categoría cuando se selecciona una opción
    categorySelect.addEventListener('change', function() {
        const category = categorySelect.value;
        let url = '/catalogo';

        // Agregar el parámetro de búsqueda si existe
        if (currentSearchValue) {
            url += `?buscar=${encodeURIComponent(currentSearchValue)}`;
        }

        // Agregar el parámetro de categoría si se selecciona
        if (category) {
            url += `&categoria=${encodeURIComponent(category)}`;
        }

        window.location.href = url;
    });
});

