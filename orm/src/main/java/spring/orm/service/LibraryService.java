package spring.orm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.orm.repository.LibraryRepository;
import spring.orm.domain.Library;

// A anotação @Service é usada para indicar que uma classe é um "Service" (ou "Service Layer").
// A anotação @Service é um especialização da anotação @Component e é usada para anotar classes de serviço.
// A anotação @Component é uma superclasse para outras anotações de componentes, como @Repository, @Service e @Controller.
// Uma classe anotada com @Service é tipicamente uma classe que fornece serviços de negócios, como lógica de negócios e regras de negócios.
@Service
public class LibraryService {
    
    // A anotação @Autowired é usada para injetar dependências automaticamente.
    // A anotação @Autowired pode ser usada para injetar beans em propriedades, métodos e construtores.
    @Autowired
    LibraryRepository repository;

    public List<Library> getAll(){
        
        try{
            List<Library> books = new ArrayList<Library>();
            repository.findAll().forEach(books::add);
            return books;
        }catch (Exception e){
            return null;
        }

    }

    public Library getById(Long id){
        Optional<Library> library = repository.findById(id);
        if(library.isPresent()){
            return library.get();
        }
        return null;
    }

    public Library create(Library library){
        return repository.save(library);
    }

    public Library update(Long id, Library item){
        Optional<Library> existingBookOptional = repository.findById(id);
        if(existingBookOptional.isPresent()){
            Library existingBook = existingBookOptional.get();
            existingBook.setNome(item.getNome());
            return repository.save(existingBook);
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
