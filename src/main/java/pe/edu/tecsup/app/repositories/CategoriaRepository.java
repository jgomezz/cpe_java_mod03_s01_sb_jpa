package pe.edu.tecsup.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.app.entities.Categoria;

import java.util.List;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {

    //List<Categoria>  findAll();

}
