import java.util.*;

class Payment {
    String processPayment(double amount) {
        return "";
    }
}

class CreditCardPayment extends Payment {
    String processPayment(double amount) {
        double total = amount * 1.02;
        return String.format("Processed CreditCard payment: Total Amount = %.2f", total);
    }
}

class PayPalPayment extends Payment {
    String processPayment(double amount) {
        double total = amount + 1.50;
        return String.format("Processed PayPal payment: Total Amount = %.2f", total);
    }
}

class UPIPayment extends Payment {
    String processPayment(double amount) {
        return String.format("Processed UPI payment: Total Amount = %.2f", amount);
    }
}

public class Task15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            double amount = sc.nextDouble();

            if (type == 'C')
                list.add(new CreditCardPayment());
            else if (type == 'P')
                list.add(new PayPalPayment());
            else
                list.add(new UPIPayment());

            System.out.println(list.get(i).processPayment(amount));
        }
    }
}