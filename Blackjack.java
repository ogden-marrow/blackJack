import java.util.Arrays;
import java.util.Scanner;


import static java.lang.System.exit;

class GameStats{
    private int wins;
    private int losses;
    private int totalGames;
}

public class Blackjack {
    public static void main(String[] args) {
        // Start initialize variables
        P1Random rng = new P1Random();
        int[] hand = new int[0];
        String menuChose = "1";
        GameStats gameStats = new GameStats();
        // End initialize variables
        hand = dArray(hand,rng.nextInt(13)+1);
        startUP(hand);
        while (true) {
            PrintMenu();
            menuChose = TakeInput();
            // This switch is the main part of the program. Basically I have it set to call the functions when they are required. It also handles the exit function.
            switch (menuChose) {
                case "1":
                    hand = dArray(hand,rng.nextInt(13)+1);
                    System.out.println("Your card is: " + hand[hand.length-1]+"!");
                    System.out.println("Your hand is: " + Arrays.stream(hand).parallel().reduce(0, (a, b)-> a+b)+"!");
                    break;
                case "2":
                    HoldHand();
                    break;
                case "3":
                    PrintStatistics();
                    break;
                case "4":
                    Exit();
                    break;
                default:
                    System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.");
                    break;
            }
        }
    }

    public static int[] dArray(int[] array, int num) {
        // this function is used to add dynamic array functionality to the problem
        int[] newArray = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = num;
        return newArray;
    }

    public static void startUP(int[] hand) {
        // print welcome message
        // This function is completed and does not need to be modified.
        System.out.println("START GAME #1");
        System.out.println("Your card is: " + hand[0]+"!");
        System.out.println("Your hand is: " + Arrays.stream(hand).parallel().reduce(0, (a, b)-> a+b)+"!");
    }
    public static void PrintMenu() {
        // print menu
        // This function is completed and does not need to be modified.
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
    }
    public static void PrintStatistics() {
        // print statistics
        // This function needs to be completed.
        System.out.println("Print statistics");
    }

    public static void HoldHand() {
        // hold hand
        // This function needs to be completed.
        System.out.println("Hold hand");
    }
    public static String TakeInput() {
        // take input
        // This function needs to be completed.
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
    public static void Exit() {
        // exit
        // This function is completed and does not need to be modified.
        exit(0);
    }
}
