

import java.util.*;

class Attendance {
    static void attendanceSummary(int[] days) {
        int present = 0;
        int count = 0;
        int longest = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                present++;
                count++;

                if (count > longest) {
                    longest = count;
                }
            } else {
                count = 0;
            }
        }

        System.out.println("Present: " + present);
        System.out.println("Longest streak: " + longest);
    }

    public static void main(String[] args) {
        int[] days = {1, 1, 0, 1, 1, 1, 0, 1};

        attendanceSummary(days);
    }
}
