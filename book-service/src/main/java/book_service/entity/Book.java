package book_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Book {

    @Id
    private String id;

    private String title;

    private boolean available;

    private int quantity;

    public Book() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}