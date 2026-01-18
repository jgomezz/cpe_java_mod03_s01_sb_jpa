# Implementar JPA

## Categoria to JPA

1.- Mapear la entidad  

Categoria.java

```java

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="orden")
    private Integer orden;

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", orden=" + orden +
                '}';
    }
}

```
2.- Adaptar el Repository

CategoriaRepository.java

```java

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.tecsup.app.entities.Categoria;

import java.util.List;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {
}

```

3.- Ejecutar las pruebas   

## Uso de DTO y Mapper


1.- Crear DTO

CategoriaDto.java

```java

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaDto {

    private Long id;
    private String nombre;
    private Integer orden;

}

```

2.- Crear Mapper

CategoriaMapper.java

```java

import pe.edu.tecsup.app.dtos.CategoriaDto;
import pe.edu.tecsup.app.entities.Categoria;

public class CategoriaMapper {

    /**
     * Convierte de Entity a DTO
     * @param entity
     * @return
     */
    public static CategoriaDto toDto(Categoria entity) {
        return CategoriaDto.builder()
            .id(entity.getId())
            .nombre(entity.getNombre())
            .orden(entity.getOrden())
            .build();
    }
}

```


3.- Adaptar el Service

CategoriaServiceImpl.java

```java

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

```



