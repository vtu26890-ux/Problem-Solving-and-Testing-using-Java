import java.util.*;

interface Notification {
    void sendNotification(String message);
}

class EmailNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Email notification: " + message);
    }
}

class SMSNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent SMS notification: " + message);
    }
}

class PushNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Push notification: " + message);
    }
}

public class Task16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            String message = sc.next();

            Notification obj;

            if (type == 'E')
                obj = new EmailNotification();
            else if (type == 'S')
                obj = new SMSNotification();
            else
                obj = new PushNotification();

            obj.sendNotification(message);
        }
    }
}