package spring.orm.repository;

import org.springframework.data.repository.CrudRepository;
import spring.orm.domain.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

    
}