import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game! 🎮");
        System.out.println("I'll generate a number, and you'll try to guess it.");

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int maxAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("\n--- New Round ---");
            System.out.println("I've generated a number between " + lowerBound + " and " + upperBound + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts.");
                    hasGuessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1); // Scoring based on attempts left
                    roundsWon++;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("\nSorry, you've run out of attempts. The number was " + numberToGuess + ".");
            }

            System.out.println("Your current score is: " + totalScore + " out of a possible " + (maxAttempts * (roundsWon + 1)) + ".");
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("\n--- Game Over ---");
        System.out.println("Thanks for playing! You won " + roundsWon + " round(s). Your final score is " + totalScore + ".");
        scanner.close();
    }
}