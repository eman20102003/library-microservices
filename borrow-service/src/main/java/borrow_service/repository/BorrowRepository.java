package borrow_service.repository;


import borrow_service.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository
        extends JpaRepository<Borrow, String> {

}

