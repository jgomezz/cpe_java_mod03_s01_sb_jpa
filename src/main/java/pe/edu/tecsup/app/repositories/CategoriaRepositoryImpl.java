package pe.edu.tecsup.app.repositories;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.app.entities.Categoria;

import java.sql.ResultSet;
import java.util.List;

/**
 * Mapeo de los resultados de la consulta SQL a la entidad Categoria
 */
class CategoriaRowMapper implements RowMapper<Categoria> {

    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
        Categoria categoria =  Categoria.builder()
                                        .id(rs.getLong("id"))
                                        .nombre(rs.getString("nombre"))
                                        .orden(rs.getInt("orden"))
                                        .build();
        return categoria;
    }
}

@Slf4j
@Repository
@AllArgsConstructor
public class CategoriaRepositoryImpl  implements CategoriaRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Categoria> findAll() {

        log.info("findAll categorias - repository");

        String sql = """
                    SELECT id, nombre, orden 
                    FROM categorias 
                    ORDER BY orden
                """;
        List<Categoria> categorias
                = this.jdbcTemplate.query(
                                            sql,
                                            new CategoriaRowMapper()
                                        );

        return categorias;
    }

}
