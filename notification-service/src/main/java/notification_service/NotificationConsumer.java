package notification_service;

import notification_service.entity.Notification;

import notification_service.repository.NotificationRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;

import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    private NotificationRepository repository;

    @KafkaListener(
            topics = "notification-topic",
            groupId = "notification-group"
    )
    public void consume(String message){

        System.out.println(
                "Notification Received: "
                        + message
        );

        Notification notification =
                new Notification();

        notification.setMessage(
                message
        );

        notification.setStatus(
                "SENT"
        );

        repository.save(notification);
    }
}