package pe.edu.tecsup.app.services;

import pe.edu.tecsup.app.dtos.ProductoDto;
import pe.edu.tecsup.app.entities.Producto;

import java.util.List;

public interface ProductoService {

    List<ProductoDto> findAll() throws Exception;
    List<ProductoDto> findByName(String nombre) throws Exception;
    ProductoDto findById(Long id) throws Exception;

    void save(ProductoDto producto) throws Exception;

    void update(Long id, String nombreProducto) throws Exception;

    void deleteById(Long id) throws Exception;

}
