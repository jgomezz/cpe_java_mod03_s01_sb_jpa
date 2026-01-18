package pe.edu.tecsup.app.entities;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Categoria {

    private Long id;
    private String nombre;
    private Integer orden;

}
