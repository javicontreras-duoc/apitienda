package fullstack.apitienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import fullstack.apitienda.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    List<Producto> findByCategoriaIgnoreCase(String categoria);
}
