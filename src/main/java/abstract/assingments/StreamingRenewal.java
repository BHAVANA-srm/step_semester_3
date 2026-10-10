import java.util.*;
import java.time.LocalDate;

interface Subscription {
    LocalDate calculateRenewalDate();
}

class Basic implements Subscription {
    private LocalDate startDate;

    Basic(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class Standard implements Subscription {
    private LocalDate startDate;

    Standard(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class Premium implements Subscription {
    private LocalDate startDate;

    Premium(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            Subscription subscription;

            if (type.equals("BASIC")) {
                subscription = new Basic(startDate);

            } else if (type.equals("STANDARD")) {
                subscription = new Standard(startDate);

            } else {
                subscription = new Premium(startDate);
            }

            LocalDate renewalDate =
                    subscription.calculateRenewalDate();

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}