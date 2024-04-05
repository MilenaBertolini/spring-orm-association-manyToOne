package spring.orm.repository;

import org.springframework.data.repository.CrudRepository;
import spring.orm.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    
} 