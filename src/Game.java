import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Game {
    int wrongGuess;
    char[] wrongGuessBuffer;
    int correctGuess;
    char[] correctGuessBuffer;
    String movieName;
    char guess;

    public Game(String movieName)
    {
        this.movieName = new String(movieName);
        this.wrongGuess = 0;
        this.correctGuess = 0;
        correctGuessBuffer = new char[this.movieName.length()];
        wrongGuessBuffer = new char[10];
        Arrays.fill(wrongGuessBuffer,' ');
        Arrays.fill(correctGuessBuffer, '_');

        System.out.print("You are guessing: ");
        for(int i = 0;i < movieName.length();i++)
        {
            System.out.print(correctGuessBuffer[i]);
        }
        System.out.println();
        printPart2();
    }

    public void getGuessLetter()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Guess a letter: ");
        guess = input.nextLine().charAt(0);
    }

    public boolean isCorrectGuess()
    {
        int wrongCount = 0;
        for(int idx = 0;idx < movieName.length();idx++)
        {
            if(guess == movieName.charAt(idx))
            {
                if(correctGuessBuffer[idx] != guess)
                {
                    correctGuessBuffer[idx] = guess;
                    correctGuess++;
                }

            }
            else
            {
                int flag = 0;
                for(int j = 0;j < wrongGuess;j++)
                {
                    if(guess == wrongGuessBuffer[j])
                    {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0)
                    wrongCount++;
            }
        }

        if(wrongCount == movieName.length())
            return false;
        else
            return true;
    }



    public void printPart2()
    {
        System.out.print("You have guessed (" + wrongGuess + ") wrong letters:");
        for(int i = 0;i < wrongGuess;i++)
        {
            System.out.print(' ');
            System.out.print(wrongGuessBuffer[i]);
        }
        System.out.println();
    }

    public void printPart1()
    {
        System.out.print("You are guessing: ");
        for(int i = 0;i < movieName.length();i++)
        {
            System.out.print(correctGuessBuffer[i]);
        }
        System.out.println();
    }
}
