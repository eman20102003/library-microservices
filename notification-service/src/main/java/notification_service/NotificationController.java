package notification_service;

import notification_service.entity.Notification;

import notification_service.repository.NotificationRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRepository repository;

    @GetMapping
    public List<Notification>
    getNotifications(){

        return repository.findAll();
    }
}