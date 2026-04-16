import java.util.*;

class Vehicle {
    int vehicleId;
    String modelName;
    double baseRent;

    Vehicle(int id, String name, double rent) {
        this.vehicleId = id;
        this.modelName = name;
        this.baseRent = rent;
    }

    double calculateRent() {
        return baseRent;
    }
}

class Car extends Vehicle {
    int seats;

    Car(int id, String name, double rent, int seats) {
        super(id, name, rent);
        this.seats = seats;
    }

    double calculateRent() {
        return baseRent + (seats * 100);
    }
}

class Bike extends Vehicle {
    int engineCapacity;

    Bike(int id, String name, double rent, int cc) {
        super(id, name, rent);
        this.engineCapacity = cc;
    }

    double calculateRent() {
        return baseRent + (engineCapacity * 2);
    }
}

public class Task14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char type = sc.next().charAt(0);
            int id = sc.nextInt();
            String model = sc.next();
            double rent = sc.nextDouble();

            if (type == 'C') {
                int seats = sc.nextInt();
                list.add(new Car(id, model, rent, seats));
            } else {
                int cc = sc.nextInt();
                list.add(new Bike(id, model, rent, cc));
            }
        }

        for (Vehicle v : list) {
            System.out.println("Vehicle ID: " + v.vehicleId +
                    ", Model: " + v.modelName +
                    ", Total Rent: " + v.calculateRent());
        }
    }
}