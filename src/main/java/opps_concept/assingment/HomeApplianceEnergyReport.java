package opps_concept.assingment;


import java.util.*;

interface SaverMode {
    double getSaverUnits(double units);
}

abstract class Appliance {
    double hours;
    static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    public double getSaverUnits(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    public double getSaverUnits(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Appliance[] appliances = new Appliance[n];
        String[] names = new String[n];
        boolean[] saver = new boolean[n];
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            double hours = sc.nextDouble();

            String mode = "";
            if (sc.hasNextLine()) {
                mode = sc.nextLine().trim();
            }

            saver[i] = mode.equals("SAVER");

            switch (names[i]) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AC(hours);
                    break;
                case "TV":
                    appliances[i] = new TV(hours);
                    break;
                case "WASHER":
                    appliances[i] = new Washer(hours);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            Appliance a = appliances[i];

            if (saver[i] && !(a instanceof SaverMode)) {
                System.out.println(
                    names[i] + ": saver mode not supported"
                );
                continue;
            }

            double units = a.calculateUnits();

            if (saver[i]) {
                units = ((SaverMode) a).getSaverUnits(units);
            }

            double cost = a.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                names[i], units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}

