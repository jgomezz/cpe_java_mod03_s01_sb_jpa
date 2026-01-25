package pe.edu.tecsup.app.mapper;

import pe.edu.tecsup.app.dtos.CategoriaDto;
import pe.edu.tecsup.app.dtos.ProductoDto;
import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.entities.Producto;

import java.util.ArrayList;
import java.util.List;

public class CategoriaMapper {

    /**
     * Convierte de Entity a DTO
     * @param entity
     * @return
     */
    public static CategoriaDto toDto(Categoria entity) {

       System.out.println(entity.getProductos());

        return CategoriaDto.builder()
            .id(entity.getId())
            .nombre(entity.getNombre())
            .orden(entity.getOrden())
            .productos(CategoriaMapper.toListDto(entity.getProductos()))
            .build();
    }

    public static Categoria toEntity(CategoriaDto dto) {

        Categoria entity = new Categoria();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setOrden(dto.getOrden());

        return entity;

    }

    /**
     *
     * @param entityList
     * @return
     */
    public static List<ProductoDto> toListDto(List<Producto> entityList) {

        List<ProductoDto> dtos = new ArrayList<>();

        for(Producto entity : entityList) {
            dtos.add(ProductoDto.builder()
                    .id(entity.getId())
                    .nombre(entity.getNombre())
                    .descripcion(entity.getDescripcion())
                    .precio(entity.getPrecio())
                    .stock(entity.getStock())
                    .estado(entity.getEstado())
                    .creado(entity.getCreado())
                    .build() );

        }

        return dtos;

    }
}
