package spring.orm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.orm.service.BookService;
import spring.orm.domain.Book;

@RestController
@RequestMapping("/book")
public class BookController {
     @Autowired
        BookService service;

        @GetMapping
        public List<Book> getAll() {
                return service.getAll();
        }

        @GetMapping("{id}")
        public Book getById(@PathVariable("id") Long id) {
                return service.getById(id);
        }

        @PostMapping
        public Book create(@RequestBody Book book) {
                return service.create(book);
        }

        @PutMapping("{id}")
        public Book update(@PathVariable("id") Long id, @RequestBody Book book) {
                return service.update(id, book);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return service.delete(id);
        }
}
