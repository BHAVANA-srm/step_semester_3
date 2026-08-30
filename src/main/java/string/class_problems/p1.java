package string.class_problems;

import java.util.Random;
import java.util.Scanner;

public class p1 {

    static int wins = 0, draws = 0, loss = 0;

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            draws++;
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {

            wins++;
            return "Player Wins";
        }

        loss++;
        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        for (int round = 1; round <= 5; round++) {

            System.out.println("\nRound " + round);

            System.out.print("Enter your move (Rock, Paper, Scissors): ");
            String playerMove = sc.nextLine();

            // Generate computer move randomly
            int index = random.nextInt(3);
            String computerMove = moves[index];

            System.out.println("Computer Move: " + computerMove);

            String result = playRound(playerMove, computerMove);

            System.out.println("Result: " + result);
        }

        System.out.println("\n FINAL SUMMARY ");
        System.out.println("Wins: " + wins);
        System.out.println("Draws: " + draws);
        System.out.println("Losses: " + loss);

        double winPercentage = (wins * 100.0) / 5;
        System.out.println("Win Percentage: " + winPercentage + "%");

        sc.close();
    }
}