import java.util.Random;

public class GamblingSimulatorMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulation");
        int startingStake = 100;
        int bet = 1;
        int daysPlayed = 0;
        int totalGamesPlayed = 0;
        int totalGamesWon = 0;
        int totalAmountWon = 0;
        Random rand = new Random();

        while (daysPlayed < 20) {
            int stake = startingStake;
            int gamesPlayed = 0;
            int gamesWon = 0;

            while (stake > 0 && stake < 200 && stake > 50 && stake < 150) {
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
            System.out.println("Day " + (daysPlayed + 1) + ": Games played = " + gamesPlayed + ", Games won = " + gamesWon + ", Amount won = $" + amountWon);
            daysPlayed++;
        }
        System.out.println("Total games played: " + totalGamesPlayed);
        System.out.println("Total games won: " + totalGamesWon);
        System.out.println("Total amount won or lost: $" + totalAmountWon);
    }
}