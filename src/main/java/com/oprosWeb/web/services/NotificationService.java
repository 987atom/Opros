package com.oprosWeb.web.services;

import com.oprosWeb.web.models.NotificationModel;

import java.util.List;

public interface NotificationService {
    NotificationModel saveNotification(NotificationModel notification);
    NotificationModel getNotificationById(Long notificationId);
    List<NotificationModel> getAllNotifications();
    NotificationModel updateNotification(NotificationModel notification);
    void deleteNotification(Long notificationId);
}
