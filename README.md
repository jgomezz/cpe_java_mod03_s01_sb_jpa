# Implementar JPA

## Categoria

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
