package cl.duoc.risani.sosdrink.backend.repository;

import org.springframework.data.repository.CrudRepository;
import cl.duoc.risani.sosdrink.backend.entities.Usuario;

public interface UsuarioRepositories extends CrudRepository<Usuario, String> {

}
