package borrow_service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.HashMap;
@RestController
@RequestMapping("/borrow")

public class BorrowController {
    private RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public Map<String, Object> borrowBook(@RequestBody Map<String, String> request) {

        String bookId = request.get("bookId");

        String url = "http://localhost:8081/books/" + bookId;

        Map book = restTemplate.getForObject(url, Map.class);

        Map<String, Object> response = new HashMap<>();

        if ((Boolean) book.get("available")) {
            response.put("status", "success");
            response.put("message", "Book borrowed successfully");
        } else {
            response.put("status", "failed");
        }

        return response;
    }
}
