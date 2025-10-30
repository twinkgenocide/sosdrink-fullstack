package cl.duoc.risani.sosdrink.backend.restcontrollers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.risani.sosdrink.backend.entities.TipoUsuario;
import cl.duoc.risani.sosdrink.backend.services.TipoUsuarioServices;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tiposdeusuarios")

public class TipoUsuarioRestControllers {

    @Autowired
    private TipoUsuarioServices tipousuarioServices;

    @PostMapping
    public ResponseEntity<TipoUsuario> crearTipoDeUsuario(@RequestBody TipoUsuario tipousuario) {
        TipoUsuario nuevoTipoUsuario = tipousuarioServices.crear(tipousuario);
        return ResponseEntity.ok(nuevoTipoUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> obtenerTipoDeUsuarioPorId(@PathVariable Long id) {
        TipoUsuario tipousuario = tipousuarioServices.obtenerId(id);
        return ResponseEntity.ok(tipousuario);
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> listarTiposDeUsuarios() {
        List<TipoUsuario> tiposdeusuarios = tipousuarioServices.listarTodas();
        return ResponseEntity.ok(tiposdeusuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoDeUsuario(@PathVariable Long id) {
        tipousuarioServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoUsuario> actualizarTipoDeUsuario(@PathVariable Long id,
            @RequestBody TipoUsuario tipoUsuarioActualizado) {
        TipoUsuario tipousuario = tipousuarioServices.actualizar(id, tipoUsuarioActualizado);
        return ResponseEntity.ok(tipousuario);
    }
}
