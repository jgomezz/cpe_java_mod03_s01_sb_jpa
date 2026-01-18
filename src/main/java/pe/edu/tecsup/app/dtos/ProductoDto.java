package pe.edu.tecsup.app.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pe.edu.tecsup.app.entities.Categoria;

import java.util.Date;

@Data
@Builder
public class ProductoDto {

    private Long id;
    private Long categorias_id;
    private Categoria categoria;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen_nombre;
    private String imagen_tipo;
    private Long imagen_tamanio;
    private Integer estado;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creado;

}
