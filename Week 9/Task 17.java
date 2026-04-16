import java.util.*;

class InsufficientStockException extends Exception {
    InsufficientStockException(String msg) {
        super(msg);
    }
}

public class Task17 {
    static void processOrder(int id, int qty, int stock) throws InsufficientStockException {
        if (qty > stock)
            throw new InsufficientStockException("Order " + id + " failed: Insufficient stock");
        System.out.println("Order " + id + " processed successfully");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String product = sc.next();
            int qty = sc.nextInt();
            int stock = sc.nextInt();

            try {
                processOrder(id, qty, stock);
            } catch (InsufficientStockException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}