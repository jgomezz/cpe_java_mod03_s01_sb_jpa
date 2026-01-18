package pe.edu.tecsup.app.mapper;

import pe.edu.tecsup.app.dtos.CategoriaDto;
import pe.edu.tecsup.app.entities.Categoria;

public class CategoriaMapper {

    /**
     * Convierte de Entity a DTO
     * @param entity
     * @return
     */
    public static CategoriaDto toDto(Categoria entity) {

       // System.out.println(entity.getProductos());

        return CategoriaDto.builder()
            .id(entity.getId())
            .nombre(entity.getNombre())
            .orden(entity.getOrden())
            .build();
    }

    public static Categoria toEntity(CategoriaDto dto) {

        Categoria entity = new Categoria();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setOrden(dto.getOrden());

        return entity;

    }

}
