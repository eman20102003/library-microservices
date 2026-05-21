package book_service;

import book_service.entity.Book;
import book_service.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repository;

    @PostMapping
    public Book addBook(
            @RequestBody Book book){

        return repository.save(book);
    }

    @GetMapping("/{id}")
    public Book getBook(
            @PathVariable String id){

        return repository.findById(id)
                .orElse(null);
    }
}