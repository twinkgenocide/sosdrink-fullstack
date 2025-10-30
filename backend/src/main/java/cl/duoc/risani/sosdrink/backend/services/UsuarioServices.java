package cl.duoc.risani.sosdrink.backend.services;

import cl.duoc.risani.sosdrink.backend.entities.Usuario;
import java.util.List;

public interface UsuarioServices {

    Usuario crear(Usuario tipoProducto);

    Usuario obtenerRun(String run);

    List<Usuario> listarTodas();

    void eliminar(String run);

    Usuario actualizar(String run, Usuario usuarioActualizado);

}
