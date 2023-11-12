import java.util.Random;
import java.util.Scanner;

class NumberGuessing {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        Random number = new Random();
        int Randomnumber = number.nextInt(100) + 1;
        int attempts = 5;
        boolean hasWon = false;

        System.out.println("Welcome to the Number Guessing Game! ");
        System.out.println("Please choose a number between 1 and 100.");
        System.out.println("You have " + attempts + " attempts.");

        while (attempts > 0) {
            System.out.println("Enter your guess:");
            int guess = input.nextInt();
            attempts--;

            if (guess == Randomnumber) {
                hasWon = true;
                break;
            } else if (guess > Randomnumber) {
                System.out.println("guess number is too high!.please guess again");
            } else if (guess < Randomnumber) {
                System.out.println("guess number is too low!.please guess again.");
            }
        }

        if (hasWon) {
            System.out.println("Congrajulations you have guessed the number right");
        } else {
            System.out.println("sorry you have reached maximum attempts.the Randomnumber is" + Randomnumber + ".");
        }

        System.out.println("Do you want to play again(y/n):");
        String playagain = input.next();

        if (playagain.equalsIgnoreCase("y")) {
            main(null);
        } else {
            System.out.println("Thanks for playing!");
        }

    }
}