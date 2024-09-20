package com.oprosWeb.web.services.impl;

import com.oprosWeb.web.models.NotificationModel;
import com.oprosWeb.web.repositories.NotificationRepository;
import com.oprosWeb.web.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationModel saveNotification(NotificationModel notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public NotificationModel getNotificationById(Long notificationId) {
        return notificationRepository.findById(notificationId).orElse(null);
    }

    @Override
    public List<NotificationModel> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public NotificationModel updateNotification(NotificationModel notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(Long notificationId) {
        notificationRepository.deleteById(notificationId);
    }
}
