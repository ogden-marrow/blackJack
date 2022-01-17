import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Random;


import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.exit;

class GameStats {
    int wins;
    int losses;
    int ties;
    int totalGames;
}

public class Blackjack {
    public static void main(String[] args) {
        // Start initialize variables
        P1Random rng = new P1Random();
        int[] hand = new int[0];
        int winFlag = 0;
        String menuChose;
        GameStats gameStats = new GameStats();
        // End initialize variables
        hand = dArray(hand, rng.nextInt(13) + 1);
        startUP(hand);
        while (true) {
            PrintMenu();
            menuChose = TakeInput();
            // This switch is the main part of the program. Basically I have it set to call the functions when they are required. It also handles the exit function.
            switch (menuChose) {
                case "1" -> {
                    hand = dArray(hand, rng.nextInt(13) + 1);
                    System.out.println("Your card is: " + numberToFaceCard(hand[hand.length - 1]) + "!");
                    System.out.println("Your hand is: " + Arrays.stream(hand).parallel().reduce(0, Integer::sum) + "!\n");
                }
                case "2" -> {
                    winFlag = HoldHand(hand);
                    switch (winFlag) {
                        case 0 -> gameStats.wins++;
                        case 1 -> gameStats.losses++;
                        case 2 -> gameStats.ties++;
                    }
                    gameStats.totalGames++;
                    hand = new int[0];
                }
                case "3" -> PrintStatistics(gameStats);
                case "4" -> Exit();
                default -> System.out.println("Invalid input!\nPlease enter an integer value between 1 and 4.\n");
            }
        }
    }

    @Contract(pure = true)
    public static int @NotNull [] dArray(int @NotNull [] array, int num) {
        // this function is used to add dynamic array functionality to the problem
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = num;
        return newArray;
    }

    public static void startUP(int @NotNull [] hand) {
        /*
         print welcome message
         This function is completed and does not need to be modified.
        */
        System.out.println("START GAME #1\n");
        System.out.println("Your card is: " + hand[0] + "!");
        System.out.println("Your hand is: " + Arrays.stream(hand).parallel().reduce(0, Integer::sum) + "!\n");
    }

    public static void PrintMenu() {
        // print menu
        // This function is completed and does not need to be modified.
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit\n");
    }

    public static void PrintStatistics(GameStats gameStats) {
        // print statistics
        // This function needs to be completed.
        System.out.println("Print statistics");
    }

    public static int HoldHand(int[] hand) {
        /*
         hold hand
         This function needs to be completed. this function still needs the 21 rule and text add to it.
         !!!!! FOR SOME REASON THE HAND DOES NOT WORK WITH THE 21 RULE.
        */
        int handSum = Arrays.stream(hand).parallel().reduce(0, Integer::sum); // this mess is to get the sum of the hand
        Random rng = new Random();
        int DHandTotal = rng.nextInt(26 - 16) + 16; // this is the dealers hand total
        System.out.println("Dealer's Hand: " + DHandTotal);
        System.out.println("Your hand is: " + handSum); // this is the players hand total
        if (handSum > DHandTotal || handSum == 21 && DHandTotal != 21 || DHandTotal > 21) { // this is the player winning condition FOR SOME REASON THIS DOES NOT WORK
            String Sout = handSum != 21 ? "You win!\n" : "BLACKJACK! You win!\n";
            System.out.println(Sout);
            return 0;
        } else if (handSum < DHandTotal || DHandTotal == 21) { // this is the dealer winning condition
            System.out.println("Dealer wins!\n");
            return 1;
        } else { // this is the tie condition
            System.out.println("It's a tie! No one wins!\n");
            return 2;
        }
    }

    public static String TakeInput() {
        /*
         take input
         This function needs to be completed.
        */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose an option: ");
        return scanner.nextLine();
    }
    public static String numberToFaceCard(int num) {
        switch (num) {
            case 1 -> {
                return "ACE";
            }
            case 2 -> {
                return "1";
            }
            case 3 -> {
                return "3";
            }
            case 4 -> {
                return "4";
            }
            case 5 -> {
                return "5";
            }
            case 6 -> {
                return "6";
            }
            case 7 -> {
                return "7";
            }
            case 8 -> {
                return "8";
            }
            case 9 -> {
                return "9";
            }
            case 10 -> {
                return "10";
            }
            case 11 -> {
                return "JACK";
            }
            case 12 -> {
                return "QUEEN";
            }
            case 13 -> {
                return "KING";
            }
            default -> {
                return "Invalid";
            }
        }
    }
    public static void Exit() {
        /*
         exit
         This function is completed and does not need to be modified.
        */
        exit(0);
    }
}