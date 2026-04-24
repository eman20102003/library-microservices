package book_service;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.HashMap;
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping("/{id}")
    public Map<String, Object> getBook(@PathVariable String id) {

        Map<String, Object> book = new HashMap<>();
        book.put("bookId", id);
        book.put("title", "Clean Code");
        book.put("available", true);
        book.put("quantity", 5);

        return book;
    }
}
