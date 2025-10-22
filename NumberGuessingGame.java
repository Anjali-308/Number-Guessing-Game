import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");
        System.out.println("You have 7 attempts per round.\n");

        while (playAgain) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 7;
            boolean guessedCorrectly = false;

            for (int i = 1; i <= attempts; i++) {
                System.out.print("Attempt " + i + " - Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number in " + i + " attempts!");
                    int score = (attempts - i + 1) * 10;
                    totalScore += score;
                    System.out.println("You earned " + score + " points this round.");
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("\nYour total score so far: " + totalScore);
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = sc.next().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("\n Game Over!");
                System.out.println("Your Final Score: " + totalScore);
                System.out.println("Thanks for playing!");
            }
            System.out.println();
        }

        sc.close();
    }
}
