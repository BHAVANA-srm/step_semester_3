import java.util.*;

interface Employee {
    double calculateBonus();
}

class FullTime implements Employee {
    private double salary;

    FullTime(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime implements Employee {
    private double salary;

    PartTime(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern implements Employee {
    private double salary;

    Intern(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            if (type.equals("FULLTIME")) {
                employee = new FullTime(salary);

            } else if (type.equals("PARTTIME")) {
                employee = new PartTime(salary);

            } else {
                employee = new Intern(salary);
            }

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);

            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);

        sc.close();
    }
}