/**
 * Sends email notifications to users based on budget activity or reminders.
 */

public class EmailNotifier implements INotificationService {
    public void send(String message, String recipient) {
        System.out.println("Sending Email to " + recipient + ": " + message);
    }
}

