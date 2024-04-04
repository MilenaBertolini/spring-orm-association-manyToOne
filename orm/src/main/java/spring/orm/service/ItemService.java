package spring.orm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.orm.repository.ItemRepository;
import spring.orm.domain.Item;

@Service
public class ItemService {
    
    @Autowired
    ItemRepository repository;

    public List<Item> getAll(){
        try{
            List<Item> items = new ArrayList<Item>();
            repository.findAll().forEach(items::add);
            return items;
        }catch(Exception e){
            return null;
        }
    }

    public Item getById(Long id){
        Optional<Item> item = repository.findById(id);
        if(item.isPresent()){
            return item.get();
        }
        return null;
    }

    public Item create(Item item){
        return repository.save(item);
    }

    public Item update(Long id, Item item){
        Optional<Item> existingItemOptional = repository.findById(id);

        if(existingItemOptional.isPresent()){
            Item existingItem = existingItemOptional.get();
            existingItem.setNome(item.getNome());
            return repository.save(existingItem);
        }else{
            return null;
        }
    }

    public boolean delete(Long id){
        try{
            repository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
