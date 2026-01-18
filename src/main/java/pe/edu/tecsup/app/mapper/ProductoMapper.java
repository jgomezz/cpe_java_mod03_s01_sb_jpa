package pe.edu.tecsup.app.mapper;

import pe.edu.tecsup.app.dtos.ProductoDto;
import pe.edu.tecsup.app.entities.Producto;

public class ProductoMapper {

    public static ProductoDto toDto(Producto entity) {
        return ProductoDto.builder()
            .id(entity.getId())
            .nombre(entity.getNombre())
            .descripcion(entity.getDescripcion())
            .precio(entity.getPrecio())
            .stock(entity.getStock())
            .estado(entity.getEstado())
            .creado(entity.getCreado())
            .categorias_id(entity.getCategorias_id())
            .build();
    }

    public static Producto toEntity(ProductoDto dto) {

        Producto entity = new Producto();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecio(dto.getPrecio());
        entity.setStock(dto.getStock());
        entity.setEstado(dto.getEstado());
        entity.setCreado(dto.getCreado());
        entity.setCategorias_id(dto.getCategorias_id());

        return entity;
    }

}
