package cl.duoc.risani.sosdrink.backend.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.duoc.risani.sosdrink.backend.entities.Producto;
import cl.duoc.risani.sosdrink.backend.repository.ProductoRepositories;

/**
 * Pruebas unitarias para la clase ProductoServicesImpl.
 * Se utiliza Mockito para simular (mockear) el comportamiento del repositorio.
 */
@ExtendWith(MockitoExtension.class) // Habilita Mockito
class ProductoServicesImplTest {

    // @Mock: Crea una simulación (mock) del repositorio.
    @Mock
    private ProductoRepositories productoRepositories;

    // @InjectMocks: Crea una instancia real de ProductoServicesImpl
    // e inyecta el mock 'productoRepositories' en ella.
    @InjectMocks
    private ProductoServicesImpl productoServices;

    // Objeto de prueba reutilizable
    private Producto producto;

    /**
     * Este método se ejecuta antes de CADA test (@Test).
     * Se usa para configurar un estado inicial común.
     */
    @BeforeEach
    void setUp() {
        // Asumimos que la entidad Producto tiene setId y setNombre
        // Ajusta esto si tu entidad es diferente.
        producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Producto de Prueba");
        // producto.setPrecio(1000); // <- Agrega otros campos si son necesarios
    }

    @Test
    void testCrearProducto() {
        // 1. Arrange (Configurar)
        // Cuando se llame a productoRepositories.save() con CUALQUIER Producto...
        when(productoRepositories.save(any(Producto.class))).thenReturn(producto);

        // 2. Act (Actuar)
        // Llamamos al método del servicio que queremos probar
        Producto productoGuardado = productoServices.crear(producto);

        // 3. Assert (Verificar)
        assertNotNull(productoGuardado);
        assertEquals(1L, productoGuardado.getId());
        assertEquals("Producto de Prueba", productoGuardado.getNombre());
        
        // Verifica que el método save() del repositorio fue llamado exactamente 1 vez
        verify(productoRepositories, times(1)).save(producto);
    }

    @Test
    void testObtenerId_Encontrado() {
        // 1. Arrange
        // Simulamos que el repositorio SÍ encuentra el producto con ID 1
        when(productoRepositories.findById(1L)).thenReturn(Optional.of(producto));

        // 2. Act
        Producto productoEncontrado = productoServices.obtenerId(1L);

        // 3. Assert
        assertNotNull(productoEncontrado);
        assertEquals(1L, productoEncontrado.getId());
        verify(productoRepositories, times(1)).findById(1L);
    }

    @Test
    void testObtenerId_NoEncontrado() {
        // 1. Arrange
        // Simulamos que el repositorio NO encuentra el producto (devuelve Optional vacío)
        when(productoRepositories.findById(99L)).thenReturn(Optional.empty());

        // 2. Act & 3. Assert
        // Verificamos que se lanza la excepción correcta
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productoServices.obtenerId(99L);
        });

        // Verificamos el mensaje de la excepción
        assertEquals("Producto no encontrado", exception.getMessage());
        verify(productoRepositories, times(1)).findById(99L);
    }

    @Test
    void testListarTodas() {
        // 1. Arrange
        Producto producto2 = new Producto();
        producto2.setId(2L);
        producto2.setNombre("Producto 2");
        List<Producto> listaProductos = Arrays.asList(producto, producto2);

        // Simulamos que el repositorio devuelve la lista completa
        when(productoRepositories.findAll()).thenReturn(listaProductos);

        // 2. Act
        List<Producto> resultado = productoServices.listarTodas();

        // 3. Assert
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Producto de Prueba", resultado.get(0).getNombre());
        verify(productoRepositories, times(1)).findAll();
    }

    @Test
    void testEliminar_Exitoso() {
        // 1. Arrange
        // Simulamos que el producto SÍ existe para poder eliminarlo
        when(productoRepositories.existsById(1L)).thenReturn(true);
        // Simulamos el comportamiento de 'deleteById' (no hace nada por ser void)
        doNothing().when(productoRepositories).deleteById(1L);

        // 2. Act
        // El método eliminar no debería lanzar ninguna excepción
        assertDoesNotThrow(() -> {
            productoServices.eliminar(1L);
        });

        // 3. Assert
        // Verificamos que se llamó a existsById y luego a deleteById
        verify(productoRepositories, times(1)).existsById(1L);
        verify(productoRepositories, times(1)).deleteById(1L);
    }

    @Test
    void testEliminar_NoEncontrado() {
        // 1. Arrange
        // Simulamos que el producto NO existe
        when(productoRepositories.existsById(99L)).thenReturn(false);

        // 2. Act & 3. Assert
        // Verificamos que se lanza la excepción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productoServices.eliminar(99L);
        });

        assertEquals("Producto no encontrado", exception.getMessage());
        
        // Verificamos que existsById se llamó...
        verify(productoRepositories, times(1)).existsById(99L);
        // ...pero deleteById NUNCA se llamó
        verify(productoRepositories, never()).deleteById(anyLong());
    }

    @Test
    void testActualizar_Exitoso() {
        // 1. Arrange
        // Datos nuevos para el producto
        Producto productoActualizado = new Producto();
        productoActualizado.setNombre("Nombre Actualizado");

        // Simula la búsqueda del producto existente (que usa obtenerId internamente)
        when(productoRepositories.findById(1L)).thenReturn(Optional.of(producto));
        
        // Simula el guardado del producto ya modificado
        when(productoRepositories.save(any(Producto.class))).thenAnswer(invocation -> {
            // Verificamos que el producto que se va a guardar
            // tiene los datos actualizados
            Producto pGuardado = invocation.getArgument(0);
            assertEquals(1L, pGuardado.getId()); // El ID no cambia
            assertEquals("Nombre Actualizado", pGuardado.getNombre()); // El nombre es el nuevo
            return pGuardado;
        });

        // 2. Act
        Producto resultado = productoServices.actualizar(1L, productoActualizado);

        // 3. Assert
        assertNotNull(resultado);
        assertEquals("Nombre Actualizado", resultado.getNombre());
        verify(productoRepositories, times(1)).findById(1L);
        verify(productoRepositories, times(1)).save(producto);
    }

    @Test
    void testActualizar_NoEncontrado() {
        // 1. Arrange
        Producto productoActualizado = new Producto();
        productoActualizado.setNombre("Nombre Actualizado");

        // Simulamos que el producto a actualizar no se encuentra
        when(productoRepositories.findById(99L)).thenReturn(Optional.empty());

        // 2. Act & 3. Assert
        // Verificamos que se propaga la excepción de "Producto no encontrado"
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            productoServices.actualizar(99L, productoActualizado);
        });

        assertEquals("Producto no encontrado", exception.getMessage());
        
        // Verificamos que NUNCA se intentó guardar nada
        verify(productoRepositories, times(1)).findById(99L);
        verify(productoRepositories, never()).save(any(Producto.class));
    }
}