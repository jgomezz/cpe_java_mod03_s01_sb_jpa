package pe.edu.tecsup.app.dtos;

import lombok.Builder;
import lombok.Data;
import pe.edu.tecsup.app.entities.Producto;

import java.util.List;

@Builder
@Data
public class CategoriaDto {

    private Long id;
    private String nombre;
    private Integer orden;

}
