import java.util.Scanner;


public class HangmanTest {
    public static void main(String[] args)  {
        

        // Variables
        Hangman hangmanGame;
        char letter;
        int numOfOccurence;

        // Initialize variables
        hangmanGame = new Hangman();
        letter = ' ';
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to hangman game! Good luck!");
        System.out.println("You are going to guess this " + hangmanGame.getKnownSoFar().length() + " letter word: " + hangmanGame.getKnownSoFar());
        System.out.println("You have " + hangmanGame.getMaxAllowedIncorrectTries() + " left.");

        while (!hangmanGame.isGameOver()) {
            // Guess a letter
            System.out.print("Guess a letter: ");
            letter = scan.next().charAt(0);

            // Try the given letter and find how many times it occurs
            numOfOccurence = hangmanGame.tryThis(letter);

            // If the given letter does not exist in the string print an error message accoordingly.
            if (numOfOccurence == 0) {
                System.out.println("This letter does not exist in the word! Try again.");
            }

            // If it exists, print a success message accoordingly
            else {
                System.out.println("You guessed it right! Well done.");
            }

            System.out.println("You are going to guess this " + hangmanGame.getKnownSoFar().length() + " letter word: " + hangmanGame.getKnownSoFar());
            System.out.println("You have " + (hangmanGame.getMaxAllowedIncorrectTries() - hangmanGame.getNumOfIncorrectTries()) + " lives left.");
            System.out.println("The letters you tried are: " + hangmanGame.getUsedLetters());
            System.out.println("\n" + hangmanGame.tryThis(letter));
            System.out.println("\n -----------------------------------------------");
            
        }   

        // After a game ends, print whether the player won or lost
        if (!hangmanGame.hasLost() && hangmanGame.isGameOver()) {
            System.out.println("You have won. Well played.");
            
        }
        else {
            System.out.println("You have lost. Better luck next time :)");
        }

        scan.close();
    }
    
    
}
