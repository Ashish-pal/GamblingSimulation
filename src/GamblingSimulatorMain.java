import java.util.Random;

public class GamblingSimulatorMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Simulation");
        int stake = 100;
        int bet = 1;
        int gamesPlayed = 0;
        int gamesWon = 0;
        Random rand = new Random();

        while (stake > 0 && stake < 200 && stake > 50 && stake < 150)  {
            gamesPlayed++;
            boolean win = rand.nextBoolean();
            if (win) {
                stake += bet;
                gamesWon++;
            } else {
                stake -= bet;
            }
        }

        System.out.println("Games played: " + gamesPlayed);
        System.out.println("Games won: " + gamesWon);
        System.out.println("Final stake: $" + stake);
    }
}
