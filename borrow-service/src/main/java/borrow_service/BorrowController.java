package borrow_service;

import borrow_service.entity.Borrow;
import borrow_service.repository.BorrowRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final BorrowRepository repository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public BorrowController(
            BorrowRepository repository,
            KafkaTemplate<String, String> kafkaTemplate
    ) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public Borrow borrowBook(@RequestBody Borrow borrow) {

        String url = "http://book-service:8081/books/" + borrow.getBookId();

        Map<String, Object> book = restTemplate.getForObject(url, Map.class);

        // حماية من null
        if (book == null) {
            borrow.setStatus("FAILED");
            return repository.save(borrow);
        }

        Boolean available = (Boolean) book.get("available");

        if (Boolean.TRUE.equals(available)) {

            kafkaTemplate.send("payment-topic", "Payment Request Created");
            kafkaTemplate.send("notification-topic", "Notification Sent");

            borrow.setStatus("BORROWED");

        } else {
            borrow.setStatus("FAILED");
        }

        return repository.save(borrow);
    }
}