/**
 * Defines the interface for sending user notifications.
 */

public interface INotificationService {
    void send(String message, String recipient);
}

