package cl.duoc.risani.sosdrink.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.risani.sosdrink.backend.entities.Usuario;

import cl.duoc.risani.sosdrink.backend.repository.UsuarioRepositories;;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

    @Autowired
    private UsuarioRepositories usuarioRepositories;

    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepositories.save(usuario);
    }

    @Override
    public Usuario obtenerRun(String run) {
        return usuarioRepositories.findById(run)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public List<Usuario> listarTodas() {
        return (List<Usuario>) usuarioRepositories.findAll();
    }

    @Override
    public void eliminar(String run) {
        if (!usuarioRepositories.existsById(run)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepositories.deleteById(run);
    }

    @Override
    public Usuario actualizar(String run, Usuario usuarioActualizado) {
        Usuario existente = obtenerRun(run);
        existente.setNombre(usuarioActualizado.getNombre());
        return usuarioRepositories.save(existente);
    }

}
