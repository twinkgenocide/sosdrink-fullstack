package cl.duoc.risani.sosdrink.backend.services;
import cl.duoc.risani.sosdrink.backend.entities.TipoProducto;
import java.util.List;

public interface TipoProductoServices {

    TipoProducto crear(TipoProducto tipoProducto);
    TipoProducto obtenerId(Long id);
    List<TipoProducto> listarTodas();    
    void eliminar(Long id);
    TipoProducto actualizar(Long id, TipoProducto tipoProductoActualizado);

}
