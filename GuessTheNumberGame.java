import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    // Defining ANSI escape codes for colored text 
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_ORANGE = "\u001B[38;5;208m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalRoundsPlayed = 0;
        int totalRoundsWon = 0;

        while (playAgain) {
            totalRoundsPlayed++;

            System.out.println(ANSI_GREEN + "************************************** Welcome to the Guess the Number Game! ****************************************8" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "# I have generated a random number between 1 and 100." + ANSI_RESET);
            System.out.println(ANSI_GREEN + "# You have 5 attempts to guess the number correctly." + ANSI_RESET);

            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 5;
            boolean guessedCorrectly = false;

            while (attempts > 0) {
                System.out.print(ANSI_YELLOW + "Enter your guess (Attempts left: " + attempts + "): " + ANSI_RESET);
                int userGuess = scanner.nextInt();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println(ANSI_YELLOW + "Please guess a number within the range of 1 to 100." + ANSI_RESET);
                    continue;
                }

                attempts--;

                int difference = Math.abs(userGuess - numberToGuess);

                if (userGuess < numberToGuess) {
                    if (difference <= 5) {
                        System.out.println(ANSI_GREEN + "Very close! Just a little higher!" + ANSI_RESET);
                    } else if (difference <= 10) {
                        System.out.println(ANSI_ORANGE+ "Getting warmer! A bit higher." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Too low!" + ANSI_RESET);
                    }
                } else if (userGuess > numberToGuess) {
                    if (difference <= 5) {
                        System.out.println(ANSI_GREEN + "Very close! Just a little lower!" + ANSI_RESET);
                    } else if (difference <= 10) {
                        System.out.println(ANSI_ORANGE + "Getting warmer! A bit lower." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Too high!" + ANSI_RESET);
                    }
                } else {
                    System.out.println(ANSI_GREEN + "***** Correct! You've guessed the number.*****" + ANSI_RESET);
                    guessedCorrectly = true;
                    break;
                }
            }

            if (guessedCorrectly) {
                totalRoundsWon++;
            } else {
                System.out.println(ANSI_RED + "Sorry, you've run out of attempts. The correct number was " + numberToGuess + ANSI_RESET);
            }

            System.out.print(ANSI_YELLOW + "Do you want to play again? (y/n): " + ANSI_RESET);
            playAgain = scanner.next().equalsIgnoreCase("y");
        }

        System.out.println(ANSI_GREEN + "***Thank you for playing!****" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "# Total rounds played: " + totalRoundsPlayed + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "# Total rounds won: " + totalRoundsWon + ANSI_RESET);
        scanner.close();
    }
}