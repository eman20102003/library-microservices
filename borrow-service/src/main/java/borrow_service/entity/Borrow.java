package borrow_service.entity;

import jakarta.persistence.*;

@Entity
public class Borrow {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String customerId;

    private String bookId;

    private String status;

    public Borrow() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(
            String customerId) {

        this.customerId = customerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(
            String bookId) {

        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status) {

        this.status = status;
    }
}