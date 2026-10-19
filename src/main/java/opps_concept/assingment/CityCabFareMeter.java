package opps_concept.assingment;


import java.util.*;

interface NightService {
    double applyNightFare(double fare);
}

abstract class Cab {
    double km;
    static final double MIN_FARE = 100.0;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {
        return Math.max(km * getRate(), MIN_FARE);
    }
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10.0;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14.0;
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18.0;
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] types = new String[n];
        String[] times = new String[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            types[i] = sc.next();
            double km = sc.nextDouble();
            times[i] = sc.next();

            switch (types[i]) {
                case "MINI":
                    cabs[i] = new Mini(km);
                    break;
                case "SEDAN":
                    cabs[i] = new Sedan(km);
                    break;
                case "SUV":
                    cabs[i] = new SUV(km);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            Cab cab = cabs[i];

            if (times[i].equals("NIGHT")
                    && !(cab instanceof NightService)) {
                System.out.println(
                    types[i] + ": night service not available"
                );
                continue;
            }

            double fare = cab.calculateFare();

            if (times[i].equals("NIGHT")) {
                fare = ((NightService) cab).applyNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", types[i], fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

