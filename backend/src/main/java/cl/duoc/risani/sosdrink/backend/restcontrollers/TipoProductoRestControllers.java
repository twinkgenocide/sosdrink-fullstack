package cl.duoc.risani.sosdrink.backend.restcontrollers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.risani.sosdrink.backend.entities.TipoProducto;
import cl.duoc.risani.sosdrink.backend.services.TipoProductoServices;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tiposdeproductos")

public class TipoProductoRestControllers {

    @Autowired
    private TipoProductoServices tipoproductoServices;

    @PostMapping
    public ResponseEntity<TipoProducto> crearTipoProducto(@RequestBody TipoProducto tipoproducto) {
        TipoProducto nuevoTipoProducto = tipoproductoServices.crear(tipoproducto);
        return ResponseEntity.ok(nuevoTipoProducto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoProducto> obtenerTipoProductoPorId(@PathVariable Long id) {
        TipoProducto tipoproducto = tipoproductoServices.obtenerId(id);
        return ResponseEntity.ok(tipoproducto);
    }

    @GetMapping
    public ResponseEntity<List<TipoProducto>> listarTiposDeProductos() {
        List<TipoProducto> tiposproductos = tipoproductoServices.listarTodas();
        return ResponseEntity.ok(tiposproductos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTipoDeProducto(@PathVariable Long id) {
        tipoproductoServices.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoProducto> actualizarTipoDeProducto(@PathVariable Long id,
            @RequestBody TipoProducto tipoProductoActualizado) {
        TipoProducto tipoproducto = tipoproductoServices.actualizar(id, tipoProductoActualizado);
        return ResponseEntity.ok(tipoproducto);
    }
}
