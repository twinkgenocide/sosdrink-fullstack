package cl.duoc.risani.sosdrink.backend.services;
import cl.duoc.risani.sosdrink.backend.entities.TipoUsuario;
import java.util.List;

public interface TipoUsuarioServices {

    TipoUsuario crear(TipoUsuario tipoUsuario);
    TipoUsuario obtenerId(Long id);
    List<TipoUsuario> listarTodas();    
    void eliminar(Long id);
    TipoUsuario actualizar(Long id, TipoUsuario tipoUsuarioActualizado);

}