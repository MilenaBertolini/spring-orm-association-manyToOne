package spring.orm.repository;

import org.springframework.data.repository.CrudRepository;
import spring.orm.domain.Library;

public interface LibraryRepository extends CrudRepository<Library, Long>{

    
}