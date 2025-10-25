package cl.duoc.risani.sosdrink.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.risani.sosdrink.backend.entities.TipoUsuario;

import cl.duoc.risani.sosdrink.backend.repository.TipoUsuarioRepositories;;

@Service
public class TipoUsuarioServicesImpl implements TipoUsuarioServices {

    @Autowired
    private TipoUsuarioRepositories tipousuarioRepositories;

    @Override
    public TipoUsuario crear(TipoUsuario tipousuario){
        return tipousuarioRepositories.save(tipousuario);
    }


    @Override
    public TipoUsuario obtenerId(Long id) {
        return tipousuarioRepositories.findById(id)
                .orElseThrow(() -> new RuntimeException("Tipo de usuario no encontrado"));
    }

    @Override
    public List<TipoUsuario> listarTodas() {
        return (List<TipoUsuario>) tipousuarioRepositories.findAll();
    }

    @Override
    public void eliminar(Long id) {
        if (!tipousuarioRepositories.existsById(id)) {
            throw new RuntimeException("Tipo de usuario no encontrado");
        }
        tipousuarioRepositories.deleteById(id);
    }

    @Override
    public TipoUsuario actualizar(Long id, TipoUsuario tipoUsuarioActualizado) {
        TipoUsuario existente = obtenerId(id);
        existente.setNombre(tipoUsuarioActualizado.getNombre());
        return tipousuarioRepositories.save(existente);
    }


}

