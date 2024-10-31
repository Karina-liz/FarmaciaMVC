package com.app.farmacia.servicio;

import java.util.List;
import com.app.farmacia.entidad.Lote;

public interface LoteServicio {

    List<Lote> listarLotes();

    Lote guardarLote(Lote lote);

    Lote obtenerLotePorId(Long id);

    Lote actualizarLote(Lote lote);

    void eliminarLote(Long id);
}