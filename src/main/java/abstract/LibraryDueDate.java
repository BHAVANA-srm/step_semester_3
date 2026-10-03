import java.util.*;
import java.time.LocalDate;

interface LibraryItem {
    LocalDate calculateDueDate();
}

class Book implements LibraryItem {
    public LocalDate calculateDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(14);
    }
}

class DVD implements LibraryItem {
    public LocalDate calculateDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(7);
    }
}

class Magazine implements LibraryItem {
    public LocalDate calculateDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(3);
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int space = line.indexOf(' ');

            String type = line.substring(0, space);
            String title = line.substring(space + 1);

            title = title.replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book();
            } else if (type.equals("DVD")) {
                item = new DVD();
            } else {
                item = new Magazine();
            }

            LocalDate dueDate = item.calculateDueDate();

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}