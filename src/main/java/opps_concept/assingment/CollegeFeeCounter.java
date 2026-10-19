package opps_concept.assingment;


import java.util.*;

abstract class Student {
    String name;
    static final double TUITION = 40000.0;
    static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    abstract boolean usesBus();

    double calculateFee() {
        double fee = calculateTuition();

        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }

        return fee;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return TUITION;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return TUITION + 60000.0;
    }

    boolean usesBus() {
        return false;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return TUITION / 2;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    students[i] = new Scholar(name);
                    break;
            }
        }

        for (Student s : students) {
            double fee = s.calculateFee();
            System.out.printf("%s: %.2f%n", s.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}

