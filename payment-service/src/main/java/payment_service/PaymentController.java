package payment_service;

import payment_service.entity.Payment;
import payment_service.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @GetMapping
    public List<Payment> getPayments(){

        return repository.findAll();
    }
}