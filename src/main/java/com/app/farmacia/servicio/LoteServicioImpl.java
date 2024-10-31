package com.app.farmacia.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.farmacia.entidad.Lote;
import com.app.farmacia.repositorio.LoteDAO;

@Service
public class LoteServicioImpl implements LoteServicio {

    @Autowired
    private LoteDAO LoteDAO;

    @Override
    public List<Lote> listarLotes() {
        return LoteDAO.findAll();
    }

    @Override
    public Lote guardarLote(Lote lote) {
        return LoteDAO.save(lote);
    }

    @Override
    public Lote obtenerLotePorId(Long id) {
        return LoteDAO.findById(id).orElse(null);
    }

    @Override
    public Lote actualizarLote(Lote lote) {
        return LoteDAO.save(lote);
    }

    @Override
    public void eliminarLote(Long id) {
        LoteDAO.deleteById(id);
    }
}