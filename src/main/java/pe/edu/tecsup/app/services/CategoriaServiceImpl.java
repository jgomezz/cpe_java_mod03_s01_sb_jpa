package pe.edu.tecsup.app.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.app.dtos.CategoriaDto;
import pe.edu.tecsup.app.entities.Categoria;
import pe.edu.tecsup.app.mapper.CategoriaMapper;
import pe.edu.tecsup.app.repositories.CategoriaRepository;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor // Genera el constructor con todos los atributos
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repository;

    @Override
    public List<CategoriaDto> findAll() {

        log.info("findAll categorias");

        // Usando el CategoriaMapper
        return repository.findAll().stream()
                .map(CategoriaMapper::toDto)
                .toList();

    }
}
