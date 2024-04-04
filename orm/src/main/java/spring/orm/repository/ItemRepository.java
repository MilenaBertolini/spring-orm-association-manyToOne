package spring.orm.repository;

import org.springframework.data.repository.CrudRepository;
import spring.orm.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

    
} 