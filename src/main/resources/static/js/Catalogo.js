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