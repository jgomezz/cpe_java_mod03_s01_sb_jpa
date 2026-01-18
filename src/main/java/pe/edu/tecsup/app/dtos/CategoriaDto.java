package pe.edu.tecsup.app.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaDto {

    private Long id;
    private String nombre;
    private Integer orden;

}
