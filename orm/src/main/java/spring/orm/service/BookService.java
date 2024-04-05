package spring.orm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.orm.repository.BookRepository;
import spring.orm.domain.Book;

@Service
public class BookService {
    
    @Autowired
    BookRepository repository;

    public List<Book> getAll(){
        try{
            List<Book> items = new ArrayList<Book>();
            repository.findAll().forEach(items::add);
            return items;
        }catch(Exception e){
            return null;
        }
    }

    public Book getById(Long id){
        Optional<Book> book = repository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }

    public Book create(Book book){
        return repository.save(book);
    }

    public Book update(Long id, Book book){
        Optional<Book> existingBookOptional = repository.findById(id);

        if(existingBookOptional.isPresent()){
            Book existingBook = existingBookOptional.get();
            existingBook.setNome(book.getNome());
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
