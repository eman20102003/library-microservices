package payment_service;

import payment_service.entity.Payment;
import payment_service.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @Autowired
    private PaymentRepository repository;

    @KafkaListener(
            topics = "payment-topic",
            groupId = "payment-group"
    )
    public void consume(String message){

        System.out.println(
                "Payment Processed: "
                        + message
        );

        Payment payment =
                new Payment();

        payment.setPaymentStatus(
                "PAID"
        );

        payment.setAmount(50);

        repository.save(payment);
    }
}