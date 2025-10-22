package cl.duoc.risani.sosdrink.backend.services;
import cl.duoc.risani.sosdrink.backend.entities.Producto;
import java.util.List;

public interface ProductoServices {

    Producto crear(Producto Producto);
    Producto obtenerId(Long id);
    List<Producto> listarTodas();    
    void eliminar(Long id);
    Producto actualizar(Long id, Producto categoriaActualizada);

}
