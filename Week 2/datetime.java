
import java.time.*;
import java.util.*;

class Event {

    String name;
    LocalDate d;

    Event(String name, LocalDate d) {
        this.name = name;
        this.d = d;
    }

    static int compare(Event e1, Event e2) {
        return e1.d.compareTo(e2.d);
    }
}

public class datetime {

    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            LocalDate d = LocalDate.parse(sc.next());
            events.add(new Event(name, d));

        }
        events.stream().sorted(Event::compare).forEach(s -> System.out.print(s.name + " "));
        System.out.println();
        Event e = events.stream().sorted(Event::compare).findFirst().get();
        System.out.println(e.name);
        Event e1 = events.stream().sorted(Event::compare).skip(n - 1).findFirst().get();
        System.out.println(e1.name);
        n = sc.nextInt();
        for (Event e2 : events) {
            if (e2.d.getMonthValue() == n) {
                System.out.print(e2.name + " ");
            }
        }

    }
}
