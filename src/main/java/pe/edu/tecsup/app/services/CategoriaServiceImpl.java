package pe.edu.tecsup.app.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.repositories.CategoriaRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor // Genera el constructor con todos los atributos
public class CategoriaServiceImpl implements CategoriaService {

// ------ Inyeccion por annotacion @Autowired
//    @Autowired
//    private CategoriaRepository repository;
// -------------------------------------------------------


// ----- Inyeccion  por constructor
    private final CategoriaRepository repository;

//    public CategoriaServiceImpl(CategoriaRepository repository) {
//        this.repository = repository;
//    }
// -------------------------------------------------------


    @Override
    public List<Categoria> findAll() {
        log.info("findAll categorias");
        return this.repository.findAll();
    }
}
