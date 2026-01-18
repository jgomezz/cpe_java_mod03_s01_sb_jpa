package pe.edu.tecsup.app.repositories;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pe.edu.tecsup.app.entities.Producto;

import java.util.List;

/**
 *
 */
class ProductoRowMapper implements RowMapper<Producto> {
    @Override
    public Producto mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
        Producto producto =  Producto.builder()
                                .id(rs.getLong("id"))
                                .categorias_id(rs.getLong("categorias_id"))
                                .nombre(rs.getString("nombre"))
                                .descripcion(rs.getString("descripcion"))
                                .precio(rs.getDouble("precio"))
                                .stock(rs.getInt("stock"))
                                .imagen_nombre(rs.getString("imagen_nombre"))
                                .imagen_tipo(rs.getString("imagen_tipo"))
                                .imagen_tamanio(rs.getLong("imagen_tamanio"))
                                .estado(rs.getInt("estado"))
                                .creado(rs.getDate("creado"))
                                .build();
        return producto;
    }
}


@Slf4j
@Repository
@AllArgsConstructor
public class ProductoRepositoryImpl implements ProductoRepository{

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Producto> findAll() throws Exception {
        log.info("findAll productos - repository");
        String sql =
                """
                    SELECT p.id, p.categorias_id, c.nombre AS
                    categorias_nombre, p.nombre,
                    p.descripcion, p.precio, p.stock,
                    p.imagen_nombre, p.imagen_tipo,
                    p.imagen_tamanio, p.creado, p.estado
                    FROM productos p
                    INNER JOIN categorias c ON c.id =
                    p.categorias_id
                    WHERE estado=1
                    ORDER BY id
                """;

         List<Producto> productos
                 = this.jdbcTemplate.query(sql, new ProductoRowMapper());
         log.info("productos: {}", productos);

         return productos;
    }

    @Override
    public List<Producto> findByName(String nombre) throws Exception {
        log.info("findByName producto - repository");
        String sql =
                """
                SELECT p.id, p.categorias_id, c.nombre AS
                categorias_nombre, p.nombre,
                p.descripcion, p.precio, p.stock,
                p.imagen_nombre, p.imagen_tipo,
                p.imagen_tamanio, p.creado, p.estado
                FROM productos p
                INNER JOIN categorias c ON c.id =
                p.categorias_id
                WHERE estado = 1 AND upper(p.nombre) LIKE
                upper(?)
                ORDER BY id
                """;
        Object[] parameters = new Object[] {nombre}; // new
        List<Producto> productos
                = this.jdbcTemplate.query(
                                sql,
                                new ProductoRowMapper(),
                                parameters
                            );

        log.info("productos: {}", productos);
        return productos;
    }

    @Override
    public Producto findById(Long id) throws Exception {
        log.info("findById producto - repository");
        String sql =
                """
                    SELECT p.id, p.categorias_id, c.nombre AS
                    categorias_nombre, p.nombre, p.estado,
                    p.descripcion, p.precio, p.stock,
                    p.imagen_nombre, p.imagen_tipo, p.imagen_tamanio,
                    p.creado
                    FROM productos p
                    INNER JOIN categorias c ON c.id =
                    p.categorias_id
                    WHERE estado = 1 AND p.id = ?
                """;
        Object[] parameter = new Object[] {id};
        Producto producto
                = this.jdbcTemplate.queryForObject(
                        sql,
                        new ProductoRowMapper(),
                        parameter
                    ) ;
        log.info("producto: {}", producto);
        return producto;
    }

    @Override
    public void save(Producto producto) throws Exception {

        String sql =
                """
                    INSERT INTO productos (categorias_id, nombre,
                    descripcion, precio, stock, estado,
                    imagen_nombre, imagen_tipo,
                    imagen_tamanio)
                    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
               """;

        this.jdbcTemplate.update(
                sql,
                producto.getCategorias_id(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getEstado(),
                producto.getImagen_nombre(),
                producto.getImagen_tipo(),
                producto.getImagen_tamanio()
        );


    }

    @Override
    public void update(Long id, String nombreProducto) throws Exception {
        log.info("call update()");
        String sql = """
                        UPDATE productos 
                        SET nombre = ? 
                        WHERE id = ?;
                    """;
        this.jdbcTemplate.update(sql, nombreProducto, id);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        log.info("call deleteById()");
        String sql = """
                        DELETE FROM productos 
                        WHERE id = ?
                    """;
        this.jdbcTemplate.update(sql, id);
    }
}
