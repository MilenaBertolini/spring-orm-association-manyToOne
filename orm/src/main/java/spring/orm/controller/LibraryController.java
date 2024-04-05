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

import spring.orm.domain.Library;
import spring.orm.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
        LibraryService service;

        @GetMapping
        public List<Library> getAll() {
                List<Library> items = service.getAll();
                return items;
        }

        @GetMapping("{id}")
        public Library getById(@PathVariable("id") Long id) {
                return service.getById(id);
        }

        @PostMapping
        public Library create(@RequestBody Library library) {
                Library categoria = service.create(library);
                return categoria;
        }

        @PutMapping("{id}")
        public Library update(@PathVariable("id") Long id, @RequestBody Library library) {
                return service.update(id, library);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return service.delete(id);
        }
}
