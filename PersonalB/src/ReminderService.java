/**
 * Manages reminders for due payments, budget reviews, or custom alerts.
 */

public class ReminderService {
    private INotificationService notificationService;

    public ReminderService(INotificationService service) {
        this.notificationService = service;
    }

    public void setReminder(String message, String email) {
        // placeholder for scheduling logic
        notifyUser(message, email);
    }

    public void notifyUser(String message, String email) {
        notificationService.send(message, email);
    }
}

