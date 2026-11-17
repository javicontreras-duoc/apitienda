package fullstack.apitienda.controller;

import fullstack.apitienda.model.Producto;
import fullstack.apitienda.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Productos", description = "Endpoints para la gestión del catálogo de mangas e inventario")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    @Operation(summary = "Obtener catálogo completo de mangas")
    public List<Producto> obtenerTodos() {
        return productoService.listarTodos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un manga por su ID")
    public Producto obtenerPorId(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    @Operation(summary = "Agregar un nuevo manga al catálogo")
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un manga existente por su ID")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoExistente = productoService.getProductoById(id);
        if (productoExistente != null) {
            productoExistente.setTitulo(producto.getTitulo());
            productoExistente.setDescripcion(producto.getDescripcion());
            productoExistente.setPrecio(producto.getPrecio());
            productoExistente.setStock(producto.getStock());
            return productoService.saveProducto(productoExistente);
        } else {
            return null; // O lanzar una excepción según tu preferencia
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un manga del catálogo por su ID")
    public void eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }
}
