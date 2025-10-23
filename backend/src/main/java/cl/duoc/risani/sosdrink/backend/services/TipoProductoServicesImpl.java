package cl.duoc.risani.sosdrink.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.risani.sosdrink.backend.entities.TipoProducto;

import cl.duoc.risani.sosdrink.backend.repository.TipoProductoRepositories;;

@Service
public class TipoProductoServicesImpl implements TipoProductoServices {

    @Autowired
    private TipoProductoRepositories tipoproductoRepositories;

    @Override
    public TipoProducto crear(TipoProducto tipoproducto){
        return tipoproductoRepositories.save(tipoproducto);
    }


    @Override
    public TipoProducto obtenerId(Long id) {
        return tipoproductoRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de producto no encontrado"));
    }

    @Override
    public List<TipoProducto> listarTodas() {
        return (List<TipoProducto>) tipoproductoRepositories.findAll();
    }

    @Override
    public void eliminar(Long id) {
        if (!tipoproductoRepositories.existsById(id)) {
            throw new RuntimeException("Tipo de producto no encontrado");
        }
        tipoproductoRepositories.deleteById(id);
    }

    @Override
    public TipoProducto actualizar(Long id, TipoProducto tipoProductoActualizado) {
        TipoProducto existente = obtenerId(id);
        existente.setNombre(tipoProductoActualizado.getNombre());
        return tipoproductoRepositories.save(existente);
    }


}

