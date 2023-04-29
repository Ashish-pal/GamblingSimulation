import java.util.Random;
import java.util.Scanner;

public class GamblingSimulatorMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulation");
        int startingStake = 100;
        int bet = 1;
        int daysPlayed = 0;
        int totalGamesPlayed = 0;
        int totalGamesWon = 0;
        int totalAmountWon = 0;
        int daysWon = 0;
        int daysLost = 0;
        int luckiestDay = 0;
        int unluckiestDay = 0;
        int maxAmountWon = Integer.MIN_VALUE;
        int minAmountWon = Integer.MAX_VALUE;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        while (daysPlayed < 30) {
            int stake = startingStake;
            int gamesPlayed = 0;
            int gamesWon = 0;

            while (stake > 0 && stake < 1000) {
                gamesPlayed++;
                totalGamesPlayed++;
                boolean win = rand.nextBoolean();
                if (win) {
                    stake += bet;
                    gamesWon++;
                    totalGamesWon++;
                } else {
                    stake -= bet;
                }
            }

            int amountWon = (gamesWon * bet) - (gamesPlayed - gamesWon) * bet;
            totalAmountWon += amountWon;

            if (amountWon > 0) {
                daysWon++;
            } else {
                daysLost++;
            }

            if (amountWon > maxAmountWon) {
                maxAmountWon = amountWon;
                luckiestDay = daysPlayed + 1;
            }
            if (amountWon < minAmountWon) {
                minAmountWon = amountWon;
                unluckiestDay = daysPlayed + 1;
            }

            System.out.println("Day " + (daysPlayed + 1) + ": Games played = " + gamesPlayed + ", Games won = " + gamesWon + ", Amount won = $" + amountWon);
            daysPlayed++;

            if (totalAmountWon > 500) {
                System.out.println("Congratulations! You have won more than $500. Do you want to continue playing for the next month? (y/n)");
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("n")) {
                    break;
                }
                totalAmountWon = 0;
            }
        }
        System.out.println("Total games played: " + totalGamesPlayed);
        System.out.println("Total games won: " + totalGamesWon);
        System.out.println("Total amount won or lost: $" + totalAmountWon);
        System.out.println("Days won: " + daysWon);
        System.out.println("Days lost: " + daysLost);
        System.out.println("Luckiest day: Day " + luckiestDay + " (Amount won: $" + maxAmountWon + ")");
        System.out.println("Unluckiest day: Day " + unluckiestDay + " (Amount lost: $" + minAmountWon + ")");
    }
}
