package pe.edu.tecsup.app.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.app.entities.Categoria;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class CategoriaServiceTest {

    @Autowired
    private CategoriaService categoriaService;

    @Test
    void findAll() {

        List<Categoria> categorias = this.categoriaService.findAll();

        for (Categoria categoria : categorias) {
            log.info(categoria.toString());
        }

        // Validaciones
        assertNotNull(categorias);  // que la lista no sea nula
        assertFalse(categorias.isEmpty()); // que la lista no esté vacía
        //assertEquals(3, categorias.size());

    }
}