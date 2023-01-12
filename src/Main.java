import java.io.FileReader;
import java.io.*;
import java.util.*;



public class Main {
    static String movieName = new String();

    public static void main(String[] args) {
        welcomeNote();
        movieName = getMovieName();
        playGame();
    }

    public static void welcomeNote() {
        System.out.println("Java GuessTheMovie\n" +
                "You have got 10 attempts.\n" +
                "Each wrong letter is -1 attempt for you.\n" +
                "Try to guess the movie title!\n" +
                "Spaces are also a letter ;)");
    }

    public static String getMovieName() {
        try {
            movieName = getRandomMovie(new File("movies.txt"));
        } catch (FileNotFoundException fe) {
            System.out.println("File not found");
        }

        return movieName;
    }

    public static String getRandomMovie(File file) throws FileNotFoundException {
        String randomMovieName = null;
        Random rand = new Random();
        int count = 0;
        for (Scanner sc = new Scanner(file); sc.hasNext(); ) {
            count += 1;
            String line = sc.nextLine();
            if (rand.nextInt(count) == 0)
                randomMovieName = line;
        }
        return randomMovieName;
    }

    public static void printWiningNote() {
        System.out.println("You Win!");
        System.out.println("You have guessed '" + movieName + "' correctly.");
    }

    public static void printLosingNote() {
        System.out.println("You Lose!");
        System.out.println("You failed to guess '" + movieName + "'.");
    }

    public static void playGame() {
        Game guessTheMovie = new Game(movieName);

        while (guessTheMovie.wrongGuess < 10 && guessTheMovie.correctGuess < movieName.length()) {
            guessTheMovie.getGuessLetter();

            if (!guessTheMovie.isCorrectGuess()) {
                guessTheMovie.wrongGuessBuffer[guessTheMovie.wrongGuess] = guessTheMovie.guess;
                guessTheMovie.wrongGuess++;
            }

            if (guessTheMovie.correctGuess < movieName.length()) {
                guessTheMovie.printPart1();
                guessTheMovie.printPart2();
            }
        }

        if (guessTheMovie.correctGuess == movieName.length())
            printWiningNote();
        else
            printLosingNote();
    }
}
