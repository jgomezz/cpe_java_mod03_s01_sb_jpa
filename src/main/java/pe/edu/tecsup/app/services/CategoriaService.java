package pe.edu.tecsup.app.services;

import pe.edu.tecsup.app.dtos.CategoriaDto;
import pe.edu.tecsup.app.entities.Categoria;

import java.util.List;

public interface CategoriaService {

    List<CategoriaDto> findAll();

}
