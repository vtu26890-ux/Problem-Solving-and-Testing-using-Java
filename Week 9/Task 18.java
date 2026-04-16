import java.util.*;

class Account {
    int id;
    String name;
    double balance;

    Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
}

class Bank {
    Map<Integer, Account> accounts = new HashMap<>();

    void addAccount(Account acc) {
        accounts.put(acc.id, acc);
    }

    Account findAccount(int id) {
        return accounts.get(id);
    }

    void deposit(int id, double amount) {
        Account acc = findAccount(id);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        acc.balance += amount;
        System.out.println("Deposited " + (int)amount + " to " + acc.name);
    }

    void withdraw(int id, double amount) {
        Account acc = findAccount(id);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        if (acc.balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }
        acc.balance -= amount;
        System.out.println("Withdrawn " + (int)amount + " from " + acc.name);
    }

    void transfer(int fromId, int toId, double amount) {
        Account from = findAccount(fromId);
        Account to = findAccount(toId);

        if (from == null || to == null) {
            System.out.println("Account not found");
            return;
        }

        if (from.balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }

        from.balance -= amount;
        to.balance += amount;
        System.out.println("Transferred " + (int)amount + " from " + from.name + " to " + to.name);
    }
}

public class Task18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double bal = sc.nextDouble();
            bank.addAccount(new Account(id, name, bal));
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String op = sc.next();

            if (op.equals("DEPOSIT")) {
                int id = sc.nextInt();
                double amt = sc.nextDouble();
                bank.deposit(id, amt);
            } else if (op.equals("WITHDRAW")) {
                int id = sc.nextInt();
                double amt = sc.nextDouble();
                bank.withdraw(id, amt);
            } else if (op.equals("TRANSFER")) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                double amt = sc.nextDouble();
                bank.transfer(from, to, amt);
            }
        }
    }
}